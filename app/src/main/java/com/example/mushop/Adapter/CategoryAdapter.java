package com.example.mushop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mushop.Screens.Mainproduct;
import com.example.mushop.Model.Category;
import com.example.mushop.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.RecyclerViewHolder>{
    private ArrayList<Category> category;
    private Context context;


    public CategoryAdapter(ArrayList<Category> category, Context context) {
        this.category=category;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.productgridlayout,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.RecyclerViewHolder holder, int position) {
        Category categories=category.get(position);
        holder.imageView.setImageResource(categories.getImages());
        holder.brand.setText(categories.getBrands());
        holder.name.setText(categories.getNames());
        holder.price.setText(categories.getPrices());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                Mainproduct mainproduct = new Mainproduct();
                manager.beginTransaction().replace(R.id.frame1,mainproduct)
                        .commit();

            }
        });


    }

    private void addmainproduct(Mainproduct mainproduct) {

    }


    @Override
    public int getItemCount() {
        return category.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView brand,name,price;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.product1);


            brand=itemView.findViewById(R.id.brands_category);
            name=itemView.findViewById(R.id.productbame1);
            price=itemView.findViewById(R.id.pricetag);
        }

    }
}