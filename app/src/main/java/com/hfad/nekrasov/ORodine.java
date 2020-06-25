package com.hfad.nekrasov;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

public class ORodine extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor cursor;
    String databaseName= "RODINA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orodine);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView listView= (ListView)findViewById(R.id.list_rodiny);
        SQLiteOpenHelper sqLiteOpenHelper = new ORodineDatabase(this);
        try{
            db=sqLiteOpenHelper.getReadableDatabase();
            cursor=db.query(databaseName,new String[]{"_id,NAME"},null, null,
                    null, null, null);
            SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,
                    cursor,new String[]{"NAME"},new int[]{android.R.id.text1},0);
            listView.setAdapter(simpleCursorAdapter);
        }catch (SQLException e){
            Toast toast =Toast.makeText(this,"OWIBKA V SQL",Toast.LENGTH_SHORT);
            toast.show();
        }
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ORodine.this,ORodineDetail.class);
                intent.putExtra(ORodineDetail.EXTRA_ID,id);
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
