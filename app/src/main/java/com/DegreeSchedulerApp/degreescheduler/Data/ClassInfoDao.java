package com.DegreeSchedulerApp.degreescheduler.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * This is the data access object for the classes
 * We can insert, delete, update and importantly query
 * Currently we can query by crn
 * We can add more based on what we want to search by
 * Call getItemByCrn to search by crn
 *
 * Ryan K
 */
@Dao
public interface ClassInfoDao {
    @Query("SELECT * FROM ClassInfo")
    List<ClassInfo> getAll();

    @Insert
    void insert(ClassInfo classInfo);

    @Delete
    void delete(ClassInfo classInfo);

    @Update
    void update(ClassInfo classInfo);

    @Query("SELECT * FROM classInfo")
    public List<ClassInfo> getClassInfo();

    @Query("SELECT * FROM classInfo WHERE crn = :crn")
    public ClassInfo getItemByCrn(Long crn);

    //TODO: Add more queries

}
