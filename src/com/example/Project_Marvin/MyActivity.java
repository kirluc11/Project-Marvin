package com.example.Project_Marvin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import selector.QuestionSelector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class MyActivity extends Activity implements View.OnClickListener
{
    /**
     * Called when the activity is first created.
     */

    private QuestionSelector questionSelector;

    private Button deu;
    private Button eng;
    private Button credits;
    private Button info;
    private Button start;

    //Dere du Sack
    //Hiiiiiiiiii
    //Sveen
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        try {
            questionSelector = new QuestionSelector();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

        setContentView(R.layout.main);
        deu=(Button) findViewById(R.id.deu);
        eng=(Button) findViewById(R.id.eng);
        credits =(Button) findViewById(R.id.credits);
        credits.setOnClickListener(this);
        info=(Button) findViewById(R.id.info);
        info.setOnClickListener(this);
        start=(Button) findViewById(R.id.start);
    }


    @Override
    public void onClick(View v)
    {
        final Intent i= getIntent();
        final Intent nextIntent=new Intent(this, MyActivity.class);
        startActivity(nextIntent);
    }
}
