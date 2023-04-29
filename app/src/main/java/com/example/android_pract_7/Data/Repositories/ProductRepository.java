package com.example.android_pract_7.Data.Repositories;

import androidx.lifecycle.LiveData;

import com.example.android_pract_7.Data.DataSource.ProductDataSource;
import com.example.android_pract_7.Data.Models.Product;

import java.util.List;


public class ProductRepository {
    ProductDataSource productDataSource;
    private Product product;

    public ProductRepository(Product product){
        this.product = product;
    }

    public LiveData<List<Product>> getProducts() {
        return productDataSource.products();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
