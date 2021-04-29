package com.example.degreescheduler;

import android.content.Context;

import androidx.room.Query;
import androidx.room.Room;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDao;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDatabase;
import androidx.test.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Test;

public class ClassInfoTest {

    private ClassInfoDao classInfoDao;
    private ClassInfoDatabase classInfoDatabase;
    String testCrn = "0";
    String testName = "test";

    @Before
    //This is required for all the tests to work
    //Connect to the Rooms database
    public void connectToDb() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        ClassInfoDatabase classInfoDatabase = Room.databaseBuilder(appContext,
                ClassInfoDatabase.class, "CLASS_INFO.db").allowMainThreadQueries().build();
         classInfoDao = classInfoDatabase.getClassInfoDao();

    }


    //test 1
    @Test
    public void testInsertAndCrnQuery() {
        //This test verifies:
        //1. the method getCrn(String) works
        //2. the method insert works

        //@Query("SELECT crn FROM course_table WHERE crn = :crn")
        //String  getCrn(String crn);

        //@Insert
        //void insert(ClassInfo classInfo);

        ClassInfo classInfo = new ClassInfo();
        classInfo.setCrn(testCrn);

        classInfoDao.insert(classInfo);
        assert(classInfoDao.getCrn(testCrn).equals(testCrn));

    }

    //Test 2
    @Test(expected = NullPointerException.class)
    public void testDeleteAndgetInfoFromCrnQuery() {
        //This test verifies:
        //1. the method getInfoFromCrn works
        //2. the method delete works
        //I know this test works when the query returns a null object
        //because the object was deleted

        //@Query("SELECT * FROM course_table WHERE crn = :crn")
        //ClassInfo getInfoFromCrn(String crn);

        //@Delete
        //void delete(ClassInfo classInfo);

        ClassInfo classInfo2 = new ClassInfo();
        classInfo2.setCrn(testCrn);

        classInfoDao.delete(classInfo2);
        assert(classInfoDao.getInfoFromCrn(testCrn).equals(classInfo2));

    }


    // test 3
    @Test
    public void testUpdateAndNameQuery() {
        //this test verifies that:
        //1. the getName(string) method works
        //2. the update method works
        ClassInfo classInfo = new ClassInfo();
        classInfo.setCrn(testCrn);
        classInfo.setClassName(testName);

        //@Query("SELECT className FROM course_table WHERE className = :name")
        //String  getName(String name);

        //@Update
        //void update(ClassInfo classInfo);
        classInfoDao.update(classInfo);
        assert(classInfoDao.getName(testName).equals(testName));

    }

}
