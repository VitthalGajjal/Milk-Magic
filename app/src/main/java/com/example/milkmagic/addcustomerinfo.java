package com.example.milkmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class addcustomerinfo extends AppCompatActivity {
     DatabaseHelper db;
    EditText et_customer_name,et_customer_phone,et_customer_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcustomerinfo);
        db = new DatabaseHelper(this);
        et_customer_name = findViewById(R.id.et_customer_name);
        et_customer_phone = findViewById(R.id.et_customer_phone);
        et_customer_address = findViewById(R.id.et_customer_address);



    }

    public void savecustomerinfo(View view) {
        String name= et_customer_name.getText().toString();
        String phone=et_customer_phone.getText().toString() ;
        String address= et_customer_address.getText().toString();
        if(!name.equals("") && db.insertcustomerinfo(name ,phone ,address))
        {
            Toast.makeText(addcustomerinfo.this,"data inserted",Toast.LENGTH_LONG).show();
            et_customer_name.setText("");
            et_customer_phone.setText("");
            et_customer_address.setText("");

        }
        else
        {
            Toast.makeText(addcustomerinfo.this,"Data not inserted",Toast.LENGTH_LONG).show();
        }
        finish();
        Intent i = new Intent(addcustomerinfo.this, customerinfo.class);
        startActivity(i);
    }



}