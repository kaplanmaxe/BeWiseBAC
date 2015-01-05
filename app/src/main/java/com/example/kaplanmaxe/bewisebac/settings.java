package com.example.kaplanmaxe.bewisebac;

import android.os.Bundle;
import android.preference.PreferenceFragment;


/**
 * Created by kaplanmaxe on 11/6/2014.
 */
public class settings extends PreferenceFragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);

    }
}
