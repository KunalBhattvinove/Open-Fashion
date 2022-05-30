package com.example.mushop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushop.Model.PhotoHome;
import com.example.mushop.R;


import java.util.ArrayList;

public class PhotoRecycler extends RecyclerView.Adapter<PhotoRecycler.RecyclerViewHolder> {
    private ArrayList<PhotoHome> list;
    private Context context;

    public PhotoRecycler(ArrayList<PhotoHome> photoHomeArrayList, Context context)
    {
        this.list=photoHomeArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.newarrival,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        PhotoHome photoHome=list.get(position);
        holder.img.setImageResource(photoHome.getImage());
        holder.name.setText(photoHome.getName());
        holder.price.setText(photoHome.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView name,price;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.models);
            name=itemView.findViewById(R.id.names);
            price=itemView.findViewById(R.id.prices);

        }
    }
}
