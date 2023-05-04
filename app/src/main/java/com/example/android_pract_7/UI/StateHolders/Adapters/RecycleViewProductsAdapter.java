package com.example.android_pract_7.UI.StateHolders.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_pract_7.Data.Models.Product;
import com.example.android_pract_7.R;
import com.example.android_pract_7.UI.StateHolders.Holders.ProductHolder;


import java.util.ArrayList;
import java.util.List;

public class RecycleViewProductsAdapter extends RecyclerView.Adapter<ProductHolder> {

   public interface OnProductClickListener{
        void onClick(Product product, int position);
    }

    private  List<Product> products;
    private final OnProductClickListener onProductClickListener;

    public RecycleViewProductsAdapter(OnProductClickListener productClickListener) {
        this.products = new ArrayList<>();
        this.onProductClickListener = productClickListener;
    }
    public void updateData(List<Product> newData) {
        products = newData;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = products.get(position);
        holder.productTitle.setText(product.getProductTitle());
        holder.productAmount.setText(product.getProductAmount());
        holder.productPrice.setText(product.getProductPrice());
        holder.productImage.setImageResource(product.getProductImageId());
        holder.itemView.setOnClickListener(v -> onProductClickListener.onClick(product,holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
