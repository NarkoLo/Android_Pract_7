package com.example.android_pract_7.Data.Models;


import lombok.Getter;
import lombok.Setter;


public class Product {
    private String productTitle;
    private String productPrice;
    private int productImageId;
    private String productAmount;

    public Product(String productTitle, String productPrice, int imageId) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productImageId = imageId;

    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(int productImageId) {
        this.productImageId = productImageId;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }
}
