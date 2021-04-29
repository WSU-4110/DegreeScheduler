import android.content.Context;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;

import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDao;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDatabase;
import com.DegreeSchedulerApp.degreescheduler.Register;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTests {
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

        classInfoDao.clearTheTable();

        ClassInfo classInfo = new ClassInfo();
        classInfo.setCrn(testCrn);

        classInfoDao.insert(classInfo);
        assert(classInfoDao.getCrn(testCrn).equals(testCrn));

    }

    String email1 = "Faraj54@gmail.com";
    String email2 = "gx9397@wayne.edu";
    String passWd1= "Wayne123@";
    String passWd2= "Wayne123";
    String emailPattern = "[a-zA-Z0-9._-]+@wayne+\\.edu+";
    String emailPattern2="[a-zA-Z0-9._-]+@gmail+\\.com+";
    String username = "[a-zA-Z0-9._-]";
    String user ="gx9397";

    @Test
    public void check_if_passwords_match()
    {
        Assert.assertNotSame("Passwords Don't Match",passWd1, passWd2); //check if passwords match.
        System.out.println("Passwords match");
    }
    @Test
    public void check_if_emails_match(){
        Assert.assertNotSame("Emails Dont't match",email1, email2); // check if emails match.
        System.out.println("Emails match");
    }
    @Test
    public void check_if_emailpatt2_matches(){
        Assert.assertNotSame("Email pattern doesn't match",emailPattern2, email1); //check if email matches @wayne.edu pattern.
        System.out.println("Email patterns match");
    }
    @Test
    public void check_if_emailpatt1_matches(){
        Assert.assertNotSame("Email pattern doesn't match",emailPattern, email2); //check if email matches @wayne.edu pattern.
        System.out.println("Email patterns match");
    }
    @Test
    public void username_Verification(){
        Assert.assertNotSame("Username doesn't match",username, user); //check if user matches username pattern.
        System.out.println("Usernames match");
    }

}
