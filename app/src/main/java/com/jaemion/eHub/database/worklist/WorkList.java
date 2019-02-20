package com.jaemion.eHub.database.worklist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workList_table")
public class WorkList {
    @PrimaryKey(autoGenerate = true)
    private int uid;
}
