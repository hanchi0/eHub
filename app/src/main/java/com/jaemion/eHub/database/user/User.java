package com.jaemion.eHub.database.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "user_id")
    private String user_id;
    @ColumnInfo(name = "user_pw")
    private String user_pw;
    @ColumnInfo(name = "user_type")
    private String user_type;

    public String getUserId() {
        return this.user_id;
    }

    public void setUserId(String id) {
        user_id = id;
    }

    public String getUserPw() {
        return this.user_pw;
    }

    public void setUserPw(String pw) {
        user_pw = pw;
    }

    public String getUserType() {
        return this.user_type;
    }

    public void setUserType(String type) {
        user_type = type;
    }
}
