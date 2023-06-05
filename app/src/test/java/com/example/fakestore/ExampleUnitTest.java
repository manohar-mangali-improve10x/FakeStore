package com.example.fakestore;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.fakestore.model.Cart;
import com.example.fakestore.model.Product;
import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeStoreService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategory() throws IOException {
        FakeStoreService service = new FakeApi().createFakeApiService();
        Call<List<Product>> call = service.getCategory();
        List<Product> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void getProducts() throws IOException {
        FakeStoreService service = new FakeApi().createFakeApiService();
        Call<List<Product>> call = service.fetchProducts(1);
        List<Product> products = call.execute().body();
        assertFalse(products.isEmpty());
        assertNotNull(products);
        System.out.println(new Gson().toJson(products));

    }

    @Test
    public void getProductDetails() throws IOException {
        FakeStoreService service = new FakeApi().createFakeApiService();
        Call<Product> call = service.fetchProductDetails(4);
        Product product = call.execute().body();
        assertNotNull(product);
        System.out.println(new Gson().toJson(product));
//
//    }
//    @Test
//    public void getCartItem() throws IOException {
//        FakeStoreService service = new FakeApi().createFakeApiService();
//        Call<Cart> call = service.getCartDetails(1);
//        Cart product = call.execute().body();
//        assertNotNull(product);
//        System.out.println(new Gson().toJson(product));
//    }
    }
}