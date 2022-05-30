package com.example.mushop.Screens;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.Toast;

import com.example.mushop.Model.CardDetails;
import com.example.mushop.R;
import com.example.mushop.ViewModel.CustomerViewModel;


public class Card extends Fragment {
    EditText name,cardnumber,month,year,cvv;
    CustomerViewModel customerViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_card, container, false);
        name=view.findViewById(R.id.name_payment);
        cardnumber=view.findViewById(R.id.cardnumber);
        month=view.findViewById(R.id.exp_month);
        year=view.findViewById(R.id.exp_year);
        cvv=view.findViewById(R.id.cvv);

        customerViewModel=new ViewModelProvider(this).get(CustomerViewModel.class);
        Bundle bundle = this.getArguments();
        String f_name =  bundle.getString("key1");
        String address = bundle.getString("key2");



        view.findViewById(R.id.addcard12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCheckout2(new Checkout2());
            }

            private void addCheckout2(Checkout2 checkout2) {
                String s_name = name.getText().toString();
                String s_card = cardnumber.getText().toString();
                String s_month = month.getText().toString();
                String s_year = year.getText().toString();
                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("error");
                    Toast.makeText(getActivity(), "Enter Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cardnumber.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Card Number", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(month.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Month", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(year.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Year", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cvv.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Month", Toast.LENGTH_SHORT).show();
                } else {
                    CardDetails card = new CardDetails(s_name, s_card, s_month, s_year);
                    customerViewModel.insertCards(card);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("key3", f_name);
                    bundle1.putString("key4", address);
                    Toast.makeText(getActivity(), "New Card Added", Toast.LENGTH_SHORT).show();
                    FragmentManager fm = getActivity().getSupportFragmentManager();


                    FragmentTransaction ft = fm.beginTransaction();
                    checkout2.setArguments(bundle1);
                    ft.replace(R.id.frame1, checkout2);
                    ft.addToBackStack(null);
                    ft.commit();

                }
            }
        });
        return view;
    }

}