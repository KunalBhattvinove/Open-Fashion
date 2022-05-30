package com.example.mushop.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Customer")
public class Customer {

    @PrimaryKey(autoGenerate = true)
    private int cid;
    @ColumnInfo(name="firstname")
    private String firstname;
    @ColumnInfo(name = "lastname")
    private String lastname;
    @ColumnInfo(name="address")
    private String address;
    @ColumnInfo(name="city")
    private String city;
    @ColumnInfo(name="state")
    private String state;
    @ColumnInfo(name="zipcode")
    private String zipcode;
    @ColumnInfo(name="mobilenumber")
    private String mobilenumber;

    public Customer(String firstname, String lastname, String address, String city, String state, String zipcode, String mobilenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.mobilenumber = mobilenumber;
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
