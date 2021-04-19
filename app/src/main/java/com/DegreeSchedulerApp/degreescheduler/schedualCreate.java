package com.DegreeSchedulerApp.degreescheduler;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.DegreeSchedulerApp.degreescheduler.R;

public class schedualCreate extends AppCompatActivity implements View.OnClickListener {
    String crn;
    EditText textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedualcreate);
        textView = (EditText) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crn = textView.getText().toString();

                showToast(crn);
            }
        });
    }

    private void showToast(String crn) {
        Toast.makeText(schedualCreate.this,crn,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }
}
