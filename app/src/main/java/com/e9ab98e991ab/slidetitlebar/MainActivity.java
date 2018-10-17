package com.e9ab98e991ab.slidetitlebar;

import android.content.Intent;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.e9ab98e991ab.slidetitlebar.databinding.ActivityMainBinding;
import com.e9ab98e991ab.slidetitlebar.ui.ScollerTitleBarActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.button1.setOnClickListener(v -> {
             startActivity(new Intent(this,ScollerTitleBarActivity.class));
        });
    }

}
