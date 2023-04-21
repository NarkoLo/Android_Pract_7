package com.example.android_pract_7.Data.Repository;

import com.example.android_pract_7.Data.Repository.DataSource.Product;

public class Repository {
    private Product product;

    public Repository(Product product) {
        this.product = product;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
