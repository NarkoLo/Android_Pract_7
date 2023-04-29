package com.example.android_pract_7.UI.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_pract_7.Data.Models.Product;
import com.example.android_pract_7.R;
import com.example.android_pract_7.UI.ViewModel.MarketplaceViewModel;
import com.example.android_pract_7.databinding.FragmentProductsListBinding;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MarketplaceFragment extends Fragment {
    FragmentProductsListBinding binding;
    MarketplaceViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProductsListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MarketplaceViewModel.class);

        RecycleViewProductsAdapter.OnProductClickListener listener = (product, position) -> {
            Log.i("ListView", "Selected item: " + position +
                    "\nTitle: " +  product.getProductTitle() +
                    "\nPrice: " + product.getProductPrice() +
                    "\nAmount " + product.getProductAmount());
            Toast.makeText(getContext(), "Selected product type:  "
                    + product.getProductTitle(), Toast.LENGTH_SHORT).show();
        };

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(new RecycleViewProductsAdapter(listener));

        viewModel.getProducts().observe(getViewLifecycleOwner(), (value) -> {
            ((RecycleViewProductsAdapter) Objects
                    .requireNonNull(binding.recyclerView.getAdapter()))
                    .updateData(value);
        });
    }

}
