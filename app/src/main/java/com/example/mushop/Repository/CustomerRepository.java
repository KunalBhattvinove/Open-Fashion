package com.example.mushop.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mushop.DataBase.DataAO;
import com.example.mushop.DataBase.DataBase;
import com.example.mushop.Model.CardDetails;
import com.example.mushop.Model.Customer;
import com.example.mushop.Model.LoginDetails;

import java.util.List;

public class CustomerRepository {
    DataAO dataAO;
    private Customer customer;
    private LiveData<List<Customer>> allData;
    private CardDetails card;
    private LoginDetails login;
    private LiveData<List<CardDetails>>cards;
    private LiveData<List<LoginDetails>>logins;


    public CustomerRepository(Application application) {
        DataBase dataBase=DataBase.getInstance(application);
        dataAO=dataBase.dataAO();
        allData=dataAO.getCustomer();
    }

    public LiveData<List<Customer>> getAllData()
    {
        return allData;
    }
    public LiveData<List<CardDetails>>getCards(){ return cards; }
    public LiveData<List<LoginDetails>>getLogin(){return logins;}

    public void insert(Customer customer)
    {
        new InsertCustomer(dataAO).execute(customer);
    }
    public void insertcards(CardDetails card){new InsertCard(dataAO).execute(card);}
    public void insertlogins(LoginDetails login){new InsertLogin(dataAO).execute(login);}

    public static class InsertCustomer extends AsyncTask<Customer,Void,Void>
    {
        private DataAO dataAO;
        public InsertCustomer(DataAO dataAO)
        {
            this.dataAO=dataAO;
        }

        @Override
        protected Void doInBackground(Customer... customers) {
            dataAO.insertCustomer(customers[0]);
            return null;
        }
    }

    public static class InsertCard extends AsyncTask<CardDetails,Void,Void>
    {
        private DataAO dataAO;
        public InsertCard(DataAO dataAO){this.dataAO=dataAO;}

        @Override
        protected Void doInBackground(CardDetails... cardDetails) {
            dataAO.insertCard(cardDetails[0]);
            return null;
        }
    }

    public static class InsertLogin extends AsyncTask<LoginDetails,Void,Void>
    {private DataAO dataAO;
        public InsertLogin(DataAO dataAO){this.dataAO=dataAO;}

        @Override
        protected Void doInBackground(LoginDetails... loginDetails) {
            dataAO.insertLogin(loginDetails[0]);
            return null;
        }
    }
}
