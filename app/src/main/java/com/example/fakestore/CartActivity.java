package com.example.fakestore;

import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.fakestore.databinding.ActivityCartBinding;
import com.example.fakestore.model.Cart;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends BaseActivity {

    private ActivityCartBinding binding;
    private CartAdapter adapter;
    private List<CartProduct> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Cart");
//        getData(1);
        setupAdapter();
        connectAdapter();
    }

//    private void getData(int cartId) {
//        Call<Cart> call = service.getCartDetails(cartId);
//        call.enqueue(new Callback<Cart>() {
//            @Override
//            public void onResponse(Call<Cart> call, Response<Cart> response) {
//                adapter.createTaskListItem(response.body().getProducts());
//            }
//
//            @Override
//            public void onFailure(Call<Cart> call, Throwable t) {
//
//            }
//        });
//
//    }

//    private void setUpActionListener() {
//        adapter.actionListener = new SetupActionListener() {
//            @Override
//            public void onAddClick(CartProduct product) {
//            product.getQuantity();
//            adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onRemoveClick(CartProduct product) {
//                product.getQuantity();
//                adapter.notifyDataSetChanged();
//
//            }
//        };
//    }

    private void connectAdapter() {
        binding.cartMenuRv.setAdapter(adapter);
        binding.cartMenuRv.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void setupAdapter() {
        adapter = new CartAdapter(items);
    }
}