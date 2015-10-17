package com.example.barak.bostontutorials;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Barak on 15/09/2015.
 */
public class OpenedClass extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{
    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread, setData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();

        SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et = getData.getString("name", "bobcat...");
        String values = getData.getString("list", "2");
        if(values.contentEquals("1")){
            question.setText(et);
        }

        //Bundle gotBasket = getIntent().getExtras();
        //gotBread = gotBasket.getString("key");
        //question.setText(gotBread);
    }

    private void initialize(){
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvText);

        returnData = (Button) findViewById(R.id.bReturn);
        selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
        returnData.setOnClickListener(this);
        selectionList.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bReturn){
            Intent person = new Intent();
            Bundle backpack = new Bundle();
            backpack.putString("answer", setData);
            person.putExtras(backpack);
            setResult(RESULT_OK, person);
            finish();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rbDog:
                setData = "Its a dog!";
                break;
            case R.id.rbCat:
                setData = "Its a cat!";


                break;
            case R.id.rbBoth:
                setData = "Its both!";
                break;
        }
        test.setText(setData);
    }


}
