package com.jaemion.eHub.database;

import android.content.Context;

import com.jaemion.eHub.database.user.User;
import com.jaemion.eHub.database.user.UserDao;
import com.jaemion.eHub.database.worklist.WorkList;
import com.jaemion.eHub.database.worklist.WorkListDao;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(version = 1, entities = {User.class, WorkList.class})
public abstract class Database extends RoomDatabase {

    private static Database instance;

    abstract public UserDao userDao();

    abstract public WorkListDao workListDao();

    public static Database getInstance(Context context) {
        if (instance == null) {
            synchronized (Database.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "eHub").build();
            }
        }
        return instance;
    }
}
