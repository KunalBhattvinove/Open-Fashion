package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mushop.R;


public class menu extends Fragment   {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=   inflater.inflate(R.layout.fragment_menu, container, false);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);


        view.findViewById(R.id.newarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addfragment(new Mainproduct());
            }

            private void addfragment(Mainproduct mainproduct) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.frame1,mainproduct);
                ft.commit();
            }
        });
       return  view;



    }


}