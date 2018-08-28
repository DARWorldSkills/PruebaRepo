package com.caucaragp.worldskills.primerensayo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GestorDb extends SQLiteOpenHelper {
    public GestorDb(Context context) {
        super(context,"hola.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE HOLA(NOMBRE TEXT);");
    }

    public void insertHola(){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NOMBRE",":)");
        db.insert("HOLA",null,values);
        db.close();
    }

    public List<String> selectHola(){
        List<String> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT() FROM HOLA;",null);
        if (cursor.moveToFirst()){
            do {
                String hola = cursor.getColumnName(0);
                results.add(hola);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();


        return results;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
