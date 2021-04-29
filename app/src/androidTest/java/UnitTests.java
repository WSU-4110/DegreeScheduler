import android.content.Context;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;

import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDao;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDatabase;

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
}
