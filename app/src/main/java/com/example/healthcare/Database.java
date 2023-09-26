package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  qry1= "create table users(username text,email text,password text )";
        db.execSQL(qry1);
        String qry2="create table cart(username text,product text,price float,otype text)";
        db.execSQL(qry2);
        String qry3="create table orderplace(username text,fullname text,address text,contactno text,pincode int,date text,amount float,otype text)";
        db.execSQL(qry3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void register(String username,String email,String password){
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }



    public  int login(String username,String password){
        int result=0;
        String[] str =new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        return  result;

    }
    public  void addCart(String username,String product,float price,String otype){
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("product",product);
        contentValues.put("price",price);
        contentValues.put("otype",otype);
        SQLiteDatabase database=getWritableDatabase();
        database.insert("cart",null,contentValues);
        database.close();

    }
    public  int checkCart(String username,String product){
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=product;
        SQLiteDatabase database=getReadableDatabase();
        Cursor c=database.rawQuery("select*from cart where username=? and product=?",str);
        if (c.moveToFirst()){
            return 1;
        }
        database.close();
        return  result;

    }
    public  void removeCart(String username,String otype){

        String str[]=new String[2];
        str[0]=username;
        str[1]=otype;
        SQLiteDatabase db=getWritableDatabase();
        db.delete("cart","username=? and otype=?",str);
        db.close();

    }

    public ArrayList getCartData(String username,String otype){

        ArrayList<String> arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String str[]=new String[2];
        str[0]=username;
        str[1]=otype;
        Cursor c=db.rawQuery("select * from cart where username=? and otype = ?",str);
        if (c.moveToFirst()){
            do {
                String product=c.getString(1);
                String price=c.getString(2);
                arr.add(product+"$"+price);
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }
    public void addOrder(String username,String fullname,String address,String contact,int pincode,String date,float price,String otype){
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("fullname",fullname);
        cv.put("address",address);
        cv.put("contactno",contact);
        cv.put("pincode",pincode);
        cv.put("date",date);
        cv.put("amount",price);
        cv.put("otype",otype);

        SQLiteDatabase db=getWritableDatabase();
        db.insert("orderPlace",null,cv);
        db.close();
    }

}
