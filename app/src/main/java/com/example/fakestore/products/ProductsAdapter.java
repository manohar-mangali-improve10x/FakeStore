package com.example.fakestore.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.SetupActionListener;
import com.example.fakestore.databinding.ProductItemBinding;
import com.example.fakestore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {
    private List<Product> products;
    private SetupActionListener actionListener;

    public ProductsAdapter(List<Product> products) {
        this.products = products;
    }

    void createTaskListItem(List<Product> item) {
        this.products = item;
        notifyDataSetChanged();
    }

    void setActionListener(SetupActionListener actionListener) {
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
        Picasso.get().load(product.getImages().get(0)).into(holder.binding.poster);
        holder.binding.getRoot().setOnClickListener(v -> {
            actionListener.onClicked(product.getId());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
