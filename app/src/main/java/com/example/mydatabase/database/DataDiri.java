package com.example.mydatabase.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "datadiri_db")
public class DataDiri {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String nama;

    @ColumnInfo(name = "adress")
    private String alamat;

    @ColumnInfo(name = "gender")
    private char jkelamin;

    public int getId() {
        return id;
    }

    public char getJkelamin() {
        return jkelamin;
    }

    public void setJkelamin(char jkelamin) {
        this.jkelamin = jkelamin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
