package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mydatabase.database.AppDatabase;

public class TamilDataActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamil_data);
        appDatabase = AppDatabase.initDB(this);
        recyclerView = findViewById(R.id.list_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //membaca data dan menaruhnya ke adapter
        //data dari database sudah bersifat array
    }
    @Override
    protected void onResume() {
        super.onResume();
        read();
    }
    public void read(){
        Adapter adapter = new Adapter(appDatabase.dao().getData(), this);
        recyclerView.setAdapter(adapter);
    }
}
