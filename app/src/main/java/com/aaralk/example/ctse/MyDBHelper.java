package com.aaralk.example.ctse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaralk on 3/11/2018.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mydatabase.db";

    public MyDBHelper(Context context) {
        super(context.getApplicationContext(),DB_NAME,null,1);
    }

    public void save(String value){
        ContentValues cv = new ContentValues();
        cv.put("value",value);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("my_table",null,cv);
        db.close();
    }

    public String read(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT value FROM my_table WHERE id = " + id,null);
        cur.moveToNext();
        return cur.getString(cur.getColumnIndex("value"));
    }

    public List<Data> readAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM my_table",null);
        cur.moveToNext();
        int idIdx = cur.getColumnIndex("id");
        int valueIdx = cur.getColumnIndex("value");
        List<Data> data = new ArrayList<>();
        while(!cur.isAfterLast()) {
            Integer id = cur.getInt(idIdx);
            String value = cur.getString(valueIdx);
            data.add(new Data(id,value));
            cur.moveToNext();
        }
        return data;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE my_table (id integer PRIMARY_KEY, value text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

