package com.example.test_one_suitmedia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_one_suitmedia.Model.GuestModel;
import com.example.test_one_suitmedia.R;
import com.example.test_one_suitmedia.Screen2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private Context ctx;
    private List<GuestModel> listGuest;


    public GridAdapter(Context ctx, ArrayList<GuestModel> listGuest) {
        this.ctx = ctx;
        this.listGuest = listGuest;
    }

    @NonNull
    @NotNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data, parent, false);
        GridViewHolder holder = new GridViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GridViewHolder holder, int position) {
        GuestModel gm = listGuest.get(position);
        holder.tvNamaGuest.setText(gm.getName());
        holder.tvBirthdate.setText(gm.getBirthdate());

    }

    @Override
    public int getItemCount() {
        return listGuest.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaGuest,tvBirthdate;
        public GridViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvNamaGuest = itemView.findViewById(R.id.tv_namaGuest);
            tvBirthdate = itemView.findViewById(R.id.tv_birthdateGuest);
        }
    }

}
