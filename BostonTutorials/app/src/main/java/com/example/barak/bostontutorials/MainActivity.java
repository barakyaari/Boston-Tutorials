package com.example.barak.bostontutorials;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int count;
    public Button bAdd, bSub;
    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        bAdd = (Button)findViewById(R.id.bAdd);
        bSub = (Button)findViewById(R.id.bSub);
        textView = (TextView) findViewById(R.id.tvDisplay);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText("Your count is: " + count);
            }
        });
        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                textView.setText("Your count is: " + count);
            }
        });
    }



}
