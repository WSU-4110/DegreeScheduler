package com.DegreeSchedulerApp.degreescheduler.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String ACCESS_ID = "ACCESS_ID";
    public static final String PASSWD = "PASSWD";
    public static final String EMAIL = "EMAIL";

    //constructor
    public DataBaseHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    //this generates a new table
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        String newTable = "CREATE TABLE " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + ACCESS_ID + " TEXT, " + PASSWD + " TEXT, " + EMAIL + " TEXT)";

        db.execSQL(newTable);

    }

    //called when the version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //add user to the database
    public boolean add (UserInformation userInformation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ACCESS_ID, userInformation.getAccessID());
        cv.put(PASSWD, userInformation.getPasswd());
        cv.put(EMAIL, userInformation.getEmail());

        long insert = db.insert(USER_TABLE, null, cv);

        //check if inserted or not
        if(insert == -1) {
            return false;
        }else {
            return true;
        }


    }
}
