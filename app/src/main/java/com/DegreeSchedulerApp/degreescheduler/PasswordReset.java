package com.DegreeSchedulerApp.degreescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordReset extends AppCompatActivity {
    int passwordResetView = R.layout.activity_password_reset;
    Button button;
    EditText emailId;
    String emailPattern = "[a-zA-Z0-9._-]+@wayne+\\.edu+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(passwordResetView);
        button = findViewById(R.id.signUp);
        emailId = findViewById(R.id.emailId);
        button.setOnClickListener(v -> {
            if(emailId.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),"Enter WSU email address",Toast.LENGTH_SHORT).show();
            }
            else {
                if (emailId.getText().toString().trim().matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "Password  reset link sent to email address", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid WSU email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}