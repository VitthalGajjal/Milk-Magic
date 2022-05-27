package com.example.milkmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class addwork extends AppCompatActivity {

    DatabaseHelper db;
    EditText et_work_name,et_work_fat,et_work_srf,et_work_quantity,et_work_total;
    RadioButton rb;
    RadioGroup rg_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwork);
        db = new DatabaseHelper(this);
        et_work_name=findViewById(R.id.et_work_name);
        et_work_fat=findViewById(R.id.et_work_fat);
        et_work_srf=findViewById(R.id.et_work_srf);
        et_work_quantity=findViewById(R.id.et_work_quantity);
        et_work_total=findViewById(R.id.et_work_total);
        rg_type=findViewById(R.id.rg_type);
    }

    public void checkbtn(View v){
        int radioId = rg_type.getCheckedRadioButtonId();
        rb = findViewById(radioId);
    }

    public void savework(View view) {
        String type = rb.getText().toString();
        Calendar calendar = Calendar.getInstance();
        String date= DateFormat.getDateInstance().format(calendar.getTime());
        String name = et_work_name.getText().toString();
        Float fat= Float.parseFloat(et_work_fat.getText().toString()) ;
        Float srf= Float.parseFloat(et_work_srf.getText().toString()) ;
        Float quantity= Float.parseFloat(et_work_quantity.getText().toString()) ;
        Float total= Float.parseFloat(et_work_total.getText().toString()) ;
        if(!name.equals("") && db.insertworkinfo(name ,type ,date,fat,srf,quantity,total)){
            Toast.makeText(addwork.this,"data inserted",Toast.LENGTH_LONG).show();
            et_work_name.setText("");
            et_work_fat.setText("");
            et_work_srf.setText("");
            et_work_quantity.setText("");
            et_work_total.setText("");
        }
        else{
            Toast.makeText(addwork.this,"Data not inserted",Toast.LENGTH_LONG).show();

        }
        finish();
        Intent i = new Intent(addwork.this, todayswork.class);
        startActivity(i);
    }




}