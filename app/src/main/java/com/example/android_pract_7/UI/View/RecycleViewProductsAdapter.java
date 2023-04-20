package com.example.android_pract_7.UI.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_pract_7.Data.Repository.DataSource.Product;

import java.util.List;

public class RecycleViewProductsAdapter extends RecyclerView.Adapter<ProductHolder> {
    private List<Product> products;

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
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
