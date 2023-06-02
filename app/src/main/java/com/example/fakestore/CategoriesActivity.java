package com.example.fakestore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestore.databinding.ActivityCategoriesBinding;
import com.example.fakestore.model.Category;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeStoreService;
import com.example.fakestore.network.OnServiceActionListener;
import com.example.fakestore.products.ProductsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity implements OnServiceActionListener {
    private ActivityCategoriesBinding binding;
    private List<String> items = new ArrayList<>();
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Categories");
        getData();
        setAdapter();
        connectAdapter();
    }

    private void connectAdapter() {
        binding.categoriesRv.setAdapter(adapter);
        binding.categoriesRv.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void setAdapter() {
        adapter = new CategoryAdapter(items);
        adapter.setProduct(this);
    }


    private void getData() {
        FakeStoreService service = new FakeApi().createFakeApiService();
        Call<List<String>> call = service.getCategory();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Toast.makeText(CategoriesActivity.this, "sucess", Toast.LENGTH_SHORT).show();
                adapter.createCategory(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onProductClicked(String category) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("category",category);
        startActivity(intent);

    }
}