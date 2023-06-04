package com.example.fakestore.products;

import android.content.Intent;
import android.os.Bundle;

import com.example.fakestore.BaseActivity;
import com.example.fakestore.databinding.ActivityProductDetailsBinding;
import com.example.fakestore.model.Product;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {
    private ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product Details");
//        Intent intent = getIntent();
//        int productId = intent.getIntExtra("product", 0);
//        fetchProductDetails(productId);
    }
//
//    private void fetchProductDetails(int productId) {
//        Call<Product> call = service.getProductDetails(productId);
//        call.enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                Product product = response.body();
//                binding.costTxt.setText(String.valueOf(product.getPrice()));
//                binding.count1Txt.setText(String.valueOf(product.getRating().getCount()));
//                binding.title1Txt.setText(product.getTitle());
//                binding.descriptionTxt.setText(product.getDescription());
//                binding.ratingBar1Rb.setRating(product.getRating().getRate());
//                Picasso.get().load(product.getImageUrl()).into(binding.poster1Iv);
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//
//            }
//        });
//
//    }

}