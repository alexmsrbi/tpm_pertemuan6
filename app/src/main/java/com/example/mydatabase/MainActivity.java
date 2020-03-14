package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mydatabase.database.AppDatabase;
import com.example.mydatabase.database.DataDiri;

public class MainActivity extends AppCompatActivity {
    private EditText eNama, eAlamat, eJenkel;
    private Button bTambah, bTampil, bUpdate, bDelete;
    private AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.initDB(getApplicationContext());

        eNama = findViewById(R.id.etNama);
        eAlamat = findViewById(R.id.etAlamat);
        eJenkel = findViewById(R.id.etKelamin);
        bTambah = findViewById(R.id.btnTambah);
        bTampil = findViewById(R.id.btnTampil);

        bTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        bTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tampil = new Intent(getApplicationContext(), TamilDataActivity.class);
                startActivity(tampil);
            }
        });
    }

    private void insertData(){
        //Menginisialisasi data
        String nama = eNama.getText().toString();
        String alamat = eAlamat.getText().toString();
        char jenkel = eJenkel.getText().toString().charAt(0);
        DataDiri data = new DataDiri();
        data.setNama(nama);
        data.setAlamat(alamat);
        data.setJkelamin(jenkel);

        //mengirim ke database
        appDatabase.dao().insertData(data);
        eNama.setText("");
        eAlamat.setText("");
        eJenkel.setText("");

    }
}
