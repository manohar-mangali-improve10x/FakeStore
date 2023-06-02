package com.example.fakestore.products;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.CategoriesActivity;
import com.example.fakestore.CategoryAdapter;
import com.example.fakestore.OnProductClickListener;
import com.example.fakestore.ProductDetailsActivity;
import com.example.fakestore.R;
import com.example.fakestore.databinding.ActivityProductsBinding;
import com.example.fakestore.model.Product;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeStoreService;
import com.example.fakestore.network.OnServiceActionListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity implements OnProductClickListener {

    private ActivityProductsBinding binding;
    private List<Product> products = new ArrayList<>();
    private ProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Products");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String item = intent.getStringExtra("category");
        getData(item);
        setAdapter();
        connectAdapter();
    }

    private void connectAdapter() {
        binding.productsRv.setAdapter(adapter);
        binding.productsRv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void setAdapter() {
        adapter = new ProductsAdapter(products);
        adapter.setListener(this);

    }

    private void getData(String category) {
        FakeStoreService service = new FakeApi().createFakeApiService();
        Call<List<Product>> call = service.getProduct(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                adapter.createTaskListItem(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });


    }

    @Override
    public void onProductClick(int productId) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("product", productId);
        startActivity(intent);


    }
}