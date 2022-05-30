package com.example.mushop.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mushop.Model.Customer;
import com.example.mushop.R;
import com.example.mushop.ViewModel.CustomerViewModel;


public class PlaceOrder extends Fragment {


    EditText fname,lname,address,city,state,zip,phno;
    private CustomerViewModel dataviewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_place_order, container, false);
        dataviewModel= new ViewModelProvider(this).get(CustomerViewModel.class);
        fname=view.findViewById(R.id.first_name);
        lname=view.findViewById(R.id.last_name);
        address=view.findViewById(R.id.address);
        city = view.findViewById(R.id.city);
        state= view.findViewById(R.id.state);
        zip = view.findViewById(R.id.zip);
        phno= view.findViewById(R.id.phonenumber);

        view.findViewById(R.id.addnow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f_name = fname.getText().toString();
                String l_name = lname.getText().toString();
                String addres = address.getText().toString();
                String s_city = city.getText().toString();
                String s_state = state.getText().toString();
                String s_zip = zip.getText().toString();
                String s_phno = phno.getText().toString();
                if (TextUtils.isEmpty(fname.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter your first name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(lname.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter your last name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(address.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Address", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(city.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter City", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(state.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter State", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(zip.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Zip code", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(phno.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
                } else {

                    Customer customer = new Customer(f_name, l_name, addres, s_city, s_state, s_zip, s_phno);
                    dataviewModel.insert(customer);
                    Toast.makeText(getActivity(), "REGISTERED", Toast.LENGTH_SHORT).show();

                    addcard(new Checkout2());
                }
            }

            private void addcard(Checkout2 checkout2) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("key1",fname.getText().toString());
                bundle.putString("key2",address.getText().toString());
                FragmentTransaction ft = fm.beginTransaction();
                checkout2.setArguments(bundle);
                ft.replace(R.id.frame1,checkout2);
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        return view;
    }
}