package com.jaemion.eHub.database.worklist;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface WorkListDao {

    @Insert
    void insert(WorkList... workList);

    @Update
    void update(WorkList workList);

    @Delete
    void delete(WorkList workList);

    @Query("SELECT * FROM workList_table")
    List<WorkList> getAllWorkList();

    @Query("DELETE FROM workList_table")
    void deleteAll();
}
