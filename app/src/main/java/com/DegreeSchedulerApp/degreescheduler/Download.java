package com.DegreeSchedulerApp.degreescheduler;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.DegreeSchedulerApp.degreescheduler.databinding.ActivityDownloadBinding;


public class Download extends AppCompatActivity {
    //Initializing variables
    ActivityDownloadBinding binding;
    private static final int PERMISSION_STORAGE_CODE = 100;
    Button downloadBtn;
    TextView termCond;
    CheckBox consent;
    public static final String imageUrl ="https://th.bing.com/th/id/R7352f102bef51d03dd39181513831cea?rik=TYsBpvy3k15xiQ&pid=ImgRaw";
    String imageName = "SampleSchedule.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDownloadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //initialize views with xml
        downloadBtn = findViewById(R.id.download_Btn);
        termCond = findViewById(R.id.termsConditions);
        consent = findViewById(R.id.consentBox);

        binding.termsConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show_dialog();
            }
        });

        //handle button click
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (consent.isChecked()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                            //permission denied, request it
                            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                            requestPermissions(permissions, PERMISSION_STORAGE_CODE);
                        }
                        else {
                            //permission already granted, perform download
                            startDownloading(imageUrl, imageName);
                        }
                    }
                    else {
                        //system os is less than marshmallow, perform download
                        startDownloading(imageUrl, imageName);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Check the box to proceed", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void startDownloading(String url, String outputFileName){

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle(imageName);
        request.setDescription("Downloading" + imageName);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.allowScanningByMediaScanner();
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, outputFileName);
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }


    //handle permission result


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                    //permission granted from popup, performed download
                    startDownloading(imageUrl,imageName);
                }
                else{
                    //permission denied from popup, show error message
                    Toast.makeText(this, "Permission denied..!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void show_dialog()
    {
        AlertDialog.Builder alert= new AlertDialog.Builder(this);

        WebView wv = new WebView(this);
        wv.loadUrl("file:///android_asset/TermsCondition.html");
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });

        alert.setView(wv);
        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }
}