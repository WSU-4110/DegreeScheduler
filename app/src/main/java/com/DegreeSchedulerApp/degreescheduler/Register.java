package com.DegreeSchedulerApp.degreescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.text.InputType;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    int view = R.layout.activity_register;
    Button button;
    EditText emailId, password;
    CheckBox checkPassword, privacy;

    String emailPattern = "[a-zA-Z0-9._-]+@wayne+\\.edu+";
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);
        button = findViewById(R.id.signUp);
        emailId = findViewById(R.id.emailId);
        password = findViewById(R.id.etPassword);
        checkPassword = findViewById(R.id.showPassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailId.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Enter email address",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (emailId.getText().toString().trim().matches(emailPattern)) {
                        Toast.makeText(getApplicationContext(),"Valid email address",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    password.setInputType(129);
                }
            }
        });

    }
}