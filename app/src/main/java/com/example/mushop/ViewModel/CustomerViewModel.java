package com.example.mushop.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mushop.Model.CardDetails;
import com.example.mushop.Model.Customer;
import com.example.mushop.Model.LoginDetails;
import com.example.mushop.Repository.CustomerRepository;

import java.util.List;

public class CustomerViewModel extends AndroidViewModel {
    private CustomerRepository customerRepository;
    private LiveData<List<Customer>> getAllData;
    private LiveData<List<CardDetails>>getcards;
    private LiveData<List<LoginDetails>>getlogins;

    public CustomerViewModel(@NonNull Application application) {
        super(application);
        customerRepository=new CustomerRepository(application);
        getAllData=customerRepository.getAllData();
        getcards=customerRepository.getCards();
        getlogins=customerRepository.getLogin();
    }
    public void insert(Customer customer)
    {
        customerRepository.insert(customer);
    }

    public void insertCards(CardDetails card) { customerRepository.insertcards(card);}

    public void insertLogins(LoginDetails login){customerRepository.insertlogins(login);}
}
