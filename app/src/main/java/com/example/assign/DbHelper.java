package com.example.assign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public DbHelper(Context context) {
        super(context, "details.db", null, 1);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (phone text, password text, name text, location text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void savedata(String phone, String password, String name, String loc){

        ContentValues cv = new ContentValues();
        cv.put("phone",phone);
        cv.put("password",password);
        cv.put("name",name);
        cv.put("location",loc);

        sqLiteDatabase.insert("users",null,cv);

    }

    public String getPassword(String sn2) {
        Cursor c;
        c= sqLiteDatabase.query("users",null,"phone=?",new String[]{sn2},
                null,null,null);

        c.moveToFirst();

        if(c.getCount()<1){
            return "not exist";
        }

        String v = c.getString(c.getColumnIndex("password"));

        return v;
    }

    public String getName(String sn2) {
        Cursor c;
        c= sqLiteDatabase.query("users",null,"phone=?",new String[]{sn2},
                null,null,null);

        c.moveToFirst();

        if(c.getCount()<1){
            return "not exist";
        }

        String v = c.getString(c.getColumnIndex("name"));

        return v;
    }
}
