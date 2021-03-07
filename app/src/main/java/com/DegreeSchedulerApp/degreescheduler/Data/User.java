package com.DegreeSchedulerApp.degreescheduler.Data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Arrays;

/**
 * This is the information for our user
 * This is where the user name, password, email, and chosen classes are stored
 * This is an entity, like a class but allows the database to access it
 *
 * The user is identified by accessId
 *
 * Ryan K
 */

@Entity(foreignKeys = {
        @ForeignKey(
                entity = ClassInfo.class,
                parentColumns = "crn",
                childColumns = "classesCrn"
        )
})
public class User implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String accessId;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "classesCrn")
    private String classesCrn;


    @NonNull
    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(@NonNull String accessId) {
        this.accessId = accessId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassesCrn() {
        return classesCrn;
    }

    public void setClassesCrn(String classesCrn) {
        this.classesCrn = classesCrn;
    }


    @Override
    public String toString() {
        return "User{" +
                "accessId='" + accessId + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", classesCrn='" + classesCrn + '\'' +
                '}';
    }
}
