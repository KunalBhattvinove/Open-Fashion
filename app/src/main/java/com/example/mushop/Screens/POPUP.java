package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mushop.R;
import com.example.mushop.Screens.homepage;


public class POPUP extends DialogFragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_p_o_p_u_p, container, false);
        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "YOU RESPONSE IS SUBMITTED", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.backtohome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addhome(new homepage());
            }

            private void addhome(homepage homepage) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,homepage);
                ft.commit();
                getDialog().dismiss();
            }
        });
        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return view;

    }
}