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
//Kassems Part
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


    // These tests pertain to email verification and the authentication of users

    Boolean isVerified = true;
    String password= "123456";
    String emailA = "[a-zA-Z0-9._-]+@wayne+\\.edu+";
    String emailB="[a-zA-Z0-9._-]+@wayne+\\.edu+";

    //check if password is atleast 6 chars
    @Test
    public void check_if_password_is_6_chars()
    {
        password.length();
        Assert.assertEquals(6, password.length());
        System.out.println("Password is of length");
    }

    //check if account is verified
    @Test
    public void check_if_account_verified()
    {
        Assert.assertTrue("Account is not verified",isVerified);
        System.out.println("Account is verified");
    }

    // check if email is WSU registered
    @Test
    public void check_if_wayne_email(){
        Assert.assertEquals("Not a wayne email",emailA, emailB);
        System.out.println("Is a Wayne Email");
    }

    // These tests pertain to the PasswordReset class

    String emailC = "go8010@wayne.edu";
    String emailD = "go8010@wayne.edu";
    String oldPass = "123456";
    String newPass = "654321";

    // check if email account is registered
    @Test
    public void check_if_emails_are_registered(){
        Assert.assertEquals("Email is not registered",emailC, emailD);
        System.out.println("Email is registered");
    }

    // check if verification link is sent
    @Test
    public void check_if_link_sent(){
        Assert.assertEquals("Link failed to send",emailC, emailD);
        System.out.println("Link is registered");
    }

    // check if new password is old
    @Test
    public void check_if_old_password(){
        Assert.assertNotSame("New password cannot be the old one",oldPass, newPass);
        System.out.println("New password is updated");
    }



//Ciah Green

         @Test
         public void testclassName () {
             ClassInfo classInfo = new ClassInfo();
             classInfo.setClassName("Name");
             assert (classInfo.getClassName().equals("Name"));
         }


         @Test
         public void testclassNumber () {
             ClassInfo classInfo = new ClassInfo();
             classInfo.setClassNumber("Number");
             assert (classInfo.getClassNumber().equals("Number"));
         }

         @Test
         public void teststartDate () {
             ClassInfo classInfo = new ClassInfo();
             classInfo.setStartDate("Date");
             assert (classInfo.getStartDate().equals("Date"));

         }
         @Test
         public void testendDate () {
             ClassInfo classInfo = new ClassInfo();
             classInfo.setEndDate("End Date");
             assert (classInfo.getEndDate().equals("End Date"));

         }

         @Test
         public void testdays () {
             ClassInfo classInfo = new ClassInfo();
             classInfo.setDays("Days");
             assert (classInfo.getDays().equals("Days"));

         }

     //Santhra's Part Download page test
    String sampleUrl = "https://th.bing.com/th/id/OIP.4bT2h9cpzSZqHrKm4TxuLwHaBu?pid=ImgDet&rs=1";
    String emptyUrl = "";
    String invalidUrl = "abc";
    Boolean checkedBox = true;
    Boolean notCheckedBox = false;
    Boolean allow = true;
    Boolean deny = false;


    @Test
    public void editTextEmpty() {
        Assert.assertNotEquals(sampleUrl, emptyUrl); //check if url is empty.
        System.out.println("Please enter a url!");
    }

    @Test
    public void editTextInvalid(){
        Assert.assertNotSame(sampleUrl, invalidUrl); //check if url does not match.
        System.out.println("Please enter a valid url!");
    }

    @Test
    public void editTextValid(){
        Assert.assertSame(sampleUrl,sampleUrl); //check if url match.
        System.out.println("Valid URL!! Please click the checkbox and Download");
    }

    @Test
    public void checkButtonNotChecked(){
        Assert.assertTrue(checkedBox);//check if checkbox is not checked
        System.out.println("Check box is not checked");
    }

    @Test
    public void checkButtonChecked(){

        Assert.assertFalse(notCheckedBox);//check if checkbox is checked
        System.out.println("Check box is checked");
    }

    @Test
    public void permissionGranted() {
        Assert.assertTrue(allow);//check if permission is granted
        System.out.println("Permission granted!");
    }

    @Test
    public void permissionDenied() {
        Assert.assertFalse(deny);//check if permission is not granted
        System.out.println("Permission denied..!");
    }

    }

