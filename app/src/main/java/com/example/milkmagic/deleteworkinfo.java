package com.example.milkmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deleteworkinfo extends AppCompatActivity {
    EditText et_serachdeletecustomer;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteworkinfo);
        et_serachdeletecustomer = findViewById(R.id.et_serachdeletecustomer);
        db = new DatabaseHelper(deleteworkinfo.this);
    }

    public void workinfodelete(View view) {
        String name= et_serachdeletecustomer.getText().toString();
        boolean delete = db.deteteworkinfo(name);
        if(delete == true){
            Toast.makeText(getApplicationContext(),"work deleted",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"work not deleted",Toast.LENGTH_LONG).show();
        }
        finish();
        Intent i = new Intent(deleteworkinfo.this, todayswork.class);
        startActivity(i);
    }
}