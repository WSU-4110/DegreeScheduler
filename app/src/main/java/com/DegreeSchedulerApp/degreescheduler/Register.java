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
    EditText username, emailId, password, confirmPassword;
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
        confirmPassword = findViewById(R.id.passwordConfirm);
        checkPassword = findViewById(R.id.showPassword);
        privacy = findViewById(R.id.checkBox);
        username = findViewById(R.id.etUsername);
        button.setOnClickListener(v -> {
            if(emailId.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),"Enter email address",Toast.LENGTH_SHORT).show();
            }
            else {
                if (emailId.getText().toString().trim().matches(emailPattern)) {
                    if(username.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(),"Enter user name",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (password.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Enter your new password", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (confirmPassword.getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Confirm your new password", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                                    if(privacy.isChecked()) {
                                        Toast.makeText(getApplicationContext(), "Verification link sent to email address", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "Check the Terms and Condition to proceed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Password Does Not Match. Try Again!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                confirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                password.setInputType(129);
                confirmPassword.setInputType(129);
            }
        });

    }
}