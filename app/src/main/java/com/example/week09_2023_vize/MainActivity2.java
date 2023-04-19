package com.example.week09_2023_vize;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      int sayi=  getIntent().getIntExtra("Sayi",0);
        tv=(TextView) findViewById(R.id.textView2);


        SQLiteDatabase db = openOrCreateDatabase("KiloTakip",MODE_PRIVATE,null);

        Cursor c= db.rawQuery("Select * from MyTable Order by Mydate DESC", null);
       StringBuilder sb= new StringBuilder("");

        if(c!=null)
            if(c.moveToFirst()){
                do{
                    int indexKilo=c.getColumnIndex("Kilo");
                    int indexDate=c.getColumnIndex("Mydate");
                    sb.append(""+c.getInt(indexKilo) +"\t");
                    sb.append(c.getString(indexDate) +"\n");


                }while(c.moveToNext());




            }






        tv.setText(sb.toString());




    }
}