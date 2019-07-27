package com.example.sqllitepraactica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button btnCreate;
    private Button btnDelete;
    private Button btnUpdate;


    private AutomovilSqlLiteHelper automovilHelper;
    private SQLiteDatabase db;

    private List<Automovil> automoviles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        automoviles = new ArrayList<>();
        automovilHelper = new AutomovilSqlLiteHelper(this,"BDPrueba",null,1);
        db=automovilHelper.getWritableDatabase();

        btnCreate=findViewById(R.id.button);
        btnDelete=findViewById(R.id.button2);
        btnUpdate=findViewById(R.id.button3);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("BtnCreate","Click");
                create();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("BtnDelete","Click");
                removeAll();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("BtnUpdate","Click");
                update();
            }
        });

    }

    private void create(){
        Log.i("Create","Datos nuevos");

        if (db!=null){
            ContentValues nuevoregistro = new ContentValues();
            nuevoregistro.put("Matricula","X3B-165");
            nuevoregistro.put("Color","Azul");
            db.insert("Automovil",null,nuevoregistro);
        }
    }

    private void removeAll(){
        db.delete("Automovil","",null);
    }

    private void update(){

        Log.i("update","");
        automoviles.clear();
        automoviles.addAll(getAllCars());
    }

    private Collection<? extends Automovil> getAllCars(){
        Log.i("getAllCars","");
        Cursor cursor = db.rawQuery("select * from Automovil",null);
        List<Automovil> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            if (cursor.isAfterLast() == false) {
                Automovil auxAuto = new Automovil(
                        cursor.getInt(cursor.getColumnIndex("Id")),
                        cursor.getString(cursor.getColumnIndex("Matricula")),
                        cursor.getString(cursor.getColumnIndex("Color"))
                );
                Log.i("getAllCars", auxAuto.getMatricula());
                list.add(auxAuto);

                cursor.moveToNext();
            }
        }

        Log.i("getAllCars - Size",String.valueOf(list.size()));
        return list;
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();

    }
}
