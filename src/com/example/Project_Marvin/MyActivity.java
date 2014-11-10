package com.example.Project_Marvin;

import android.app.Activity;
import android.content.Intent;
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
        //Attributes and everything else concerning the PlayScreen only here!

        setContentView(R.layout.general_playscreen);



        /*TextView tv = (TextView) findViewById(R.id.bla);
        try {
            QuestionLoader ql = QuestionLoader.getInstance();
            LinkedHashMap<String, LinkedList<Question>> questions = ql.getQuestions();
            LinkedList<String> keys = ql.getKeys();

            for(String key : keys)
            {
                for(Question q : questions.get(key))
                {
                    tv.setText(q.toString() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }

    public void thingsConcerningInfoScreen()
    {
        //Attributes and everything else concerning the InfoScreen only here!

        setContentView(R.layout.info_screen);
    }

    public void thingsConcerningCreditsScreen()
    {
        //Attributes and everything else concerning the CreditsScreen only here!

        setContentView(R.layout.credits_screen);
    }

    public void thingsConcerningStartScreen()
    {
        //Attributes and everything else concerning the StartScreen only here!

        setContentView(R.layout.main);
        deu=(Button) findViewById(R.id.deu);
        eng=(Button) findViewById(R.id.eng);
        credits =(Button) findViewById(R.id.credits);
        credits.setOnClickListener(this);
        info=(Button) findViewById(R.id.info);
        info.setOnClickListener(this);
        start=(Button) findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    int getScreenNumber()
    {
        return getIntent().getIntExtra("screenNumber",0);
    }

    void goToNextScreen (int whichButton)
    {
        int screenNumber = getScreenNumber();

        /*  The screen numbers for the intents corresponding with the pressed buttons:
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

        int x=nextIntent.getIntExtra("screenNumber",0);
        startActivity(nextIntent);

        /*
        Attention: startActivity calls the onCreate method if it contains a main.xml, this will be rendered.
        Add code in onCreate to modify the main.xml if desired.
         */
    }


    public void onClick(View v)
    {
        Button button=(Button) v;
        int whichButton = Integer.parseInt(button.getTag().toString());
        goToNextScreen(whichButton);
    }
}
