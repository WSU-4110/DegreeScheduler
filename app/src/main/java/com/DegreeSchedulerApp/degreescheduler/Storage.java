package com.DegreeSchedulerApp.degreescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Storage extends AppCompatActivity {



        public static void main(String[] args) {
            try {
                Properties properties = new Properties();
                properties.setProperty("Username", "accessID");
                properties.setProperty("Password", "passwd");
                properties.setProperty("Email", "email");
                properties.setProperty("ID", "ID");

                File file = new File("Password.properties");
                FileOutputStream fileOut = new FileOutputStream(file);
                properties.store(fileOut, "User Information");
                fileOut.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_storage);
//    }
}