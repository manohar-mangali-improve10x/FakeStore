package com.example.fakestore;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CategoryItemBinding;
import com.example.fakestore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<Product> products;

    public CategoryAdapter(List<Product> products) {
        this.products = products;
    }

    void createCategory(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
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
        Product product = products.get(position);
        holder.binding.categoriesTxt.setText(product.getName());
//        holder.binding.idTxt.setText(product.getId()+"");
//        Picasso.get().load(product.getImage()).into(holder.binding.posterIv);
//        holder.binding.getRoot().setOnClickListener(v -> {
//            actionListener.onClicked(product);
//        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

