package com.example.fakestore.network;

import com.example.fakestore.model.Category;
import com.example.fakestore.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreService {
    @GET("products/categories")
    Call<List<String>> getCategory();
    @GET("products/category/{categoryName}")
    Call<List<Product>> getProduct(@Path("categoryName")String categoryName);

    @GET("products/{productId}")
    Call<Product> getProductDetails(@Path("productId") int productId);
}
