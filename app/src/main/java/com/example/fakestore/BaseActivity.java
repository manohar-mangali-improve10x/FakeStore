package com.example.fakestore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fakestore.network.FakeApi;
import com.example.fakestore.network.FakeStoreService;

public class BaseActivity extends AppCompatActivity {

    protected FakeStoreService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFakeStore();
    }

    private void createFakeStore(){
        service = new FakeApi().createFakeApiService();
    }
}
