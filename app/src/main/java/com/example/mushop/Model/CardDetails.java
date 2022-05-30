package com.example.mushop.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CardDetails")
public class CardDetails {
    @PrimaryKey(autoGenerate = true)
    private int cid;
    @ColumnInfo(name="customername")
    private String customername;
    @ColumnInfo(name = "cardnumber")
    private String cardnumber;
    @ColumnInfo(name="month")
    private String month;
    @ColumnInfo(name="year")
    private String year;

    public CardDetails(String customername, String cardnumber, String month, String year) {
        this.customername = customername;
        this.cardnumber = cardnumber;
        this.month = month;
        this.year = year;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
