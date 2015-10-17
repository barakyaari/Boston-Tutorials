package com.example.barak.bostontutorials;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Barak on 22/09/2015.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
