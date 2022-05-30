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

public class BOTTOM_MAINPRODUCT extends RecyclerView.Adapter<BOTTOM_MAINPRODUCT.MYviewHOLDERS>  {
    private ArrayList<PhotoHome> list;
    private Context context;

    public BOTTOM_MAINPRODUCT(ArrayList<PhotoHome> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public MYviewHOLDERS onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_of_mainproduct,parent,false);
         return new MYviewHOLDERS(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYviewHOLDERS holder, int position) {
        PhotoHome photoHome=list.get(position);
        holder.img.setImageResource(photoHome.getImage());
        holder.name.setText(photoHome.getName());
        holder.price.setText(photoHome.getPrice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MYviewHOLDERS extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name,price;

        public MYviewHOLDERS(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.produc2);
            name = itemView.findViewById(R.id.brands_category2);
            price = itemView.findViewById(R.id.pricetag2);
        }
    }
}
