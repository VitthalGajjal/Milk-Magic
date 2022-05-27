package com.example.milkmagic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String db_name ="mydb";
    public static final String db_table1 ="customer_table";
    public static final String db_table2 ="work_table";

    public static final String table1_id ="customer_id";
    public static final String table1_name ="customer_name";
    public static final String table1_phone ="customer_phone";
    public static final String table1_address ="customer_address";

    public static final String table2_id ="work_id";
    public static final String table2_name ="work_name";
    public static final String table2_type ="work_type";
    public static final String table2_date ="work_date";
    public static final String table2_fat ="work_fat";
    public static final String table2_srf ="work_srf";
    public static final String table2_quantity ="work_quantity";
    public static final String table2_total ="work_total";

    public DatabaseHelper( Context context) {
        super(context, db_name , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE customer_table (customer_id INTEGER PRIMARY KEY AUTOINCREMENT, customer_name TEXT  , customer_phone TEXT , customer_address TEXT)");
        db.execSQL("CREATE TABLE work_table ( work_id INTEGER PRIMARY KEY AUTOINCREMENT, work_name TEXT , work_type TEXT , work_date TEXT , work_fat FLOAT , work_srf FLOAT , work_quantity FLOAT , work_total FLOAT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertcustomerinfo(String name,String phone,String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(table1_name,name);
        contentvalues.put(table1_phone,phone);
        contentvalues.put(table1_address,address);
        long result = db.insert(db_table1,null,contentvalues);
        return result != -1;
    }


    public boolean insertworkinfo(String name , String type , String date , float fat , float srf , float quantity , float total){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(table2_name,name);
        contentvalues.put(table2_type,type);
        contentvalues.put(table2_date,date);
        contentvalues.put(table2_fat,fat);
        contentvalues.put(table2_srf,srf);
        contentvalues.put(table2_quantity,quantity);
        contentvalues.put(table2_total,total);
        long result = db.insert(db_table2,null,contentvalues);
        return result != -1;
    }

    public boolean deteteworkinfo(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from work_table where work_name=?", new String[] {name});
        if (cursor.getCount() > 0) {
            long result = db.delete(db_table2,  table2_name+ "=?", new String[] {name});
            if(result==-1){
                return false; }
            else{
                return true; }
        }
        else{
            return  false; }
    }

    public boolean detetecustomerinfo(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+db_table1+" where "+table1_name+"=?", new String[] {name});
        if (cursor.getCount() > 0) {
            long result = db.delete(db_table1, table1_name+ "=?", new String[] {name});
            if(result==-1){
                return false; }
            else{
                return true; }
        }
        else{
            return  false; }
    }

    public List<Customer> showcustomerinfo(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Customer> l = new ArrayList<>();

        String query = "Select * from "+db_table1+" order by customer_name asc";
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()) {
            String custname = cursor.getString(1);
            String custmobile = cursor.getString(2);
            String custaddr = cursor.getString(3);
            Customer c = new Customer(custname, custmobile, custaddr);
            l.add(c);
        }
        return l;
    }
    public List<Work> showworkinfo(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Work> l = new ArrayList<>();

        String query = "Select * from "+db_table2+" order by work_id desc";
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            String type= cursor.getString(2);
            String date= cursor.getString(3);
            String fat= cursor.getString(4);
            String srf= cursor.getString(5);
            String quantity= cursor.getString(6);
            String total= cursor.getString(7);
            Work w = new Work(name,type,date,fat,srf,quantity,total);
            l.add(w);
        }
        return l;
    }
}
