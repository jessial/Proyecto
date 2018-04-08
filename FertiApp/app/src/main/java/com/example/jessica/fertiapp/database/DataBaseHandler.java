package com.example.jessica.fertiapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jessica on 1/4/2018.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE usuario (cedula INTEGER NOT NULL, nombre TEXT NOT NULL, apellido TEXT NOT NULL, telefono INTEGER , email TEXT NOT NULL, CONSTRAINT Key1 PRIMARY KEY (cedula) ON DELETE RESTRICT ON UPDATE CASCADE);";
    String sqlDrop = "DROP TABLE IF EXISTS usuario; ";
    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlDrop);


    }
}
