package com.example.Project_Marvin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import selector.QuestionLoader;

import java.io.IOException;

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

        try
        {
            questionLoader = new QuestionLoader();
        }
        catch (IOException e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }


    public void thingsConcerningPlayScreen()
    {
        setContentView(R.layout.general_playscreen);

        //Attributes and stuff only here!
    }

    public void thingsConcerningInfoScreen()
    {
        setContentView(R.layout.info_screen);

        //Attributes and stuff only here!
    }

    public void thingsConcerningCreditsScreen()
    {
        setContentView(R.layout.credits_screen);

        //Attributes and stuff only here!
    }

    public void thingsConcerningStartScreen()
    {
        setContentView(R.layout.main);
        deu=(Button) findViewById(R.id.deu);
        eng=(Button) findViewById(R.id.eng);
        credits =(Button) findViewById(R.id.credits);
        credits.setOnClickListener(this);
        info=(Button) findViewById(R.id.info);
        info.setOnClickListener(this);
        start=(Button) findViewById(R.id.start);
        start.setOnClickListener(this);

        //Attributes and stuff only here!
    }

    int getScreenNumber()
    {
        return getIntent().getIntExtra("screenNumber",0);
    }

    void goToNextScreen (int whichButton)
    {
        int screenNumber = getScreenNumber();

        /*  whichButton = 1 -> Start (General playscreen)
            whichButton = 2 -> Info
            whichButton = 3 -> Credits */

        System.out.println(screenNumber+"");
        System.out.println(whichButton+"");
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

        System.out.printf("goToNextScreen: intExtra=%d\n", screenNumber);
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
