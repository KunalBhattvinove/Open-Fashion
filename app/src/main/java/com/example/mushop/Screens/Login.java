package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mushop.DataBase.DataAO;
import com.example.mushop.DataBase.DataBase;
import com.example.mushop.Model.LoginDetails;
import com.example.mushop.R;


public class Login extends Fragment {
    EditText user, pass;
    Button button;
    TextView signup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        user = view.findViewById(R.id.user);
        pass = view.findViewById(R.id.pass);
        signup=view.findViewById(R.id.signuphere);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup signup = new Signup();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,signup);
                ft.commit();
            }
        });
        button = view.findViewById(R.id.bsignin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = user.getText().toString();
                String password = pass.getText().toString();
                if (TextUtils.isEmpty(user.getText().toString())) {
                    Toast.makeText(getActivity(), "LOGIN INCOMPLETE", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass.getText().toString())) {
                    Toast.makeText(getActivity(), "FILL PASSWORD", Toast.LENGTH_SHORT).show();
                } else {
                    DataBase userDatabase = DataBase.getInstance(getActivity());
                    DataAO userDao = userDatabase.dataAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            LoginDetails userModel = userDao.login(login, password);
                            if (userModel == null) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(), "INVALID", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(getActivity(), "REGISTER YOUSELF", Toast.LENGTH_SHORT).show();
                                        Signup signup = new Signup();
                                        FragmentManager fm = getActivity().getSupportFragmentManager();
                                        FragmentTransaction ft = fm.beginTransaction();
                                        ft.replace(R.id.frame1,signup);
                                        ft.commit();
                                    }
                                });
                            } else {   //Myprojectreference.setLoggedIn(getActivity(), true);
                                PlaceOrder fragment4 = new PlaceOrder();
                                FragmentManager fm = getActivity().getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.frame1, fragment4);
                                ft.commit();
                            }
                        }
                    }).start();


                }
            }
        });
        return view;
    }
}