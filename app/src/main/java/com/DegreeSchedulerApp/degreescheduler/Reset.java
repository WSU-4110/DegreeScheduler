package com.DegreeSchedulerApp.degreescheduler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Reset extends AppCompatActivity {
    int resetView = R.layout.activity_reset;
    Button button;
    CheckBox checkPassword;
    EditText password, confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(resetView);
        button = findViewById(R.id.update);
        password = findViewById(R.id.etPassword);
        confirmPassword = findViewById(R.id.passwordConfirm);
        checkPassword = findViewById(R.id.showPassword);
        button.setOnClickListener(v -> {
            if(password.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),"Enter your new password",Toast.LENGTH_SHORT).show();
            }
            else {
                if(confirmPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Confirm your new password", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.getText().toString().equals( confirmPassword.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Password Updated!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password Does Not Match. Try Again!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    confirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    password.setInputType(129);
                    confirmPassword.setInputType(129);
                }
            }
        });
    }
}