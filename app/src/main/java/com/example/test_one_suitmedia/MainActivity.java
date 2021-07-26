package com.example.test_one_suitmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class  MainActivity extends AppCompatActivity {
    private EditText inNama;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        /*Initialize*/
        inNama = findViewById(R.id.in_nama);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Kirim Data Ke Screen 2*/
                String dataNama;
                dataNama = inNama.getText().toString();
                Intent goInput = new Intent(MainActivity.this, Screen2.class);
                goInput.putExtra("nama",dataNama);
                startActivity(goInput);
            }
        });



    }
}