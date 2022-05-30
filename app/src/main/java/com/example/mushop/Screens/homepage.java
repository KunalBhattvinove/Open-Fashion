package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mushop.Adapter.NAMenuRecycler;
import com.example.mushop.Adapter.PhotoRecycler;

import com.example.mushop.Adapter.PhotoRecycler2;
import com.example.mushop.Model.NewArrivalMenu;
import com.example.mushop.Model.PhotoHome;
import com.example.mushop.R;

import java.util.ArrayList;


public class homepage extends Fragment {

    private RecyclerView recyclerView,recyclerView1,recyclerView2;
    private ArrayList<PhotoHome> photoHomeArrayList;
    ImageView explore;
    TextView blogButton;
    private ArrayList<NewArrivalMenu> newArrivalMenus,newArrivalMenus2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_homepage, container, false);
        recyclerView2=view.findViewById(R.id.newarrivalmenu);
        newArrivalMenus=new ArrayList<>();
        recyclerView=view.findViewById(R.id.photorecycler);
        photoHomeArrayList=new ArrayList<>();
        recyclerView1=view.findViewById(R.id.recycle2);
        photoHomeArrayList=new ArrayList<>();


        photoHomeArrayList.add(new PhotoHome(R.drawable.model1,R.string.productname1,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model2,R.string.productname1,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model3,R.string.productname1,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model4,R.string.productname1,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model1,R.string.productname1,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model2,R.string.productname1,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model3,R.string.productname1,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model4,R.string.productname1,R.string.price));


        newArrivalMenus.add(new NewArrivalMenu("All"));
        newArrivalMenus.add(new NewArrivalMenu("Apparel"));
        newArrivalMenus.add(new NewArrivalMenu("Dress"));
        newArrivalMenus.add(new NewArrivalMenu("Tshirt"));
        newArrivalMenus.add(new NewArrivalMenu("Bag"));
        newArrivalMenus.add(new NewArrivalMenu("All"));
        newArrivalMenus.add(new NewArrivalMenu("Apparel"));
        newArrivalMenus.add(new NewArrivalMenu("Dress"));
        newArrivalMenus.add(new NewArrivalMenu("Tshirt"));
        newArrivalMenus.add(new NewArrivalMenu("Bag"));



        PhotoRecycler adapter=new PhotoRecycler(photoHomeArrayList,getContext());
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        PhotoRecycler2 adapter1=new PhotoRecycler2(photoHomeArrayList,getContext());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(adapter1);

        NAMenuRecycler adapter2=new NAMenuRecycler(newArrivalMenus,getContext());
        LinearLayoutManager layoutManager2=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);



        blogButton=view.findViewById(R.id.blog);
        blogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addblog(new Blog());

            }

            private void addblog(Blog recyclerblog) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,recyclerblog);
                ft.commit();
                ft.addToBackStack(null);
            }
        });
         view.findViewById(R.id.About).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 addabout(new About() );

             }

             private void addabout(About about) {
                 FragmentManager fm = getActivity().getSupportFragmentManager();
                 FragmentTransaction ft = fm.beginTransaction();
                 ft.replace(R.id.frame1,about);
                 ft.commit();
                 ft.addToBackStack(null);
             }
         });

         view.findViewById(R.id.contact).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 addcontacts(new Contact());
             }

             private void addcontacts(Contact contact) {
                 FragmentManager fm = getActivity().getSupportFragmentManager();
                 FragmentTransaction ft = fm.beginTransaction();
                 ft.replace(R.id.frame1,contact);
                 ft.commit();
                 ft.addToBackStack(null);
             }
         });

         view.findViewById(R.id.bannercollection).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 addcollections(new Collections());
             }

             private void addcollections(Collections collections) {
                 FragmentManager fm = getActivity().getSupportFragmentManager();
                 FragmentTransaction ft = fm.beginTransaction();
                 ft.replace(R.id.frame1,collections);
                 ft.commit();
                 ft.addToBackStack(null);
             }
         });
        explore= view.findViewById(R.id.arrow);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addproducts(new Products());
            }

            private void addproducts(Products products) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,products);
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        return view;
    }
}