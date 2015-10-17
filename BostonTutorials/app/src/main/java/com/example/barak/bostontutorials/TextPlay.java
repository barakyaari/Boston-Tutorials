package com.example.barak.bostontutorials;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by Barak on 14/09/2015.
 */
public class TextPlay extends Activity implements View.OnClickListener{

    Button chkCmd;
    ToggleButton passToggle;
    EditText input;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        chkCmd = (Button) findViewById(R.id.bResults);
        passToggle = (ToggleButton) findViewById(R.id.tbPassword);
        input = (EditText) findViewById(R.id.etCommands);
        display = (TextView) findViewById(R.id.tvResults);
        passToggle.setOnClickListener(this);
        chkCmd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bResults:{
                String check = input.getText().toString();
                if(check.contentEquals("left")){
                    display.setGravity(Gravity.LEFT);
                }
                else if(check.contentEquals("center")){
                    display.setGravity(Gravity.CENTER);
                }
                else if(check.contentEquals("right")){
                    display.setGravity(Gravity.RIGHT);
                }
                else if(check.contentEquals("blue")){
                    display.setBackgroundColor(Color.BLUE);
                }
                else if(check.contentEquals("wtf")){
                    Random crazy = new Random();
                    display.setText("WTF!!!");
                    display.setTextSize(crazy.nextInt(75));
                    display.setTextColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255), crazy.nextInt(255)));
                    switch(crazy.nextInt(3)){
                        case 1:{
                            break;
                        }
                        case 2:{

                            break;
                        }
                        case 3:{

                            break;
                        }
                    }
                }
                break;
            }
            case R.id.tbPassword:{
                if(passToggle.isChecked()){
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else{
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }


                break;
            }


        }
    }
}
