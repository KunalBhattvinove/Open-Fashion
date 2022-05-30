package com.example.mushop.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mushop.Model.CardDetails;
import com.example.mushop.Model.Customer;
import com.example.mushop.Model.LoginDetails;

import java.util.List;

@Dao
public interface DataAO {
    @Insert(onConflict = REPLACE)
    void insertCustomer(Customer customer);

    @Query("SELECT * FROM Customer")
    LiveData<List<Customer>> getCustomer();

    @Insert(onConflict = REPLACE)
    void insertCard(CardDetails card);

    @Query("Select * from CardDetails")
    LiveData<List<CardDetails>>getcard();

    @Insert(onConflict = REPLACE)
    void insertLogin(LoginDetails details);

    @Query("Select * from logindetails")
    LiveData<List<LoginDetails>>getlogin();

    @Query("SELECT * FROM logindetails WHERE email=(:emailid) and password=(:passwordenter)")
    LoginDetails login(String emailid,String passwordenter);



}