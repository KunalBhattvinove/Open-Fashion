package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mushop.Adapter.CategoryAdapter2;
import com.example.mushop.Model.Category;
import com.example.mushop.R;

import java.util.ArrayList;


public class Productslistview extends Fragment {


    private ArrayList<Category> categoryArrayList;
    private RecyclerView recyclerView4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_productslistview, container, false);
        recyclerView4 = view.findViewById(R.id.listviewrecycler);
        categoryArrayList = new ArrayList<>();


        categoryArrayList.add(new Category(R.drawable.product1,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product2,"lame","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product3,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product4,"lame","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product5,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product1,"lame","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product2,"21WN","reversible angora cardigan","$120"));
        categoryArrayList.add(new Category(R.drawable.product3,"lame","reversible angora cardigan","$120"));



        CategoryAdapter2 adapter3= new CategoryAdapter2(categoryArrayList,getContext());
        LinearLayoutManager linearLayoutManager3=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView4.setLayoutManager(linearLayoutManager3);
        recyclerView4.setAdapter(adapter3);

        view.findViewById(R.id.listview3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addproductagain(new Products());
            }

            private void addproductagain(Products products) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,products);
                ft.commit();
            }
        });
        return view;
    }
}