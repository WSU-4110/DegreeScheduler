package com.DegreeSchedulerApp.degreescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import android.text.InputType;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.DegreeSchedulerApp.degreescheduler.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {
    ActivityRegisterBinding binding;
    int registerView = R.layout.activity_register;
    Button button;
    EditText username, emailId, password, confirmPassword;
    CheckBox checkPassword, privacy;
    String emailPattern = "[a-zA-Z0-9._-]+@wayne+\\.edu+";
    TextView termsCond;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        super.onCreate(savedInstanceState);
        setContentView(registerView);
        button = findViewById(R.id.signUp);
        emailId = findViewById(R.id.courseSearch);
        password = findViewById(R.id.etPassword);
        confirmPassword = findViewById(R.id.passwordConfirm);
        checkPassword = findViewById(R.id.showPassword);
        privacy = findViewById(R.id.checkBox);
        username = findViewById(R.id.etUsername);
        termsCond = findViewById(R.id.termsConditions);

        button.setOnClickListener(v -> {
            if(emailId.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),"Enter WSU email address",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getApplicationContext(),"Invalid WSU email address", Toast.LENGTH_SHORT).show();
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
        binding.termsConditions.setOnClickListener(v -> {
            show_dialog();
        });
    }
    public void show_dialog(){
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