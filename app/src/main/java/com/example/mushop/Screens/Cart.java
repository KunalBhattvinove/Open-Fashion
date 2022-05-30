package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mushop.R;


public class Cart extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);
        view.findViewById(R.id.buynow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*addcheckout(new CheckOut());*/
                login(new Login());

            }
        });
        return view;
    }

    /*private void addcheckout(CheckOut checkOut) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,checkOut);
        ft.commit();
        ft.addToBackStack(null);*/

    private void login(Login login)
    {
        FragmentManager fm=getActivity().getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame1,login);
        ft.commit();
        ft.addToBackStack(null);

    }
}