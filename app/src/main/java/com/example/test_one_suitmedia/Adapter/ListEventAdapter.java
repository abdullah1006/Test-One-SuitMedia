package com.example.test_one_suitmedia.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.test_one_suitmedia.Model.EventModel;
import com.example.test_one_suitmedia.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ListEventAdapter extends RecyclerView.Adapter<ListEventAdapter.ListViewHolder>{
    private ArrayList<EventModel> listEvent;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListEventAdapter(ArrayList<EventModel> listEvent) {
        this.listEvent = listEvent;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data_events, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull final ListViewHolder holder, int position) {
        EventModel eventModel = listEvent.get(position);
        Glide.with(holder.itemView.getContext())
                .load(eventModel.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imageEvent);
        holder.tvNamaEvent.setText(eventModel.getNameEvent());
        holder.tvTglEvent.setText(eventModel.getTanggal());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listEvent.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageEvent;
        TextView tvNamaEvent,tvTglEvent;
        public ListViewHolder(View itemView) {
            super(itemView);
            imageEvent = itemView.findViewById(R.id.img_event);
            tvNamaEvent = itemView.findViewById(R.id.tv_nama_event);
            tvTglEvent = itemView.findViewById(R.id.tv_tanggal_event);

        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(EventModel data);
    }
}
