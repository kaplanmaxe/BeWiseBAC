package com.example.kaplanmaxe.bewisebac;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kaplanmaxe on 11/10/2014.
 */

public class ShowRestaurants extends Activity {
    TextView txtCallpita;
    TextView txtCallacropolis;
    TextView txtCallinsomnia;
    TextView txtCalljimmy;
    TextView txtCallcalios;
    TextView txtCalldominoes;
    TextView txtCallsliders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        txtCallpita = (TextView) findViewById(R.id.txtCallpita);
        txtCallpita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-315-479-0460"));
                startActivity(callIntent );
            }
        });
        txtCallacropolis = (TextView)findViewById(R.id.txtCallacropolis);
        txtCallacropolis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-315-472-4876"));
                startActivity(callIntent );
            }
        });
        txtCallinsomnia = (TextView) findViewById(R.id.txtCallinsomnia);
        txtCallinsomnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-877-632-6654"));
                startActivity(callIntent );
            }
        });
        txtCalljimmy = (TextView) findViewById(R.id.txtCalljimmy);
        txtCalljimmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-315-479-7827"));
                startActivity(callIntent );
            }
        });
        txtCallcalios = (TextView) findViewById(R.id.txtCallcalios);
        txtCallcalios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-315-426-9664"));
                startActivity(callIntent );
            }
        });
        txtCalldominoes = (TextView) findViewById(R.id.txtCalldominoes);
        txtCalldominoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-315-423-0333"));
                startActivity(callIntent );
            }
        });
        txtCallsliders = (TextView) findViewById(R.id.txtCallsliders);
        txtCallsliders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-315-428-8108"));
                startActivity(callIntent );
            }
        });

    }
}
