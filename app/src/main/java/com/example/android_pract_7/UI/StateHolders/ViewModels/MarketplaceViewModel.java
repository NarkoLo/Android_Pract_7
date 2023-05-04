package com.example.android_pract_7.UI.StateHolders.ViewModels;

import androidx.lifecycle.LiveData;

import com.example.android_pract_7.Data.Models.Product;
import com.example.android_pract_7.Data.Repositories.ProductRepository;

import java.util.List;

public class MarketplaceViewModel extends androidx.lifecycle.ViewModel {

    private ProductRepository productRepository;
    private LiveData<List<Product>>  products;

    public MarketplaceViewModel(){
        productRepository = new ProductRepository();
        products = productRepository.getProducts();
    }

    public LiveData<List<Product>> getProducts() {
        return products;
    }
}
