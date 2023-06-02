package com.example.fakestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.fakestore.databinding.ActivityProductDetailsBinding;
import com.example.fakestore.model.Product;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeStoreService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {
    private ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int productId = intent.getIntExtra("product", 0);
        fetchProductDetails(productId);
    }

    private void fetchProductDetails(int productId) {
        FakeStoreService service = new FakeApi().createFakeApiService();
        Call<Product> call = service.getProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                binding.costTxt.setText(String.valueOf(product.getPrice()));
                binding.count1Txt.setText(String.valueOf(product.getRating().getCount()));
                binding.title1Txt.setText(product.getTitle());
                binding.descriptionTxt.setText(product.getDescription());
                binding.ratingBar1Rb.setRating(product.getRating().getRate());
                Picasso.get().load(product.getImageUrl()).into(binding.poster1Iv);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });

    }
}