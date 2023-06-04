package com.example.fakestore.network;

import com.example.fakestore.CartProduct;
import com.example.fakestore.model.Cart;
import com.example.fakestore.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreService {
    @GET("api/v1/categories")
    Call<List<Product>> getCategory();

//    @GET("products/category/{categoryName}")
//    Call<List<Product>> getProduct(@Path("categoryName")String categoryName);
//
//    @GET("products/{productId}")
//    Call<Product> getProductDetails(@Path("productId") int productId);
//
//    @GET("carts/{cartId}")
//    Call<Cart> getCartDetails(@Path("cartId") int cartId);
}
