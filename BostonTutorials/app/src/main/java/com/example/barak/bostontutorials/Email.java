package com.example.barak.bostontutorials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Barak on 15/09/2015.
 */
public class Email extends Activity implements View.OnClickListener {
    EditText personsEmail, intro, personsName, stupidThings, hatefulAction,
    outro;
    String emailAdd, beginning, name, stupidAction, hatefulAct, out;
    Button sendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeVars();
        sendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String message = intro.getText().toString();
        String[] emailAddress = {personsEmail.getText().toString()};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);

    }

    private void convertTextToStrings() {

    }

    private void initializeVars(){
        personsEmail = (EditText)findViewById(R.id.etEmails);
        intro = (EditText)findViewById(R.id.etIntro);
        personsName= (EditText)findViewById(R.id.etName);
        stupidThings= (EditText)findViewById(R.id.etThings);
        hatefulAction= (EditText)findViewById(R.id.etAction);
        outro = (EditText)findViewById(R.id.etOutro);
        sendEmail=(Button) findViewById(R.id.bSendEmail);
    }
}
