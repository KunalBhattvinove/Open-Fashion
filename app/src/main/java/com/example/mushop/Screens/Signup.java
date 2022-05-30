package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mushop.Model.LoginDetails;
import com.example.mushop.R;
import com.example.mushop.ViewModel.CustomerViewModel;


public class Signup extends Fragment {
    Button signup;
    EditText name,email,pass;
    CustomerViewModel customerViewModel;
    TextView login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_signup, container, false);
        name=view.findViewById(R.id.userlogin);
        email=view.findViewById(R.id.mail);
        pass=view.findViewById(R.id.password);
        signup=view.findViewById(R.id.bsignuppage);
        login=view.findViewById(R.id.here);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login login = new Login();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,login);
                ft.commit();
            }
        });
        customerViewModel=new ViewModelProvider(this).get(CustomerViewModel.class);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_name=name.getText().toString();
                String s_email=email.getText().toString();
                String s_pass=pass.getText().toString();
                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("error");
                    Toast.makeText(getActivity(), "Enter Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email.getText().toString()) || !Patterns.EMAIL_ADDRESS.matcher(s_email).matches()) {
                    Toast.makeText(getActivity(), "Enter email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Password", Toast.LENGTH_SHORT).show();
                }else{

                LoginDetails details=new LoginDetails(s_name,s_email,s_pass);
                customerViewModel.insertLogins(details);
                Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Login to continue", Toast.LENGTH_LONG).show();
                Login login = new Login();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame1,login);
                ft.commit();}

            }
        });

        return view;
    }
}