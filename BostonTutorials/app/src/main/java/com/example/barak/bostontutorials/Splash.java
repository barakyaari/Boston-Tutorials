package com.example.barak.bostontutorials;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;

/**
 * Created by Barak on 14/09/2015.
 */
public class Splash extends Activity{
    MediaPlayer ourSong;

    @Override

    protected void onCreate(Bundle bobcat) {
        super.onCreate(bobcat);
        setContentView(R.layout.splash);
       ourSong = MediaPlayer.create(Splash.this, R.raw.godfather);
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean playMusic = getPrefs.getBoolean("checkbox", true);
        if(playMusic == true){
            ourSong.start();
        }
        Thread timer = new Thread(){
          public void run(){
              try {
               Thread.sleep(5000);
              }
              catch (InterruptedException e){
                e.printStackTrace();
              }
              finally {
                  Intent openStartingPoint = new Intent("com.example.barak.bostontutorials.Menu");
                  startActivity(openStartingPoint);
              }
          }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();
    }
}
