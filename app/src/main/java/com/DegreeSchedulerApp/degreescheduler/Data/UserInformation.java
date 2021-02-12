package com.DegreeSchedulerApp.degreescheduler.Data;

public class UserInformation {
    //members
    private String accessID;
    private String passwd;
    private String email;
    private int ID;

    //constructor
    public UserInformation(String accessID, String passwd, String email, int ID) {
        this.accessID = accessID;
        this.passwd = passwd;
        this.email = email;
        this.ID = ID;
    }

    //getters and setters
    public String getAccessID() {
        return accessID;
    }

    public void setAccessID(String accessID) {
        this.accessID = accessID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    @Override
    public String toString() {
        return "UserInformation{" +
                "accessID='" + accessID + '\'' +
                ", passwd='" + passwd + '\'' +
                ", email='" + email + '\'' +
                ", ID=" + ID +
                '}';
    }
}


