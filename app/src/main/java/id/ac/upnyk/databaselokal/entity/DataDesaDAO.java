package id.ac.upnyk.databaselokal.entity;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDesaDAO {

    @Insert
    long insertData(DataDesa dataDesa);

    @Query("Select * from desa_db")
    List<DataDesa> getData();

    @Update
    int updateData(DataDesa item);

    @Delete
    void deleteData(DataDesa item);

}
