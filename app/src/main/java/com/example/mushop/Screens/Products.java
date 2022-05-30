package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mushop.Adapter.CategoryAdapter;
import com.example.mushop.Model.Category;
import com.example.mushop.R;

import java.util.ArrayList;


public class Products extends Fragment {

    private ArrayList<Category> categoryArrayList;
    private RecyclerView recyclerView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_products, container, false);
        recyclerView3 = view.findViewById(R.id.productlistrecycler);
        categoryArrayList = new ArrayList<>();


        categoryArrayList.add(new Category(R.drawable.product1,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product2,"lame","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product3,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product4,"lame","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product5,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product1,"lame","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product2,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product3,"lame","reversible angora cardigan","$120"));



        CategoryAdapter adapter3= new CategoryAdapter(categoryArrayList,getContext());
        GridLayoutManager linearLayoutManager3=new GridLayoutManager(getContext(),2);
        recyclerView3.setLayoutManager(linearLayoutManager3);
        recyclerView3.setAdapter(adapter3);

        view.findViewById(R.id.listview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addproductlist(new Productslistview());
            }

            private void addproductlist(Productslistview productslistview) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,productslistview);
                ft.commit();
            }
        });

        return view;
    }
}