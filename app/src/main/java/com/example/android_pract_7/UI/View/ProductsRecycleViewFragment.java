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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_pract_7.Data.Repository.DataSource.Product;
import com.example.android_pract_7.R;
import com.example.android_pract_7.databinding.FragmentProductsListBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsRecycleViewFragment extends Fragment {
    FragmentProductsListBinding binding;
    List<Product> products = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProductsListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecycleViewProductsAdapter.OnProductClickListener listener = (product, position) -> {
            Log.i("ListView", "Selected item: " + position +
                    "\nTitle: " +  product.getProductTitle() +
                    "\nPrice: " + product.getProductPrice() +
                    "\nAmount " + product.getProductAmount());
            Toast.makeText(getContext(), "Selected product type:  " + product.getProductTitle(), Toast.LENGTH_SHORT).show();
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 200; i++) {
            products.add(new Product("Beer", String.format("%.2f", new Random().nextDouble()*10) + " $",R.drawable.beer_icon));
        }

        RecycleViewProductsAdapter adapter = new RecycleViewProductsAdapter(products, listener);
        recyclerView.setAdapter(adapter);

    }
}
