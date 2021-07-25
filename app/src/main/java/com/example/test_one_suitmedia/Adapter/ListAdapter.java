package com.example.test_one_suitmedia.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{


    @NonNull
    @NotNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListAdapter.ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
