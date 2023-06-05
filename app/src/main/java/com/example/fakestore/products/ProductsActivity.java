package com.example.fakestore.products;

import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.BaseActivity;
import com.example.fakestore.SetupActionListener;
import com.example.fakestore.databinding.ActivityProductsBinding;
import com.example.fakestore.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity implements SetupActionListener {

    private ActivityProductsBinding binding;
    private List<Product> products = new ArrayList<>();
    private ProductsAdapter adapter;

    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Products");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        setupAdapter();
        connectAdapter();
    }


    private void connectAdapter() {
        binding.productsRv.setAdapter(adapter);
        binding.productsRv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void setupAdapter() {
        adapter = new ProductsAdapter(products);
        adapter.setActionListener(this);
    }

    private void getData(Product product) {
        Call<List<Product>> call = service.fetchProducts(product.getId());
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                adapter.createTaskListItem(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData(product);
    }

    @Override
    public void onClicked(int productId) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("product", productId);
        startActivity(intent);
    }
}