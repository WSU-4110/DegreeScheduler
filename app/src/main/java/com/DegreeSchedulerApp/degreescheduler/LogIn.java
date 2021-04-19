package com.DegreeSchedulerApp.degreescheduler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDao;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDatabase;
import com.DegreeSchedulerApp.degreescheduler.databinding.ActivityDownloadBinding;
import com.DegreeSchedulerApp.degreescheduler.databinding.ActivityLoginBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LogIn extends AppCompatActivity {
    ActivityLoginBinding binding;
    int loginView = R.layout.activity_login;
    EditText username, password;
    CheckBox checkPassword;
    TextView privacyBtn;
    private Button sigInBtn, button, passwordReset, startDb;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {

            ClassInfoDatabase classInfoDatabase = Room.databaseBuilder(this,
                    ClassInfoDatabase.class, "CLASS_INFO.db").allowMainThreadQueries().build();

            ClassInfoDao classInfoDao = classInfoDatabase.getClassInfoDao();

            classInfoDao.clearTheTable();


            final InputStream file = getAssets().open("classList.txt");
            Scanner scanner = new Scanner(file, "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //put each class into an array list
                List<String> currentLine = new LinkedList<String>(Arrays.asList(line.split(";")));

                System.out.println(currentLine);
                //create a new course
                ClassInfo classInfo = new ClassInfo();
                // int crn, name, number, start date, end data, days, description
                classInfo.setCrn(currentLine.get(0));
                classInfo.setClassName(currentLine.get(1));
                classInfo.setClassNumber(currentLine.get(2));
                classInfo.setStartDate(currentLine.get(3));
                classInfo.setEndDate(currentLine.get(4));
                classInfo.setDays(currentLine.get(5));
                classInfo.setDescription(currentLine.get(6));


                System.out.println("Inserting to db");

                classInfoDao.insert(classInfo);


                //clear the array list
                System.out.println("clearing list");
                currentLine.clear();
            }


            if (scanner.ioException() != null) {
                System.out.println("Building DB Error");
                throw scanner.ioException();
            }
        } catch (IOException ioException) {
            System.out.println("IO Exception");
            System.out.println(ioException.getMessage());

        }



        super.onCreate(savedInstanceState);
        setContentView(loginView);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        checkPassword = findViewById(R.id.showPassword);
        button = findViewById(R.id.btnSignUp);
        sigInBtn = findViewById(R.id.btnLogin);
        passwordReset = findViewById(R.id.forgotPassword);
        privacyBtn = findViewById(R.id.privacy);
        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    password.setInputType(129);
                }
            }
        });
        sigInBtn.setOnClickListener(v -> {
            if (username.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter user name", Toast.LENGTH_SHORT).show();
            } else {
                if (password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                } else {
//                    ****You need to see if the username and password matches from the database later***
                    Toast.makeText(getApplicationContext(), "You have successfully Logged In", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        });
        passwordReset.setOnClickListener(v -> {
            Intent intent = new Intent(this, PasswordReset.class);
            startActivity(intent);
        });
        binding.privacy.setOnClickListener(v -> {
                show_dialog();
        });

    }
    public void show_dialog(){
        AlertDialog.Builder alert= new AlertDialog.Builder(this);

        WebView wv = new WebView(this);
        wv.loadUrl("file:///android_asset/privacy.html");
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