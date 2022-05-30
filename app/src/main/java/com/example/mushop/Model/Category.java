package com.example.mushop.Model;

public class Category {
    public Category(int images, String brands, String names, String prices) {
        this.images = images;
        this.brands = brands;
        this.names = names;
        this.prices = prices;
    }



    private int images;
    private String brands;

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    private String names;
    private String prices;


}