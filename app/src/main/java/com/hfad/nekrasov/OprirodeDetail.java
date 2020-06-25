package com.hfad.nekrasov;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class OprirodeDetail extends AppCompatActivity {
    public static final String EXTRA_ID="id";
    TextView nazvanie_stiha;
    TextView soderjanie_stiha;
    AdView mAdView;
    public static Typeface type;
    int textSize=16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_prirode_detaol);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewPRORODA);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        long idPriroda = (long)getIntent().getExtras().get(EXTRA_ID);

        SQLiteOpenHelper sqLiteOpenHelper =new PrirodaDatabase(this);

        try{
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            Cursor cursor=db.query("PRIRODA",new String[]{"NAME,STIH"},"_id=?",new String[]{Long.toString(idPriroda)},
                    null,null,null);
            if(cursor.moveToFirst()) {
                nazvanie_stiha = (TextView) findViewById(R.id.nazvanie_stiha);
                soderjanie_stiha = (TextView) findViewById(R.id.soderjanie_stiha);
                nazvanie_stiha.setText(cursor.getString(0));
                soderjanie_stiha.setText(cursor.getString(1));
            }
            db.close();
            cursor.close();
        }catch (SQLException s){
            Toast toast = Toast.makeText(this,
                    "Database unavailable",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        nazvanie_stiha.setTypeface(type);
        soderjanie_stiha.setTypeface(type);
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

