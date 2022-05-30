package com.example.mushop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mushop.Model.Category;
import com.example.mushop.R;

import java.util.ArrayList;

public class CategoryAdapter2 extends RecyclerView.Adapter<CategoryAdapter2.Myviewholder> {
    private ArrayList<Category> category;
    private Context context;

    public CategoryAdapter2(ArrayList<Category> category,Context context) {
        this.category=category;
        this.context=context;
    }
    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        Category categories=category.get(position);
        holder.imageView.setImageResource(categories.getImages());
        holder.brand.setText(categories.getBrands());
        holder.name.setText(categories.getNames());
        holder.price.setText(categories.getPrices());
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView brand,name,price;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.product1_list);
            brand   = itemView.findViewById(R.id.product1_brand);
            name   = itemView.findViewById(R.id.product1_name);
            price  = itemView.findViewById(R.id.prices_categorylist);
        }
    }
}

