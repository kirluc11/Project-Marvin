package com.example.Project_Marvin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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
    private Button answerB1;
    private Button answerB2;
    private Button answerB3;
    private Button answerB4;
    private Button answerB5;
    private Button infoB;

    private Language language;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        language = Language.getInstance();



        int screennumber = getIntent().getIntExtra("screenNumber",0);
        if(screennumber==0)this.thingsConcerningStartScreen();
        else if(screennumber==1)this.thingsConcerningPlayScreen(true);
        else if(screennumber==2 || screennumber==6)this.thingsConcerningInfoScreen();
        else if(screennumber==3)this.thingsConcerningCreditsScreen();
        else this.thingsConcerningEndScreen();

    }


    public void thingsConcerningPlayScreen(boolean neu)
    {
        //Place attributes and everything else concerning the PlayScreen only here!
        //get access to assets folder: getBaseContext().getApplicationContext().getAssets()

        if(neu){
            setContentView(R.layout.general_playscreen);
        }

        Button b1=(Button) findViewById(R.id.btAnswer1);
        b1.setOnClickListener(this);
        Button b2=(Button) findViewById(R.id.btAnswer2);
        b2.setOnClickListener(this);
        Button b3=(Button) findViewById(R.id.btAnswer3);
        b3.setOnClickListener(this);
        Button b4=(Button) findViewById(R.id.btAnswer4);
        b4.setOnClickListener(this);
        Button b5=(Button) findViewById(R.id.btAnswer5);
        b5.setOnClickListener(this);

        Button infoButton=(Button) findViewById(R.id.btInfo);
        infoButton.setOnClickListener(this);

        TextView tv = (TextView) findViewById(R.id.Question);

        try {
            QuestionHandler qh = QuestionHandler.getInstance(getBaseContext().getApplicationContext().getAssets());

            Question q = qh.getNextQuestion();

            if(q == null)
            {
                //Toast.makeText(this,qh.getRight(),Toast.LENGTH_LONG).show();
                goToNextScreen(2);
            }
            else
            {
                if(Language.getInstance().isEnglish())
                {
                    tv.setText(q.getEngQuestion());
                }
                else
                {
                    tv.setText(q.getGerQuestion());
                }

                b1.setText(qh.getNextAnswer());
                b2.setText(qh.getNextAnswer());
                b3.setText(qh.getNextAnswer());
                b4.setText(qh.getNextAnswer());
                b5.setText(qh.getNextAnswer());
            }

        } catch (Exception e){}
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

    public void thingsConcerningEndScreen()
    {

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
            whichButton = 3 -> Credits
            whichButton = 6 -> Info
            whichButton = 10-> Endscreen*/

        final Intent nextIntent=new Intent(this, MyActivity.class);
        if(whichButton==1)
        {
            nextIntent.putExtra("screenNumber",1);
        }
        else if(whichButton==2)
        {
            nextIntent.putExtra("screenNumber",2);
        }
        else if(whichButton==3)
        {
            nextIntent.putExtra("screenNumber",3);
        }
        else if(whichButton==6)
        {
            nextIntent.putExtra("screenNumber",6);
        }
        else
        {
            nextIntent.putExtra("screenNumber",10);
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

    public void getAnswerButton(int numberOfAnswerButton)
    {
        System.out.println(numberOfAnswerButton+"");
    }

    public void changeLanguage()
    {
        //Place the "setText(actualLANG[x])" things here.

        start.setText(language.getActualLanguage()[0]);
        info.setText(language.getActualLanguage()[1]);
        credits.setText(language.getActualLanguage()[2]);
    }

    public void onClick(View v)
    {
        Button button=(Button) v;
        int whichButton = Integer.parseInt(button.getTag().toString());

        //Buttons 1-3: menu things in main.xml
        //Buttons 4+5: language buttons in main.xml
        //Button 6: Info-Button in general_playscreen.xml
        //Buttons 101-105: Answer-Buttons in general-playscreen.xml


        if(whichButton<=3 || whichButton==6)
        {
            goToNextScreen(whichButton);
        }
        else if(whichButton==4 || whichButton==5)
        {
            identifyLanguage(whichButton);
        }
        else
        {
            QuestionHandler.getInstance().checkAnswer((String) button.getText());
            thingsConcerningPlayScreen(false);
        }
    }
}
