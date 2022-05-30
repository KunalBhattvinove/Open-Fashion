package com.example.mushop.Screens;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mushop.Model.Customer;
import com.example.mushop.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;


public class Checkout2 extends Fragment implements PaymentResultListener {

    Dialog mdialog;
    Customer customer;
    private  TextView name ,address;
    Context context;
    private TextView total;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.fragment_checkout2, container, false);
        Checkout.preload(getActivity().getApplicationContext());
        Bundle bundle1 = this.getArguments();
        String fname= bundle1.getString("key1");
        String add  = bundle1.getString("key2");
        name = view.findViewById(R.id.name_checkout);
        address  = view.findViewById(R.id.add_checkout1);
        total   = view.findViewById(R.id.total);
        name.setText(fname);
        address.setText(add);




        view.findViewById(R.id.add_checkout).setOnClickListener(new View.OnClickListener() {
            int total_sum =1200;
            @Override
            public void onClick(View view) {
                total_sum = total_sum + 1200;
                total.setText( Integer.toString(total_sum));

            }
        });

        view.findViewById(R.id.buynow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //  showAlertDialogButtonClicked(view);
           /* PurchaseConfirmationDialogFragment purchaseConfirmationDialogFragment = new PurchaseConfirmationDialogFragment();
            purchaseConfirmationDialogFragment.show(getActivity().getSupportFragmentManager(), "MY FRAGMENT");*/

              /*  POPUP popup = new POPUP();
                popup.show(getActivity().getSupportFragmentManager(),"MY FRAGMENT");
*/               String amt = total.getText().toString();
                PaymentNow(amt);

            }
        });




        return view;
    }

    private void PaymentNow(String amount) {
        final FragmentActivity activity = getActivity();


        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_mmpEuGoaauRGNy");
        checkout.setImage(R.drawable.razor_pay);

        double final_amount = Float.parseFloat(amount) * 100;


        try {
            JSONObject options = new JSONObject();
            options.put("name" , "Kunal Bhatt");
            options.put("Description", "Refrence No. #123456");
            options.put("theme.color","#010203");
            options.put("currency","INR");
            options.put("amount", final_amount+"");
            options.put("profile.email","Kunal0Bhatt@gmail.com");
            options.put("profile.contact","7290917547");

            checkout.open(activity,options);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showAlertDialogButtonClicked(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("AlertDialog");
        builder.setMessage("Would you like to continue learning how to use Android alerts?");
        // add the buttons
        builder.setPositiveButton("Continue", null);
        builder.setNegativeButton("Cancel", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onPaymentSuccess(String s) {
        addhome(new homepage());
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    private void addhome(homepage homepage) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1,homepage);
        ft.commit();
    }

    @Override
    public void onPaymentError(int i, String s) {
        addhome(new homepage());
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}