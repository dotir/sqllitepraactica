package com.example.sqllitepraactica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AutomovilSqlLiteHelper extends SQLiteOpenHelper {

    private String sqlCreate= "CREATE TABLE Automovil(Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"+
        ", Matricula TEXT"+
        ", Color TEXT)";

    public AutomovilSqlLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Automovil");

        db.execSQL(sqlCreate);

    }
}
