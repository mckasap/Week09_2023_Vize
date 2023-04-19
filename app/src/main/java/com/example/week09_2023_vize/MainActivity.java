package com.example.week09_2023_vize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.editTextNumber);


    }
    public void Git(View v){
        int sayi=Integer.parseInt(et.getText().toString());
        Intent myInt= new Intent(this,MainActivity2.class);

        SQLiteDatabase db = openOrCreateDatabase("KiloTakip",MODE_PRIVATE,null);
        db.execSQL("Create Table If not exists MyTable(Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +"Mydate text Default (datetime(current_timestamp)),   Kilo int(3) NOT NULL)");

        myInt.putExtra("Sayi",2*sayi);

db.execSQL("Insert into MyTable(Kilo) Values("+sayi+")");
db.close();
        startActivity(myInt);

    }
}