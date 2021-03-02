package com.DegreeSchedulerApp.degreescheduler.Data;


import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * This creates a database for the user
 * See examples to activate this database
 * Ryan K
 */

@Database(entities = {User.class, ClassInfo.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao getUserDAO();
}
