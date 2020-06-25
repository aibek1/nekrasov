package com.hfad.nekrasov;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Oprirode extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_prirode);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView= (ListView)findViewById(R.id.list_priroda);

        SQLiteOpenHelper sqLiteOpenHelper = new PrirodaDatabase(this);
        try{
            db = sqLiteOpenHelper.getReadableDatabase();
            cursor=db.query("PRIRODA",new String[]{"_id,NAME"},null,
                    null, null, null, null);
            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,
                    cursor, new String[]{"NAME"},new int[]{ android.R.id.text1});
            listView.setAdapter(cursorAdapter);
        }catch (SQLException s){
            Toast toast =Toast.makeText(this,"SQL OWIBKA",Toast.LENGTH_SHORT);
            toast.show();
        }
        AdapterView.OnItemClickListener itemClickListener =new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(Oprirode.this,OprirodeDetail.class);
                intent.putExtra(OprirodeDetail.EXTRA_ID,id);
                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        db.close();
        cursor.close();
    }
}

