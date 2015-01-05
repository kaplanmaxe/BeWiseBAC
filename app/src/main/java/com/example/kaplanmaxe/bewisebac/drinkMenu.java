package com.example.kaplanmaxe.bewisebac;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ClipDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.kaplanmaxe.bewisebac.R;

/**
 * Created by kaplanmaxe on 11/19/2014.
 */
public class drinkMenu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks);
        Button btnShot = (Button) findViewById(R.id.btnShot);
        Button btnWine = (Button) findViewById(R.id.btnWine);
        Button btnBeer = (Button) findViewById(R.id.btnBeer);
        final ImageView imgOne = (ImageView) findViewById(R.id.one_oz);
        final ImageView imgFive = (ImageView) findViewById(R.id.five_oz);
        final ImageView imgTwelve = (ImageView) findViewById(R.id.twelve_oz);
        btnShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTwelve.setImageResource(0);
                imgFive.setImageResource(0);
                imgOne.setImageResource(R.drawable.oneoz);
            }
        });
        btnWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTwelve.setImageResource(0);
                imgFive.setImageResource(0);
                imgFive.setImageResource(R.drawable.fiveoz);
            }
        });
        btnBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTwelve.setImageResource(0);
                imgFive.setImageResource(0);
                imgTwelve.setImageResource(R.drawable.twelveoz);
            }
        });
    }
}
