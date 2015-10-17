package com.example.barak.bostontutorials;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Barak on 15/09/2015.
 */
public class Photo extends Activity implements View.OnClickListener{
    Button buttonSetPicture;
    ImageView imageViewScreen;
    ImageButton imageButtonSnap;
    Intent i;
    final static int cameraData = 0;
    Bitmap bmpTaken, bmpCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
    }

    private void initialize() {
        buttonSetPicture = (Button)findViewById(R.id.bSetWall);
        imageButtonSnap = (ImageButton) findViewById(R.id.ibTakePic);
        imageViewScreen = (ImageView) findViewById(R.id.ivReturnedPic);
        buttonSetPicture.setOnClickListener(this);
        imageButtonSnap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibTakePic:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
            case R.id.bSetWall:
                try {
                    getApplicationContext().setWallpaper(bmpTaken);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bmpTaken = (Bitmap) extras.get("data");
            imageViewScreen.setImageBitmap(bmpTaken);
        }
    }
}
