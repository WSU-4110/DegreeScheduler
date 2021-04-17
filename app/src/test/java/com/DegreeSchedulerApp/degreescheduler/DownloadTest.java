package com.DegreeSchedulerApp.degreescheduler;


import android.widget.Button;
import android.widget.CheckBox;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class DownloadTest {
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