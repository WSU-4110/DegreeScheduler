package com.DegreeSchedulerApp.degreescheduler.Data;

public class SingletonExample {
    public SingletonExample() {

        //here is an example of creating a new object in the singleton class
        //only one at a time because we are inserting into the database and don't want to
        //have issues
        ClassInfo classInfo = ClassInfo.getInstance();
        classInfo.setCrn(12345);
        classInfo.setClassName("Software Engineering");
        classInfo.setClassNumber(4110);
        classInfo.setStartDate("2021-1-11");
        classInfo.setEndDate("2021-5-4");
        classInfo.setDays("Monday and Wednesday");
        classInfo.setInstructor("Professor Bosu");
        classInfo.setDescription("SE concepts");
        classInfo.setGrade(0);
    }
}
