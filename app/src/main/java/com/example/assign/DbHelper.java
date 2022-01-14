package com.example.assign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public DbHelper(Context context) {
        super(context, "bloodbank.db", null, 1);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (name text, location text, bloodgroup text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void savedata(String name, String loc, String bg){

        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("location",loc);
        cv.put("bloodgroup",bg);

        sqLiteDatabase.insert("users",null,cv);

    }

    public boolean bgPresent(String sn2) {
        Cursor c;
        c= sqLiteDatabase.query("users",null,"bloodgroup=?",new String[]{sn2},
                null,null,null);

        c.moveToFirst();

        if(c.getCount()<1){
            return false;
        }
        return  true;
    }

    public List<String> getUsers(String sn2) {
        Cursor c;
        c= sqLiteDatabase.query("users",null,"bloodgroup=?",new String[]{sn2},
                null,null,null);

        List<String> list=new ArrayList<>();
        //c.moveToFirst();

        if (c.moveToFirst()) {
            do {

                list.add(c.getString(c.getColumnIndex("name")));
                list.add(c.getString(c.getColumnIndex("location")));
                list.add(c.getString(c.getColumnIndex("bloodgroup")));
                // cursor.moveToNext();

            } while (c.moveToNext());
        }

        return list;
    }
}
