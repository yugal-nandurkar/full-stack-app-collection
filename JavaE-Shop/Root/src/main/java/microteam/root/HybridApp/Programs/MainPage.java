package microteam.root.HybridApp.Programs;

//package com.eshop.hybridapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.eshop.hybridapp.databinding.ActivityMainBinding;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout and bind it
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(R.layout.activity_main); // XML layout file defining the MainPage
    }
}
