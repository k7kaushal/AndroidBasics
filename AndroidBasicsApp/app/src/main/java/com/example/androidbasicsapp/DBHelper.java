package com.example.androidbasicsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username text Primary key, password text)");
    }
    public boolean checkusername(String user){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {user});
        if(cursor.getCount() > 0) return true;
        else return false;
    }
    public boolean insertdata(String username, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);
        if(result == -1) return false;
        else return true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
}
