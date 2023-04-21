package com.example.android_pract_7.UI.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android_pract_7.Data.Repository.DataSource.Product;
import com.example.android_pract_7.Data.Repository.Repository;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<Repository> productUI = new MutableLiveData<>(
            new Repository(new Product(null,null,0)));
    public LiveData<Repository> getProductUI(){
        return productUI;
    }
    public void addProduct(String title, String price, int imageID){
        productUI.setValue(new Repository(new Product(title, price, imageID)));

    }
}
