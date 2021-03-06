package com.hfad.nekrasov;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class OlyubviDetail extends AppCompatActivity {
    public static final String EXTRA_ID="id";
    public static final String TIP= "TIP";
    int textSize=16;


    private TextView nazvanie_stiha;
    private TextView soderjanie_stiha;
    private AdView mAdView;
    public static Typeface type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_lyubvi_detail);

        nazvanie_stiha= (TextView)findViewById(R.id.nazvanie_stiha);
        soderjanie_stiha=(TextView)findViewById(R.id.soderjanie_stiha);

        this.nazvanie_stiha.setTextIsSelectable(true);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewLOVE);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        long idLove = (long) getIntent().getExtras().get(EXTRA_ID);
        SQLiteOpenHelper sqLiteOpenHelper = new LoveDatabase(this);
        try{
            SQLiteDatabase db =sqLiteOpenHelper.getReadableDatabase();
            Cursor cursor =db.query("LOVE",new String[]{"NAME","STIH"},"_id = ?",
                    new String[]{Long.toString(idLove)},null,null,null);
            if(cursor.moveToFirst()){

                CharSequence name =cursor.getString(0);
                CharSequence soder=cursor.getString(1);
                nazvanie_stiha.setText(name);
                soderjanie_stiha.setText(soder);


            }
            cursor.close();
            db.close();

        }
        catch (SQLiteException e) {
            Toast toast = Toast.makeText(this,
                    "Database unavailable",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        this.nazvanie_stiha.setTypeface(type);
        this.soderjanie_stiha.setTypeface(type);
    }
    public void onClickCheckBox(View view){
        long idLove = (long) getIntent().getExtras().get(EXTRA_ID);
        CheckBox check=(CheckBox)findViewById(R.id.checkbox);


        ContentValues contentValues =new ContentValues();
        contentValues.put("FAVORITE",check.isChecked());
        SQLiteOpenHelper sqLiteOpenHelper=new LoveDatabase(this);

        try{
            SQLiteDatabase db=sqLiteOpenHelper.getWritableDatabase();
            db.update("LOVE",contentValues,"_id = ?",new String[]{Long.toString(idLove)});
            db.close();
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this,
                    "Database unavailable",
                    Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int itemId =  menuItem.getItemId();
        if(itemId==R.id.antelive_bold){
            type= Typeface.createFromAsset(getAssets(), "fonts/antelive_bold.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.airfool){
            type= Typeface.createFromAsset(getAssets(), "fonts/airfool.otf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.mak_light){
            type= Typeface.createFromAsset(getAssets(), "fonts/mak__light.otf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.soft_bold){
            type= Typeface.createFromAsset(getAssets(), "fonts/soft_bold.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.voguer_sans){
            type= Typeface.createFromAsset(getAssets(), "fonts/voguer_sans.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.gotham_pro){
            type= Typeface.createFromAsset(getAssets(), "fonts/GothamPro_light.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.mr_FranklinGothicG){
            type= Typeface.createFromAsset(getAssets(), "fonts/mr_Franklin_GothicG.otf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.mr_NewhouseExtraBlackG){
            type= Typeface.createFromAsset(getAssets(), "fonts/mr_NewhouseExtraBlackG.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.mmr_PaperBoyBG){
            type= Typeface.createFromAsset(getAssets(), "fonts/mr_PaperBoyBG.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);

        }
        if(itemId==R.id.Neothic){
            type= Typeface.createFromAsset(getAssets(), "fonts/Neothic.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        if(itemId==R.id.Goose){
            type= Typeface.createFromAsset(getAssets(), "fonts/Goose.ttf");
            nazvanie_stiha.setTypeface(type);
            soderjanie_stiha.setTypeface(type);
        }
        else{
            if(itemId==R.id.umen){
                textSize--;
                nazvanie_stiha.setTextSize(textSize);
                soderjanie_stiha.setTextSize(textSize);
            }
            else if(itemId==R.id.uvel){
                textSize++;
                nazvanie_stiha.setTextSize(textSize);
                soderjanie_stiha.setTextSize(textSize);
            }
        }


        return super.onOptionsItemSelected(menuItem);

    }

}
