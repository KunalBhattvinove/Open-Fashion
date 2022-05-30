package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mushop.Adapter.PhotoRecycler;
import com.example.mushop.Model.PhotoHome;
import com.example.mushop.R;

import java.util.ArrayList;


public class Mainproduct extends Fragment {

    private ArrayList<PhotoHome> photoHomeArrayList;;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mainproduct, container, false);
        recyclerView = view.findViewById(R.id.recycler10);
        photoHomeArrayList=new ArrayList<>();


        photoHomeArrayList.add(new PhotoHome(R.drawable.model1,R.string.proda,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model2,R.string.proda,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model3,R.string.proda,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model4,R.string.proda,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model1,R.string.proda,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model2,R.string.proda,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model3,R.string.proda,R.string.price));
        photoHomeArrayList.add(new PhotoHome(R.drawable.model4,R.string.proda,R.string.price));

         PhotoRecycler adapter=new PhotoRecycler(photoHomeArrayList,getContext());
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.addtobasket).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "ADDED TO CART", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}