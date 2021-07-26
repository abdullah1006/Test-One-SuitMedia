package com.example.test_one_suitmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {
    private TextView tvNama;
    private Button btnGuest, btnEvent;

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
        tvNama.setText("Nama : " + nama);

        //Check Palindrom
        if(isPalindrom(nama,0)){
            Toast.makeText(this, "isPalindrome", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "not palindrome", Toast.LENGTH_SHORT).show();
        }


        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen2.this, ScreenGuest.class);
                startActivity(intent);
            }
        });

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen2.this, ScreenEvent.class);
                startActivityForResult(intent,1);
            }
        });

    }
    //Palindrom Recursive
    private boolean isPalindrom(String nama, int i) {
        if(i<nama.length()/2){
            int indexAwal = i;
            int indexAkhir = nama.length() -i -1;

            if(nama.charAt(indexAwal)!= nama.charAt(indexAkhir)){
                return false;
            }else{
                return isPalindrom(nama,i+1);
            }
        }else{
            return true;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String namaEvent = data.getStringExtra("namaEvent");
                btnEvent.setText(namaEvent);
            }
            if(resultCode == 1) {
                String namaGuest = data.getStringExtra("namaGuest");
                btnGuest.setText(namaGuest);
            }
        }
    }

}