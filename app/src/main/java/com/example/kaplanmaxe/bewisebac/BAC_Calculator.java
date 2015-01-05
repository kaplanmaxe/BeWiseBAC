package com.example.kaplanmaxe.bewisebac;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class BAC_Calculator extends Activity {
    Button btnAdd;
    Button btnClear;
    Button btnAddHour;
    Button btnClearHour;
    TextView txtDrinks;
    TextView txtHours;
    TextView txtBAC;
    int drinks = 0;
    int hours=0;
    Double bac=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer[] prefs = loadPref();
        if (prefs[2]==2 || prefs[3]==0) {
            Intent settings = new Intent();
            settings.setClass(BAC_Calculator.this, SetPreferenceActivity.class);
            startActivityForResult(settings,0);
        }
        setContentView(R.layout.activity_bac__calculator);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnAddHour = (Button)findViewById(R.id.btnAddHour);
        btnClearHour = (Button)findViewById(R.id.btnClearHour);
        txtDrinks = (TextView) findViewById(R.id.txtDrinks);
        txtHours = (TextView) findViewById(R.id.txtHours);
        txtBAC= (TextView) findViewById(R.id.txtBAC);

        //Add drink listener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hours ==0) {
                    hours=1;
                    txtHours.setText(String.valueOf(hours));
                }
                txtDrinks.setText(addDrinks());
                txtBAC.setText(calculateBAC());
            }
        });
        //Clear Drinks listener
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDrinks.setText(clearDrinks());
                txtBAC.setText(calculateBAC());
                //Toast.makeText(getApplicationContext(), "Your number of drinks has been cleared.",Toast.LENGTH_LONG).show();
            }
        });
        btnAddHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHours.setText(addHours());
                txtBAC.setText(calculateBAC());
            }
        });
        btnClearHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHours.setText(clearHours());
                txtBAC.setText(calculateBAC());
                //Toast.makeText(getApplicationContext(), "Your number of hours has been cleared.",Toast.LENGTH_LONG).show();
            }
        });
    }
    //Add drink method
    public String addDrinks() {
        Integer[] result = loadPref();
        if (result[0]==0 || result[1]==0) {
            new AlertDialog.Builder(this)
                    .setTitle("Settings not specified.")
                    .setMessage("You must enter your settings before you begin.")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent settings = new Intent();
                            settings.setClass(BAC_Calculator.this, SetPreferenceActivity.class);
                            startActivityForResult(settings,0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            drinks=0;
        }
        if (result[2]==2 || result[3]==0) {
            new AlertDialog.Builder(this)
                    .setTitle("Settings not specified.")
                    .setMessage("You must enter your settings before you begin.")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent settings = new Intent();
                            settings.setClass(BAC_Calculator.this, SetPreferenceActivity.class);
                            startActivityForResult(settings,0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            drinks=0;
        }
        else {

            drinks = drinks + 1;

        }
        //Will send notification of food places
        if (drinks==result[0]&&result[0]!=0) {
            new AlertDialog.Builder(this)
                    .setTitle("Local Food Places")
                    .setMessage("You drank quite a bit! Click here to view local food places")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent settings = new Intent();
                            settings.setClass(BAC_Calculator.this, ShowRestaurants.class);
                            startActivityForResult(settings,0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.sube_logo_white)
                            .setContentTitle("Local Food Places")
                            .setContentText("You drank quite a bit! Click here to find local food places.");

            Intent resultIntent = new Intent(this, ShowRestaurants.class);

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
                        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            // Adds the back stack for the Intent (but not the Intent itself)
                        stackBuilder.addParentStack(ShowRestaurants.class);
            // Adds the Intent that starts the Activity to the top of the stack
                        stackBuilder.addNextIntent(resultIntent);
                        PendingIntent resultPendingIntent =
                                stackBuilder.getPendingIntent(
                                        0,
                                        PendingIntent.FLAG_UPDATE_CURRENT
                                );
            mBuilder.setContentIntent(resultPendingIntent);


            int mNotificationId = 001;
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mBuilder.setVibrate(new long[] {0000,3000});
            // Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        }
        //Will send notification of hospitals
        if (drinks==result[1]&&result[1]!=0) {
            new AlertDialog.Builder(this)
                    .setTitle("Local Hospitals")
                    .setMessage("You drank a dangerous amount! Click here to view local hospitals.")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent settings = new Intent();
                            settings.setClass(BAC_Calculator.this, ShowHospitals.class);
                            startActivityForResult(settings,0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.sube_logo_white)
                            .setContentTitle("Local Hospitals")
                            .setContentText("You drank a dangerous amount! Click here to view local hospitals.");

            Intent resultIntent = new Intent(this, ShowHospitals.class);

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(ShowHospitals.class);
            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);


            int mNotificationId = 002;
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mBuilder.setVibrate(new long[] {0000,3000});
            mBuilder.setLights(0xff000000,300,100);
            // Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        }
        return String.valueOf(drinks);
    }
    //Clear drink method
    public String clearDrinks() {
        drinks=drinks-1;
        return String.valueOf(drinks);
    }
    //Add Hour Method
    public String addHours() {
        hours=hours+1;
        return String.valueOf(hours);
    }
    //Clear hour method
    public String clearHours() {
        hours=hours-1;
        return String.valueOf(hours);
    }
    public String calculateBAC() {
        Integer[] result = loadPref();
        //bac = (0.806 * drinks * 1.2) / (0.58 * (result[3]/2.2046)) - (0.017 * hours);
        int gender = result[2];
        double ratio = 0;
        if (gender==0) {
            ratio=0.73;
        }
        else if (gender==1) {
            ratio =0.66;
        }
        bac = (drinks * 5.14/result[3] * ratio)-(0.015*hours);
        NumberFormat formatter = new DecimalFormat("#0.0000");
        return String.valueOf(formatter.format(bac));
    }
    public Integer[] loadPref() {
        Integer[] prefs = new Integer[4];
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            String tmpstr = pref.getString("food", null);
            prefs[0] = Integer.parseInt(tmpstr);
        }
        catch (NumberFormatException e) {
            prefs[0] = 0;
        }
        try {
            String tmpstr = pref.getString("hospital", null);
            prefs[1] = Integer.parseInt(tmpstr);

        }
        catch (NumberFormatException e) {
            prefs[1]=0;
        }
        try {
            String gender = pref.getString("gender", null);
            if (gender.equals("Male")) {
                prefs[2] = 0;
            } else if (gender.equals("Female")) {
                prefs[2] = 1;
            }
            else {
                prefs[2]=2;
            }
        }
        catch (NullPointerException e) {
            prefs[2]=2;
        }
        try {
            String tmpstr = pref.getString("weight", null);
            prefs[3] = Integer.parseInt(tmpstr);
        }
        catch (NumberFormatException e) {
            prefs[3] = 0;
        }

        return prefs;

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bac__calculator, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            intent.setClass(BAC_Calculator.this, SetPreferenceActivity.class);
            startActivityForResult(intent,0);
            return true;
        }
        else if (id == R.id.restaurants) {
            Intent intent = new Intent();
            intent.setClass(BAC_Calculator.this, ShowRestaurants.class);
            startActivityForResult(intent,0);
            return true;
        }
        else if (id == R.id.hospitals) {
            Intent intent = new Intent();
            intent.setClass(BAC_Calculator.this, ShowHospitals.class);
            startActivityForResult(intent,0);
            return true;
        }
        else if (id == R.id.drinkMenu) {
            Intent intent = new Intent();
            intent.setClass(BAC_Calculator.this, drinkMenu.class);
            startActivityForResult(intent,0);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
