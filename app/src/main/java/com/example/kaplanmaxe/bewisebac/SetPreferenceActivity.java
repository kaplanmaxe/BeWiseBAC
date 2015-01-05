package com.example.kaplanmaxe.bewisebac; /**
 * Created by kaplanmaxe on 11/10/2014.
 */
import android.app.Activity;
import android.os.Bundle;

import com.example.kaplanmaxe.bewisebac.settings;

public class SetPreferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new settings()).commit();
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
