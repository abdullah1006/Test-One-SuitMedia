package com.example.test_one_suitmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test_one_suitmedia.API.APIClient;
import com.example.test_one_suitmedia.Adapter.GridAdapter;
import com.example.test_one_suitmedia.Model.GuestModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenGuest extends AppCompatActivity {
    private RecyclerView rvGuest;
    private RecyclerView.Adapter gridAdapter;
    private List<GuestModel> guestModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_guest);
        //Initialize
        rvGuest = findViewById(R.id.rv_guest);
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
                    Toast.makeText(ScreenGuest.this, message, Toast.LENGTH_SHORT).show();
                    guestModels = response.body();
                    gridAdapter = new GridAdapter(ScreenGuest.this, (ArrayList<GuestModel>) guestModels);
                    rvGuest.setAdapter(gridAdapter);



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
    private void showSelectedHero(GuestModel guestModel) {
        Toast.makeText(this, "Kamu memilih " + guestModel.getName(), Toast.LENGTH_SHORT).show();
    }


}