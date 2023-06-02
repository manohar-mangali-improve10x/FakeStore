package com.example.fakestore.products;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.ProductItemBinding;

public class ProductsViewHolder extends RecyclerView.ViewHolder {
    ProductItemBinding binding;

    public ProductsViewHolder(@NonNull ProductItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
