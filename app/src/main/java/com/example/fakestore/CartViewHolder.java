package com.example.fakestore;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CartItemBinding;

public class CartViewHolder extends RecyclerView.ViewHolder {
    CartItemBinding binding;

    public CartViewHolder(CartItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
