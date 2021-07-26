package com.example.test_one_suitmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.test_one_suitmedia.Adapter.ListEventAdapter;
import com.example.test_one_suitmedia.Model.EventData;
import com.example.test_one_suitmedia.Model.EventModel;

import java.util.ArrayList;

public class ScreenEvent extends AppCompatActivity {

    private ArrayList<EventModel> listEvent = new ArrayList<>();
    private RecyclerView rvEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_event);
        rvEvents = findViewById(R.id.rv_event);
        rvEvents.setHasFixedSize(true);

        listEvent.addAll(EventData.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
        ListEventAdapter listEventAdapter = new ListEventAdapter(listEvent);
        rvEvents.setAdapter(listEventAdapter);

        listEventAdapter.setOnItemClickCallback(new ListEventAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(EventModel data) {
                //Kirim Data
                String namaEvent = data.getNameEvent();
                Intent goEvent = new Intent(ScreenEvent.this,Screen2.class);
                goEvent.putExtra("namaEvent",namaEvent);
                setResult(RESULT_OK, goEvent);
                finish();
            }
        });
    }
}