package com.DegreeSchedulerApp.degreescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private Button createSched, viewDownSched, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        createSched = (Button) findViewById(R.id.btnCreate);
        createSched.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateSchedule.class);
            startActivity(intent);
        });
        //createSched.setOnClickListener(this);

        viewDownSched = (Button) findViewById(R.id.btnDownView);
        viewDownSched.setOnClickListener(v -> {
            Intent intent = new Intent(this, Download.class);
            startActivity(intent);
        });

        contact = (Button) findViewById(R.id.btnShare);
        contact.setOnClickListener(v -> {
            Intent intent = new Intent(this, webview.class);
            startActivity(intent);

        });
    }

    @Override
    public void onClick(View v) {

    }
}