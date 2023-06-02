package com.example.fakestore;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CategoryItemBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<String> categories;
    private OnServiceActionListener actionListener;

    public CategoryAdapter(List<String> categories) {
        this.categories = categories;
    }

    void createCategory(List<String> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    void setProduct(OnServiceActionListener listener) {
        this.actionListener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CategoryItemBinding binding = CategoryItemBinding.inflate(inflater, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String category = categories.get(position);
        holder.binding.categoriesTxt.setText(category);
        holder.binding.getRoot().setOnClickListener(v -> {
            actionListener.onClicked(category);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}

