package com.example.test_one_suitmedia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.test_one_suitmedia.Model.GuestModel;
import com.example.test_one_suitmedia.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GridGuestAdapter extends RecyclerView.Adapter<GridGuestAdapter.GridViewHolder>{

    private ArrayList<GuestModel> listGuest;
    private ItemClickListener mItemListener;

    public GridGuestAdapter(ArrayList<GuestModel> list, ItemClickListener itemClickListener) {
        this.listGuest = list;
        this.mItemListener = itemClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public GridGuestAdapter.GridViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GridGuestAdapter.GridViewHolder holder, int position) {
        GuestModel guestModel = listGuest.get(position);
        holder.tvNamaGuest.setText(guestModel.getName());
        holder.tvBirthdate.setText(guestModel.getBirthdate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.onItemClick(listGuest.get(holder.getAdapterPosition()));
            }
        });
        Glide.with(holder.itemView.getContext())
                .load(listGuest.get(position).getImageGuest())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imageGuest);
    }

    @Override
    public int getItemCount() {
        return listGuest.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imageGuest;
        TextView tvNamaGuest,tvBirthdate;
        public GridViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageGuest = itemView.findViewById(R.id.img_guest);
            tvNamaGuest = itemView.findViewById(R.id.tv_namaGuest);
            tvBirthdate = itemView.findViewById(R.id.tv_birthdateGuest);
        }
    }
    public interface ItemClickListener {
        void onItemClick(GuestModel data);
    }
}
