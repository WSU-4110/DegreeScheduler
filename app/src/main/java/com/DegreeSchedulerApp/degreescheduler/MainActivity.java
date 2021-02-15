package com.DegreeSchedulerApp.degreescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.DegreeSchedulerApp.degreescheduler.Data.DataBaseHelper;
import com.DegreeSchedulerApp.degreescheduler.Data.UserInformation;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserInformation user = new UserInformation("gn2289", "1234", "gn2289@wayne.edu", 1);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        dataBaseHelper.add(user);



    }

}