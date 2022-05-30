package com.example.mushop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mushop.Model.NewArrivalMenu;
import com.example.mushop.R;



import java.util.ArrayList;

public class NAMenuRecycler extends RecyclerView.Adapter<NAMenuRecycler.RecyclerViewHolder>{
    private ArrayList<NewArrivalMenu> list;
    private Context context;

    public NAMenuRecycler(ArrayList<NewArrivalMenu> arrayList, Context context)
    {
        this.list=arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menurecycler,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        NewArrivalMenu newArrivalMenu=list.get(position);
        holder.menu.setText(newArrivalMenu.getMenuname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView menu;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            menu=itemView.findViewById(R.id.namenu);
        }
    }
}
