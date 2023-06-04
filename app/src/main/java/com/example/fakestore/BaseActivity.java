package com.example.fakestore;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeStoreService;

public class BaseActivity extends AppCompatActivity {

    protected FakeStoreService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        createFakeStore();
    }

    private void createFakeStore(){
        service = new FakeApi().createFakeApiService();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if (item.getItemId() == R.id.cart_menu){
           Intent intent = new Intent(this,CartActivity.class);
           startActivity(intent);
       }return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
