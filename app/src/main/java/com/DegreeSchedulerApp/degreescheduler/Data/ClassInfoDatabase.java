package com.DegreeSchedulerApp.degreescheduler.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * This creates a database for the class information
 * see examples to activate this database
 * Ryan K
 */

@Database(entities = {ClassInfo.class}, version = 1)
public abstract class ClassInfoDatabase extends RoomDatabase {
    public abstract ClassInfoDao getClassInfoDao();
}
