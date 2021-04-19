package com.DegreeSchedulerApp.degreescheduler;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDao;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InitDB extends Application {
    public void initDB() {



            try {
                final InputStream file = getAssets().open("classList.txt");
                Scanner scanner = new Scanner(file, "UTF-8");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    //put each class into an array list
                    List<String> currentLine = new LinkedList<String>(Arrays.asList(line.split(";")));

                    System.out.println(currentLine);
                    //create a new course
                    ClassInfo classInfo = new ClassInfo();
                    // int crn, name, number, start date, end data, days, description
                    classInfo.setCrn(currentLine.get(0));
                    classInfo.setClassName(currentLine.get(1));
                    classInfo.setClassNumber(currentLine.get(2));
                    classInfo.setStartDate(currentLine.get(3));
                    classInfo.setEndDate(currentLine.get(4));
                    classInfo.setDays(currentLine.get(5));
                    classInfo.setDescription(currentLine.get(6));

                    ClassInfoDatabase classInfoDatabase = Room.databaseBuilder(this,
                    ClassInfoDatabase.class, "CLASS_INFO.db").allowMainThreadQueries().build();

                    ClassInfoDao classInfoDao = classInfoDatabase.getClassInfoDao();
                    System.out.println("Inserting to db");

                    classInfoDao.insert(classInfo);


                    //clear the array list
                    System.out.println("clearing list");
                    currentLine.clear();
                }


                if (scanner.ioException() != null) {
                    System.out.println("Building DB Error");
                    throw scanner.ioException();
                }
            } catch (IOException ioException) {
                System.out.println("IO Exception");
                System.out.println(ioException.getMessage());

            }
    }
}
