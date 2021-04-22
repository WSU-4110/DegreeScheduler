package com.DegreeSchedulerApp.degreescheduler;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDao;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDatabase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class schedualCreate extends AppCompatActivity implements View.OnClickListener {
    String crn,crn1,crn2,crn3,crn4;
    EditText textView,textView1,textView2,textView5,textView4;
    Button button;
    @Override

    //onCreate is used to start activity
    //super is used to call the parent class constructor
    //setContentView is used to call xml file
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedualcreate);
        //Access the database
        ClassInfoDatabase classInfoDatabase = Room.databaseBuilder(this,
                ClassInfoDatabase.class,
                "CLASS_INFO.db").allowMainThreadQueries().build();
        //Query the class info
        ClassInfoDao classInfoDao = classInfoDatabase.getClassInfoDao();


        textView = (EditText) findViewById(R.id.textView);
        textView1 = (EditText) findViewById(R.id.textView1);
        textView2 = (EditText) findViewById(R.id.textView2);
        textView5 = (EditText) findViewById(R.id.textView5);
        textView4 = (EditText) findViewById(R.id.textView4);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v)  {
                crn = textView.getText().toString();
                crn1 = textView1.getText().toString();
                crn2 = textView2.getText().toString();
                crn3 = textView5.getText().toString();
                crn4 = textView4.getText().toString();
                showToast(crn + " Was the selected Crn");

                //Retrieve class info
                ClassInfo course = classInfoDao.getItemByCrn(crn);
                ClassInfo course1 = classInfoDao.getItemByCrn(crn1);
                ClassInfo course2 = classInfoDao.getItemByCrn(crn2);
                ClassInfo course3 = classInfoDao.getItemByCrn(crn3);
                ClassInfo course4 = classInfoDao.getItemByCrn(crn4);
                System.out.println(course.getCrn());
                System.out.println(course.getClassName());
                System.out.println(course.getClassNumber());
                System.out.println(course1.getCrn());
                System.out.println(course1.getClassName());
                System.out.println(course1.getClassNumber());
                System.out.println(course2.getCrn());
                System.out.println(course2.getClassName());
                System.out.println(course2.getClassNumber());
                System.out.println(course3.getCrn());
                System.out.println(course3.getClassName());
                System.out.println(course3.getClassNumber());
                System.out.println(course4.getCrn());
                System.out.println(course4.getClassName());
                System.out.println(course4.getClassNumber());
                //Adds class info to File
                try {
                    FileOutputStream fileout=openFileOutput("File.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    outputWriter.write(course.getClassNumber()+" "+course.getCrn()+" "+course.getClassName());
                    outputWriter.write(course1.getClassNumber() + " " + course1.getCrn() + " " + course1.getClassName() + "\n");
                    outputWriter.write(course2.getClassNumber() + " " + course2.getCrn() + " " + course2.getClassName() + "\n");
                    outputWriter.write(course3.getClassNumber() + " " + course3.getCrn() + " " + course3.getClassName() + "\n");
                    outputWriter.write(course4.getClassNumber() + " " + course4.getCrn() + " " + course4.getClassName() + "\n");
                    outputWriter.close();
                    //display file saved message
                    Toast.makeText(getBaseContext(), "File saved successfully!",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();

                }
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
