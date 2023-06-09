package com.example.fakestore.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.OnProductClickListener;
import com.example.fakestore.databinding.ProductItemBinding;
import com.example.fakestore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {
    private List<Product> products;
    private OnProductClickListener actionListener;

    public ProductsAdapter(List<Product> products) {
        this.products = products;
    }

    void createTaskListItem(List<Product> item) {
        this.products = item;
        notifyDataSetChanged();
    }

    void setActionListener(OnProductClickListener actionListener) {
        this.actionListener = actionListener;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductItemBinding binding = ProductItemBinding.inflate(inflater, parent, false);
        ProductsViewHolder viewHolder = new ProductsViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.titleTxt.setText(product.getTitle());
        holder.binding.priceTxt.setText(String.valueOf(product.getPrice()));
        holder.binding.countTxt.setText(String.valueOf(product.getRating().getCount()));
        holder.binding.ratingBarRb.setRating(product.getRating().getRate());
        Picasso.get().load(product.getImageUrl()).into(holder.binding.poster);
        holder.binding.getRoot().setOnClickListener(v -> {
            actionListener.onClick(product.getId());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
