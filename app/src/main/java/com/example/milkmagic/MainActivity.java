package com.example.milkmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aboutus(View view) {
    }

    public void customerinfo(View view) {
        Intent i = new Intent(MainActivity.this, customerinfo.class);
        startActivity(i);
    }

    public void todayswork(View view) {
        Intent i = new Intent(MainActivity.this, todayswork.class);
        startActivity(i);
    }

}