package com.example.degreescheduler;

import android.content.Context;



import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleInstrumentedTest {
    @Test
    public void testcrn() {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setCrn("0");
        assert(classInfo.getCrn().equals("0")); // this verifies to whatever we want
    }

    @Test
    public void testclassName() {
        ClassInfo classInfo= new ClassInfo();
        classInfo.setClassName("Name");
        assert (classInfo.getClassName().equals("Name"));
    }


    @Test
    public void testclassNumber() {
        ClassInfo classInfo= new ClassInfo();
        classInfo.setClassNumber("Number");
        assert (classInfo.getClassNumber().equals("Number"));
    }

    @Test
    public void teststartDate() {
        ClassInfo classInfo= new ClassInfo();
        classInfo.setStartDate("Date");
        assert (classInfo.getStartDate().equals("Date"));

    }
    @Test
    public void testendDate() {
        ClassInfo classInfo= new ClassInfo();
        classInfo.setEndDate("End Date");
        assert (classInfo.getEndDate().equals("End Date"));

    }

    @Test
    public void testdays() {
        ClassInfo classInfo= new ClassInfo();
        classInfo.setDays("Days");
        assert (classInfo.getDays().equals("Days"));

    }

}