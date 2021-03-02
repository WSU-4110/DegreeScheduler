package com.DegreeSchedulerApp.degreescheduler.Data;

import android.content.Context;

import androidx.room.Room;

/**
 * This creates our databases using Room and Sqlite
 * Builds the databases
 *
 * Ryan K
 */

public class Database {
    private static Database database;

    //our app database object
    private final UserDatabase userDatabase;

    private final ClassInfoDatabase classInfoDatabase;

    private Database(Context context) {

        //create the user database
        userDatabase = Room.databaseBuilder(context, UserDatabase.class, "Users").build();
        //create the class information database
        classInfoDatabase = Room.databaseBuilder(context,
                ClassInfoDatabase.class, "ClassInfo").build();

    }

    public static synchronized Database getInstance(Context context) {
        if (database == null) {
            database = new Database(context);
        }
        return database;
    }

    public UserDatabase getAppDatabase() {
        return userDatabase;
    }

    public ClassInfoDatabase getClassInfoDatabase() {
        return classInfoDatabase;
    }
}
