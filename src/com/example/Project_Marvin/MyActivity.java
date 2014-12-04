package com.example.Project_Marvin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import beans.Language;
import beans.Question;
import selector.QuestionHandler;
import selector.QuestionLoader;
import selector.RandomQuestionSelector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MyActivity extends Activity implements View.OnClickListener
{
    /**
     * Called when the activity is first created.
     */

    private Button deu;
    private Button eng;
    private Button credits;
    private Button info;
    private Button start;
    private Language language;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        language = Language.getInstance();

        int screennumber = getIntent().getIntExtra("screenNumber",0);
        if(screennumber==0)this.thingsConcerningStartScreen();
        else if(screennumber==1)this.thingsConcerningPlayScreen();
        else if(screennumber==2)this.thingsConcerningInfoScreen();
        else this.thingsConcerningCreditsScreen();


    }


    public void thingsConcerningPlayScreen()
    {
        //Place attributes and everything else concerning the PlayScreen only here!
        // get access to assets folder: getBaseContext().getApplicationContext().getAssets()

        setContentView(R.layout.general_playscreen);

        TextView tv = (TextView) findViewById(R.id.btAnswer2);

        try {
            QuestionHandler qh = QuestionHandler.getInstance(getBaseContext().getApplicationContext().getAssets());
            if(language.isEnglish())
            {
                tv.setText(qh.getNextQuestion().getEngQuestion() + "\n");
                tv.append(qh.getNextQuestion().getEngRightAnswer() + "\n");
                tv.append(qh.getNextQuestion().getEngWrongAnswers().toString());
            }
            else
            {
                tv.setText(qh.getNextQuestion().getGerQuestion() + "\n");
                tv.append(qh.getNextQuestion().getGerRightAnswer() + "\n");
                tv.append(qh.getNextQuestion().getGerWrongAnswers().toString());
            }
        } catch (Exception e) {
            if(e!=null&&e.getMessage()!=null){}
                //System.out.println(e.getMessage());
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
            language.setEnglish(false);
        }
        else
        {
            language.setEnglish(true);
        }
        changeLanguage();
    }

    public void changeLanguage()
    {
        //Place the whole "setText(actualLANG[x])" things here.

        start.setText(language.getActualLanguage()[0]);
        info.setText(language.getActualLanguage()[1]);
        credits.setText(language.getActualLanguage()[2]);
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
