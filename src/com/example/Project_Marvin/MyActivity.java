package com.example.Project_Marvin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import beans.Question;
import selector.QuestionLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class MyActivity extends Activity implements View.OnClickListener
{
    /**
     * Called when the activity is first created.
     */

    private QuestionLoader questionLoader;

    private Button deu;
    private Button eng;
    private Button credits;
    private Button info;
    private Button start;
    private Boolean languageIsEng=true;

    private String[] langGER={"Startger", "Infoger","Creditsger"};
    private String[] langENG={"Starteng", "Infoeng","Creditseng"};
    private String[] actualLANG=langENG;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        int screennumber = getIntent().getIntExtra("screenNumber",0);
        if(screennumber==0)this.thingsConcerningStartScreen();
        else if(screennumber==1)this.thingsConcerningPlayScreen();
        else if(screennumber==2)this.thingsConcerningInfoScreen();
        else this.thingsConcerningCreditsScreen();


    }


    public void thingsConcerningPlayScreen()
    {
        //Place attributes and everything else concerning the PlayScreen only here!




        setContentView(R.layout.general_playscreen);

        TextView tv = (TextView) findViewById(R.id.bla);

        try {
            QuestionLoader ql = QuestionLoader.getInstance(getBaseContext().getApplicationContext().getAssets());
            LinkedHashMap<String, LinkedList<Question>> questions = ql.getQuestions();
            LinkedList<String> keys = ql.getKeys();
            tv.setText(questions.get("FUN").getFirst().getGerQuestion());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void thingsConcerningInfoScreen()
    {
        //Place attributes and everything else concerning the InfoScreen only here!

        setContentView(R.layout.info_screen);
    }

    public void thingsConcerningCreditsScreen()
    {
        //Place attributes and everything else concerning the CreditsScreen only here!

        setContentView(R.layout.credits_screen);
    }

    public void thingsConcerningStartScreen()
    {
        //Place attributes and everything else concerning the StartScreen only here!

        setContentView(R.layout.main);
        deu=(Button) findViewById(R.id.deu);
        deu.setOnClickListener(this);
        eng=(Button) findViewById(R.id.eng);
        eng.setOnClickListener(this);
        credits =(Button) findViewById(R.id.credits);
        credits.setOnClickListener(this);
        info=(Button) findViewById(R.id.info);
        info.setOnClickListener(this);
        start=(Button) findViewById(R.id.start);
        start.setOnClickListener(this);

        changeLanguage();
    }

    int getScreenNumber()
    {
        return getIntent().getIntExtra("screenNumber",0);
    }

    void goToNextScreen (int whichButton)
    {
        int screenNumber = getScreenNumber();

        /*  These are the screen numbers for the intents corresponding with the pressed buttons:
            whichButton = 1 -> Start (General playscreen)
            whichButton = 2 -> Info
            whichButton = 3 -> Credits */

        final Intent nextIntent=new Intent(this, MyActivity.class);
        if(whichButton==1)
        {
            nextIntent.putExtra("screenNumber",1);
        }
        else if(whichButton==2)
        {
            nextIntent.putExtra("screenNumber",2);
        }
        else
        {
            nextIntent.putExtra("screenNumber",3);
        }

        startActivity(nextIntent);

        /*
        Attention: startActivity calls the onCreate method if it contains a main.xml, this will be rendered.
        Add code in onCreate to modify the main.xml if desired.
         */
    }

    public void identifyLanguage(int whichButton)
    {
        if(whichButton==4)
        {
            languageIsEng=false;
            actualLANG=langGER;
        }
        else
        {
            languageIsEng=true;
            actualLANG=langENG;
        }
        changeLanguage();
    }

    public void changeLanguage()
    {
        //Place the whole "setText(actualLANG[])" things here.

        start.setText(actualLANG[0]);
        info.setText(actualLANG[1]);
        credits.setText(actualLANG[2]);
    }

    public void onClick(View v)
    {
        Button button=(Button) v;
        int whichButton = Integer.parseInt(button.getTag().toString());

        //Buttons 1-3 are menu things, 4+5 are the language buttons (defined in main.xml).
        if(whichButton<=3)
        {
            goToNextScreen(whichButton);
        }
        else
        {
            identifyLanguage(whichButton);
        }
    }
}
