package com.example.android_pract_7.Data.DataSource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android_pract_7.Data.Models.Product;
import com.example.android_pract_7.R;


import java.util.ArrayList;
import java.util.List;

public class ProductDataSource {
    public LiveData<List<Product>> products() {
        MutableLiveData<List<Product>> result = new MutableLiveData<>();

        new Thread(() -> {
            ArrayList<Product> resultArr = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                resultArr.add(new Product("Beer", "1$", R.drawable.beer));
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            result.postValue(resultArr);
        }).start();


        return result;
    }

}
