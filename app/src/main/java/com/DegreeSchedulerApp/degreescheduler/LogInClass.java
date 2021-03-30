package com.DegreeSchedulerApp.degreescheduler;
//Used Decorator Design Pattern to check the validation of the Login Page input
public class LogInClass implements LoginInterface{
    private LogInClass(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void Validate() {
        if (getUserName().length() == 0) {
            System.out.print("UserName required");
        } else if (!getUserName().equals("gn7030")) {
            System.out.print("Invalid Username!");
        }
        if (getPassword().length() == 0) {
            System.out.print("Password.required");
        } else if (!getPassword().equals("Mypassword123")) {
            System.out.print("Incorrect Password!");
        }
    }
}
