package com.example.fakestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestore.databinding.CartItemBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    List<CartProduct> carts;

    public CartAdapter(List<CartProduct> cartProducts){
        this.carts = cartProducts;
    }

    void createTaskListItem(List<CartProduct> item) {
        this.carts = item;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(inflater, parent, false);
        CartViewHolder viewHolder = new CartViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartProduct item = carts.get(position);
        holder.binding.cartTxt.setText(String.valueOf(item.getProductId()));
        if (item.getQuantity() == 0){
            holder.binding.minusBtn.setVisibility(View.GONE);
            holder.binding.quntityTxt.setVisibility(View.GONE);

        }else {
            holder.binding.quntityTxt.setText(item.getQuantity()+"");
            holder.binding.minusBtn.setVisibility(View.VISIBLE);
            holder.binding.cartTxt.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }
}
