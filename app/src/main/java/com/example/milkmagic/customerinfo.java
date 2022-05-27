package com.example.milkmagic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class customerinfo extends AppCompatActivity {
    DatabaseHelper db;
    List<Customer> customers = new ArrayList<>();
    RecyclerView rv_customerinfo;
    CustomerAdapter cu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerinfo);
        rv_customerinfo = findViewById(R.id.rv_customerinfo);

        db = new DatabaseHelper(customerinfo.this);
        customers = db.showcustomerinfo();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getCustomer_name() + "-" + customers.get(i).getCustomer_phone() + "-" + customers.get(i).getCustomer_address());
        }


        cu = new CustomerAdapter(customerinfo.this, customers);
        rv_customerinfo.setAdapter(cu);

        LinearLayoutManager l = new LinearLayoutManager(customerinfo.this, RecyclerView.VERTICAL, false);
        rv_customerinfo.setLayoutManager(l);
    }

    public void addcustomerinfo(View view) {
        finish();
        Intent i = new Intent(customerinfo.this, addcustomerinfo.class);
        startActivity(i);

    }

}