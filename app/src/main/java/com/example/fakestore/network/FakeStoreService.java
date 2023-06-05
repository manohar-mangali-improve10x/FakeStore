package com.example.fakestore.network;

import com.example.fakestore.CartProduct;
import com.example.fakestore.model.Cart;
import com.example.fakestore.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FakeStoreService {
    @GET("api/v1/categories")
    Call<List<Product>> getCategory();

    @GET("/api/v1/products/")
    Call<List<Product>> fetchProducts(@Query("categoryId") int categoryId);

    @GET("api/v1/products/{productId}")
    Call<Product> fetchProductDetails(@Path("productId") int productId);
//
//    @GET("carts/{cartId}")
//    Call<Cart> getCartDetails(@Path("cartId") int cartId);
}
