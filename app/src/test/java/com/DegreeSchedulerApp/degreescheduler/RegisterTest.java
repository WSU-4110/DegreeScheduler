package com.DegreeSchedulerApp.degreescheduler;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class RegisterTest {
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
        Assert.assertEquals("Passwords Don't Match",passWd1, passWd2); //check if passwords match.
        System.out.println("Passwords match");
    }
    @Test
    public void check_if_emails_match(){
        Assert.assertEquals("Emails Dont't match",email1, email2); // check if emails match.
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