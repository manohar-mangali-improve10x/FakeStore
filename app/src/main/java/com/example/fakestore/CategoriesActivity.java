package com.example.fakestore;

import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.fakestore.databinding.ActivityCategoriesBinding;
import com.example.fakestore.model.Product;
import com.example.fakestore.products.ProductsActivity;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity implements ProductService {
    private ActivityCategoriesBinding binding;
    private List<Product> items = new ArrayList<>();
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        getData();
        setupAdapter();
        connectAdapter();
    }



    private void connectAdapter() {
        binding.categoriesRv.setAdapter(adapter);
        binding.categoriesRv.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void setupAdapter() {
        adapter = new CategoryAdapter(items);
        adapter.setActionListener(this);
    }

    private void getData() {
        Call<List<Product>> call = service.getCategory();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                adapter.createCategory(response.body());

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClicked(Product product) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);

    }
}