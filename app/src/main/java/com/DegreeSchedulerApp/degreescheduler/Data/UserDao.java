package com.DegreeSchedulerApp.degreescheduler.Data;

import android.content.ClipData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * This is the data access object for the classes
 * We can insert, delete, update and importantly query
 * Currently we can query by access id
 *
 * Ryan K
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

    @Query("SELECT * FROM user")
    public List<User> getUser();

    @Query("SELECT * FROM user WHERE accessId = :accessId")
    public User getItemById(Long accessId);

}
