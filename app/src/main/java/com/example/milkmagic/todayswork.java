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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class todayswork extends AppCompatActivity {
    DatabaseHelper db;
    List<Work> works = new ArrayList<>();
    RecyclerView rv_workinfo;
    WorkAdapter wo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todayswork);


        db = new DatabaseHelper(todayswork.this);
        works = db.showworkinfo();
        for (int i = 0; i < works.size(); i++) {
            System.out.println(works.get(i).getWork_name() + "-" +
                    works.get(i).getWork_type() + "-" +
                    works.get(i).getWork_date() + "-" +
                    works.get(i).getWork_fat() + "-" +
                    works.get(i).getWork_srf() + "-" +
                    works.get(i).getWork_quantity() + "-" +
                    works.get(i).getWork_total()

            );
        }
        rv_workinfo = findViewById(R.id.rv_todayswork);
        wo = new WorkAdapter(com.example.milkmagic.todayswork.this, works);
        rv_workinfo.setAdapter(wo);

        LinearLayoutManager l = new LinearLayoutManager(com.example.milkmagic.todayswork.this, RecyclerView.VERTICAL, false);
        rv_workinfo.setLayoutManager(l);
    }

    public void addwork(View view) {
        finish();
        Intent i = new Intent(todayswork.this, addwork.class);
        startActivity(i);

    }

    public void deletework(View view) {
        finish();
        Intent i = new Intent(todayswork.this, deleteworkinfo.class);
        startActivity(i);
    }

}