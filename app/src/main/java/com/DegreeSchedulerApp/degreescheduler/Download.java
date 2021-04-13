package com.DegreeSchedulerApp.degreescheduler;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Download extends AppCompatActivity {
    //Initializing variables
    private static final int PERMISSION_STORAGE_CODE = 1000;
    EditText mUrlEt;
    Button mDownloadBtn;
    TextView termsConds;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        //initialize views with xml
        mUrlEt = findViewById(R.id.urlEt);
        mDownloadBtn = findViewById(R.id.downloadUrl);
        termsConds = findViewById(R.id.termsConditions);
        wv = findViewById(R.id.webTermsCond);

        //handle button click
        mDownloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        //permission denied, request it
                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_STORAGE_CODE);
                    }
                    else {
                        //permission already granted, perform download
                        startDownloading();
                    }
                }
                else{
                    //system os is less than marshmallow, perform download
                    startDownloading();
                }

            }
        });
        termsConds.setOnClickListener(v -> {
            wv.loadUrl("file:///android_asset/TermsCondition.html");
        });
    }
    private void startDownloading(){
        //get url/text from edit text
        String url = mUrlEt.getText().toString().trim();

        //create download request
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //allow types of network to download files
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI |
                DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("com.DegreeSchedulerApp.degreescheduler.Download"); //set title in download notification
        request.setDescription("Downloading Schedule..."); //set description in download notification

        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+ System.currentTimeMillis());// get current timestamp as file name

        //get download service and enque file
        DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    //handle permission result


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    //permission granted from popup, performed download
                    startDownloading();
                }
                else{
                    //permission denied from popup, show error message
                    Toast.makeText(this, "Permission denied..!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}