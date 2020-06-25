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

public class Wkolnikam extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wkolnikam);

        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listWkol=(ListView)findViewById(R.id.spisok);
        SQLiteOpenHelper wkoladatabse = new WkolaDatabase(this);
        try{
            db=wkoladatabse.getReadableDatabase();
            cursor=db.query("WKOLA",new String[]{"_id,NAME"},
                    null, null, null, null, null);
            SimpleCursorAdapter cursorAdapter =new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,
                    cursor,new String[]{"NAME"},new int[]{android.R.id.text1},0);
            listWkol.setAdapter(cursorAdapter);
        }
        catch (SQLException e){
            Toast toast = Toast.makeText(this,"Ошибка базы данных",Toast.LENGTH_SHORT);
            toast.show();
        }
        AdapterView.OnItemClickListener itemClickListener= new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Wkolnikam.this,WkolnikamDetail.class);
                intent.putExtra(WkolnikamDetail.EXTRA_ID,id);
                startActivity(intent);
            }
        };
        listWkol.setOnItemClickListener(itemClickListener);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        db.close();
        cursor.close();
    }
}
