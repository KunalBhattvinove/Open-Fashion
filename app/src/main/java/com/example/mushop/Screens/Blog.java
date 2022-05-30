package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mushop.R;


public class Blog extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blog, container, false);
        view.findViewById(R.id.gotoblog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addbloglist(new Bloglist());
            }
        });
        return view;
    }

    private void addbloglist(Bloglist bloglist) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,bloglist);
        ft.commit();
    }
}