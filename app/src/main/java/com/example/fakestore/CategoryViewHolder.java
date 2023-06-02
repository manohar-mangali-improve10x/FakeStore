package com.example.fakestore;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CategoryItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    CategoryItemBinding binding;

    public CategoryViewHolder(@NonNull CategoryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
