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

        //This is a test for the first project demo
        //We can add more users using a constructor like this:
        //we can pull the data from the text boxes a user would type in
        UserInformation user = new UserInformation("gn2289", "1234", "gn2289@wayne.edu", 1);

        //Database helper is used to manipulate the database
        //this is were we can so far add new users
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        //here is how we can add a new user:
        dataBaseHelper.add(user);



    }

}