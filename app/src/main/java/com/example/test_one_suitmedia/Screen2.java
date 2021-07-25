package com.example.test_one_suitmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {
    private TextView tvNama;
    private Button btnGuest,btnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        /*Initialize*/
        tvNama = findViewById(R.id.tv_nama);
        btnEvent = findViewById(R.id.btn_event);
        btnGuest = findViewById(R.id.btn_guest);

        //Nangkep data dari Screen1
        Intent data = getIntent();
        String nama = data.getStringExtra("nama");
        tvNama.setText("Nama : "+nama);

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen2.this, ScreenGuest.class);
                startActivity(intent);
            }
        });

    }
}