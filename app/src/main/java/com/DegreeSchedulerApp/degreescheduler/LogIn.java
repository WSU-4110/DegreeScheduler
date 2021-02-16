package com.DegreeSchedulerApp.degreescheduler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    int loginView = R.layout.activity_login;
    EditText username, password;
    CheckBox checkPassword;
    private Button sigInBtn, button, passwordReset;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(loginView);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        checkPassword = findViewById(R.id.showPassword);
        button = findViewById(R.id.btnSignUp);
        sigInBtn = findViewById(R.id.btnLogin);
        passwordReset = findViewById(R.id.forgotPassword);

        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else {
                    password.setInputType(129);
                }
            }
        });
        sigInBtn.setOnClickListener(v -> {
            if(username.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),"Enter user name",Toast.LENGTH_SHORT).show();
            }
            else {
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
    }
}