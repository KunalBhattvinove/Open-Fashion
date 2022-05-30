package com.example.mushop.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mushop.Model.CardDetails;
import com.example.mushop.Model.Customer;
import com.example.mushop.Model.LoginDetails;

@Database(entities = {Customer.class, CardDetails.class, LoginDetails.class},exportSchema = false,version =5)
public abstract class DataBase extends RoomDatabase {
    private static final String DB_NAME = "customer_database";
    private static DataBase customer1;

    public static synchronized DataBase getInstance(Context context) {
        if (customer1 == null) {
            customer1 = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, DB_NAME).fallbackToDestructiveMigration().build();
        }
        return customer1;
    }

    public abstract DataAO dataAO();

}