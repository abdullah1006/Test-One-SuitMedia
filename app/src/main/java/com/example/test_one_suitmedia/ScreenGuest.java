package com.example.test_one_suitmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.test_one_suitmedia.API.APIClient;
import com.example.test_one_suitmedia.Adapter.GridGuestAdapter;
import com.example.test_one_suitmedia.Model.GuestModel;
import com.example.test_one_suitmedia.Model.ImageData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenGuest extends AppCompatActivity {
    private RecyclerView rvGuest;
    private RecyclerView.Adapter gridGuestAdapter;
    private ArrayList<GuestModel> listGuest = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_guest);
        setActionBarTitle("Guest");

        //Initialize
        rvGuest = findViewById(R.id.rv_guest);
        listGuest.addAll(ImageData.getListDataGuest());
        rvGuest.setLayoutManager(new GridLayoutManager(this,2));

        getData();
    }

    public void getData(){
        Call<List<GuestModel>> tampilData = APIClient.getAllGuest().ardGetGuest();

        tampilData.enqueue(new Callback<List<GuestModel>>() {
            @Override
            public void onResponse(Call<List<GuestModel>> call, Response<List<GuestModel>> response) {
                if(response.isSuccessful()){
                    String message = "Succes";
                    listGuest = (ArrayList<GuestModel>) response.body();
                    gridGuestAdapter = new GridGuestAdapter(listGuest, new GridGuestAdapter.ItemClickListener() {
                        @Override
                        public void onItemClick(GuestModel data) {
                            String namaGuest = data.getName();
                            Intent goGuest = new Intent(ScreenGuest.this,Screen2.class);
                            goGuest.putExtra("namaGuest",namaGuest);
                            setResult(1, goGuest);
                            finish();
                            showSelectedGuest(data.getBirthdate());
                            if(checkDatePrime(data.getBirthdate())){
                                Toast.makeText(ScreenGuest.this, "Bilangan Prima", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(ScreenGuest.this, "Bukan Bilangan Prima", Toast.LENGTH_SHORT).show();
                            };
                        }
                    });
                    rvGuest.setAdapter(gridGuestAdapter);


                }else{
                    String message = "Error";
                    Toast.makeText(ScreenGuest.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GuestModel>> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(ScreenGuest.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Checking Bilangan Prima
    private boolean checkDatePrime(String birthdate) {
        String bulan ="";
        for(int i = 5;i<=6;i++){
            bulan = bulan + birthdate.charAt(i);
        }
        int noBulan = Integer.parseInt(bulan);
        if (noBulan > 1) {
            return (checkPrime(noBulan, noBulan) == 2);
        }
        else
            return false;
    }

    private int checkPrime(int noBulan, int i) {
        if (i == 1) {
            return 1;
        }
        else if (noBulan % i == 0) {
            return 1 + checkPrime(noBulan, --i);
        } else {
            return 0 + checkPrime(noBulan, --i);
        }
    }

    //Check Tanggal Lahir
    private void showSelectedGuest(String birthdate) {
        String tanggal ="";
        for(int i =8;i<=9;i++){
            tanggal+= birthdate.charAt(i);
        }
        int noTanggal = Integer.parseInt(tanggal);
        if(noTanggal%2==0){
            Toast.makeText(this, "blackberry", Toast.LENGTH_SHORT).show();
        }else if(noTanggal%3==0){
            Toast.makeText(this, "android", Toast.LENGTH_SHORT).show();
        }else if(noTanggal%3==0 && noTanggal%2==0){
            Toast.makeText(this, "IOS", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "feature phone", Toast.LENGTH_SHORT).show();
        }
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


}