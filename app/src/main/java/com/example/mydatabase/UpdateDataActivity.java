package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mydatabase.database.AppDatabase;
import com.example.mydatabase.database.DataDiri;

public class UpdateDataActivity extends AppCompatActivity {
    String nama, name;
    String alamat, address;
    int id;
    char jenkel, gender;
    EditText eNama,eAlamat,eJenkel;
    Button bUpdate,bDelete;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        //Akses database
        appDatabase = AppDatabase.initDB(getApplicationContext());

        //mengambil dari intent
        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        alamat = intent.getStringExtra("alamat");
        jenkel = intent.getCharExtra("kelamin",' ');
        id = intent.getIntExtra("id",0);
        eNama = findViewById(R.id.etNama);
        eAlamat = findViewById(R.id.etAlamat);
        eJenkel = findViewById(R.id.etKelamin);
        bUpdate = findViewById(R.id.btnUpdate);
        bDelete = findViewById(R.id.btnDelete);
        //set data yang kita ambil dari intent
        eNama.setText(nama);
        eJenkel.setText(""+jenkel);
        eAlamat.setText(alamat);

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
    }
    public void updateData(){
        name = eNama.getText().toString();
        address = eAlamat.getText().toString();
        gender = eJenkel.getText().charAt(0);
        DataDiri dataDiri = new DataDiri();
        dataDiri.setNama(name);
        dataDiri.setAlamat(address);
        dataDiri.setJkelamin(gender);
        dataDiri.setId(id);
        appDatabase.dao().update(dataDiri);
        finish();
    }
    public void deleteData(){
        DataDiri dataDiri = new DataDiri();
        dataDiri.setId(id);
        appDatabase.dao().deleteData(dataDiri);
        finish();
    }
}
