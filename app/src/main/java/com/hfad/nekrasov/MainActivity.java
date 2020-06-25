package com.hfad.nekrasov;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView wkolnikam;
    private TextView poTipu;
    private TextView poTeme;
    private TextView avtor;

    private TextView rodina;
    private Typeface type;
    private Spinner spinner;
    public int pos=0;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("yourSpinner", spinner.getSelectedItemPosition());
        outState.putString("love",rodina.toString());
        // do this for each or your Spinner
        // You might consider using Bundle.putStringArray() instead
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null) {
            spinner.setSelection(savedInstanceState.getInt("yourSpinner"));
            // do this for each of your text views
        }
        spinner=(Spinner)findViewById(R.id.spinner);
        rodina=(TextView)findViewById(R.id.o_rodine);
        wkolnikam=(TextView)findViewById(R.id.po_wk_programe);
        poTeme=(TextView)findViewById(R.id.po_temam);
        avtor=(TextView)findViewById(R.id.avtor);
        poTipu=(TextView)findViewById(R.id.po_tipu);

        pos=spinner.getSelectedItemPosition();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(id==0){
                    type= null;
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;

                }
                if(id==1){
                    type= Typeface.createFromAsset(getAssets(), "fonts/antelive_bold.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;

                }
                else if(id==2){
                    type= Typeface.createFromAsset(getAssets(), "fonts/airfool.otf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==3){
                    type= Typeface.createFromAsset(getAssets(), "fonts/mak__light.otf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==4){
                    type= Typeface.createFromAsset(getAssets(), "fonts/soft_bold.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==5){
                    type= Typeface.createFromAsset(getAssets(), "fonts/voguer_sans.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==6){
                    type= Typeface.createFromAsset(getAssets(), "fonts/GothamPro_light.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==7){
                    type= Typeface.createFromAsset(getAssets(), "fonts/mr_Franklin_GothicG.otf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==8){
                    type= Typeface.createFromAsset(getAssets(), "fonts/mr_NewhouseExtraBlackG.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==9){
                    type= Typeface.createFromAsset(getAssets(), "fonts/mr_PaperBoyBG.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==10){
                    type= Typeface.createFromAsset(getAssets(), "fonts/Neothic.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }
                else if(id==11){
                    type= Typeface.createFromAsset(getAssets(), "fonts/Goose.ttf");
                    rodina.setTypeface(type);
                    wkolnikam.setTypeface(type);
                    poTeme.setTypeface(type);
                    avtor.setTypeface(type);
                    poTipu.setTypeface(type);
                    OlyubviDetail.type=type;
                    OprirodeDetail.type=type;
                    ORodineDetail.type=type;
                    WkolnikamDetail.type=type;
                    Avtor.type=type;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rodina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ORodine.class);
                startActivity(intent);
            }
        });
        avtor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Avtor.class);
                startActivity(intent);
            }
        });

        wkolnikam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Wkolnikam.class);
                startActivity(intent);
            }
        });

        poTeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Olyubvi.class);
                startActivity(intent);
            }
        });

        poTipu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Oprirode.class);
                startActivity(intent);
            }
        });

    }

}

