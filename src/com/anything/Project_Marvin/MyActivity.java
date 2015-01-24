package com.anything.Project_Marvin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.*;
import android.widget.*;
import beans.Language;
import beans.Question;
import selector.QuestionHandler;

public class MyActivity extends Activity implements View.OnClickListener
{
    /**
     * Called when the activity is first created.
     */

    private Button credits;
    private Button info;
    private Button start;
    private TextView creditsScreenTV;
    private TextView info1;
    private TextView info2;
    private TextView info3;
    private TextView tv1;
    private TextView tv2;
    private TextView tvOnStartScreen;
    //every thingy where the text can be changed to another language needs to be put here,
    //because it's used in the changeLanguage() method!

    private int screennumber=0;

    private Language language;

    private static QuestionHandler qh;

    private int screenWidth;
    private int screenHeight;
    private int thirdScreenWidth;
    private int fifthScreenHeight;
    private int halfScreenWidth;
    private int quarterScreenWidth;
    private int eigthScreenHeight;
    private int thirteenthScreenHeight;
    private int thirdScreenHeight;
    private int fifthScreenWidth;

    private int padding = 0;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        calculateScreenSizes();

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        language = Language.getInstance();

        screennumber = getIntent().getIntExtra("screenNumber",0);
        if(screennumber==0)this.thingsConcerningStartScreen();
        else if(screennumber==1)this.thingsConcerningPlayScreen(true);
        else if(screennumber==2)this.thingsConcerningInfoScreen();
        else if(screennumber==3)this.thingsConcerningCreditsScreen();
        else this.thingsConcerningEndScreen();

        changeLanguage(screennumber);
    }


    public void calculateScreenSizes()
    {


        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        /**Define Screen height here*/
        fifthScreenHeight = (int) (screenHeight/5)-padding;
        eigthScreenHeight = (int)(screenHeight/8)-padding;
        thirdScreenHeight = (screenHeight/3)-padding;
        thirteenthScreenHeight = (int)(screenHeight/13)-padding;

        /**Define Screen Width here*/
        thirdScreenWidth = (int) (screenWidth/3)-padding;
        halfScreenWidth = (int)(screenWidth *0.5)-padding;
        quarterScreenWidth = (int)(halfScreenWidth * 0.5)-padding;
        fifthScreenWidth = (screenWidth/5)-padding;
    }

    public void PlayScreen()
    {
        ViewGroup layout = (ViewGroup)findViewById(R.id.playScreenLayout);
        GridLayout.Spec row0 = GridLayout.spec(0);
        GridLayout.Spec row1 = GridLayout.spec(1);
        GridLayout.Spec row2 = GridLayout.spec(2);
        GridLayout.Spec row3 = GridLayout.spec(3);
        GridLayout.Spec row4 = GridLayout.spec(4);

        GridLayout.Spec col0 = GridLayout.spec(0);
        GridLayout.Spec col1 = GridLayout.spec(1);
        GridLayout.Spec col2 = GridLayout.spec(2);
        GridLayout.Spec colspan1 = GridLayout.spec(0,2);
        GridLayout.Spec colspan2 = GridLayout.spec(0, 3);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(5);


        gridLayout.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));

        ImageView ivLogo = (ImageView)layout.findViewById(R.id.ivLogo);
        GridLayout.LayoutParams zero = new GridLayout.LayoutParams(row0,colspan1);
        zero.width = (screenWidth/3)*2;
        zero.height = fifthScreenHeight;
        ivLogo.setLayoutParams(zero);
        ivLogo.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        layout.removeView(ivLogo);
        gridLayout.addView(ivLogo, zero);

        Button btInfo = (Button) layout.findViewById(R.id.btInfo);
        btInfo.setOnClickListener(this);
        GridLayout.LayoutParams first = new GridLayout.LayoutParams(row0,col2);
        first.width = thirdScreenWidth;
        first.height = fifthScreenHeight;
        btInfo.setGravity(Gravity.CENTER);
        btInfo.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        btInfo.setText("Info");
        btInfo.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        btInfo.setTag("2");
        btInfo.setTextColor(getResources().getColor(R.color.green));
        btInfo.setBackground(getResources().getDrawable(R.drawable.button_border));
        btInfo.setLayoutParams(first);
        layout.removeView(btInfo);
        gridLayout.addView(btInfo, first);

        TextView btQuestion = (TextView) layout.findViewById(R.id.btQuestion);
        GridLayout.LayoutParams second = new GridLayout.LayoutParams(row1,colspan2);
        second.width = screenWidth;
        second.height = fifthScreenHeight;
        btQuestion.setLayoutParams(second);
        btQuestion.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getInteger(R.integer.button));
        btQuestion.setGravity(Gravity.CENTER);
        btQuestion.setTextColor(getResources().getColor(R.color.green));
        btQuestion.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        btQuestion.setText("TOP");
        layout.removeView(btQuestion);
        gridLayout.addView(btQuestion, second);

        Button btAnswer1 = (Button) layout.findViewById(R.id.btAnswer1);
        btAnswer1.setOnClickListener(this);
        GridLayout.LayoutParams third = new GridLayout.LayoutParams(row2,col0);
        third.width = thirdScreenWidth;
        third.height = fifthScreenHeight;
        btAnswer1.setLayoutParams(third);
        btAnswer1.setGravity(Gravity.CENTER);
        btAnswer1.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        btAnswer1.setText("Gerhard Gugerbauer Idiot sasdasdasdadasdasdadsafsadf");
        btAnswer1.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        btAnswer1.setTag("101");
        btAnswer1.setTextColor(getResources().getColor(R.color.green));
        btAnswer1.setBackground(getResources().getDrawable(R.drawable.answer_border));
        layout.removeView(btAnswer1);
        gridLayout.addView(btAnswer1, third);

        Button btAnswer2 = (Button) layout.findViewById(R.id.btAnswer2);
        btAnswer2.setOnClickListener(this);
        GridLayout.LayoutParams fourth = new GridLayout.LayoutParams(row2,col2);
        fourth.width = thirdScreenWidth;
        fourth.height = fifthScreenHeight;
        btAnswer2.setLayoutParams(fourth);
        btAnswer2.setGravity(Gravity.CENTER);
        btAnswer2.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        btAnswer2.setText("Gerhard Gugerbauer Idiot sasdasdasdadasdasdadsafsadf");
        btAnswer2.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        btAnswer2.setTag("102");
        btAnswer2.setTextColor(getResources().getColor(R.color.green));
        btAnswer2.setBackground(getResources().getDrawable(R.drawable.answer_border));
        layout.removeView(btAnswer2);
        gridLayout.addView(btAnswer2, fourth);

        Button btAnswer3 = (Button) layout.findViewById(R.id.btAnswer3);
        btAnswer3.setOnClickListener(this);
        GridLayout.LayoutParams fifth = new GridLayout.LayoutParams(row3,col1);
        fifth.width = thirdScreenWidth;
        fifth.height = fifthScreenHeight;
        btAnswer3.setLayoutParams(fifth);
        btAnswer3.setGravity(Gravity.CENTER);
        btAnswer3.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        btAnswer3.setText("Gerhard Gugerbauer Idiot sasdasdasdadasdasdadsafsadf");
        btAnswer3.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        btAnswer3.setTag("103");
        btAnswer3.setTextColor(getResources().getColor(R.color.green));
        btAnswer3.setBackground(getResources().getDrawable(R.drawable.answer_border));
        layout.removeView(btAnswer3);
        gridLayout.addView(btAnswer3, fifth);

        Button btAnswer4 = (Button) layout.findViewById(R.id.btAnswer4);
        btAnswer4.setOnClickListener(this);
        GridLayout.LayoutParams sixth = new GridLayout.LayoutParams(row4,col0);
        sixth.width = thirdScreenWidth;
        sixth.height = fifthScreenHeight;
        btAnswer4.setLayoutParams(sixth);
        btAnswer4.setGravity(Gravity.CENTER);
        btAnswer4.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        btAnswer4.setText("Gerhard Gugerbauer Idiot sasdasdasdadasdasdadsafsadf");
        btAnswer4.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        btAnswer4.setTag("104");
        btAnswer4.setTextColor(getResources().getColor(R.color.green));
        btAnswer4.setBackground(getResources().getDrawable(R.drawable.answer_border));
        layout.removeView(btAnswer4);
        gridLayout.addView(btAnswer4, sixth);

        Button btAnswer5 = (Button) layout.findViewById(R.id.btAnswer5);
        btAnswer5.setOnClickListener(this);
        GridLayout.LayoutParams seventh = new GridLayout.LayoutParams(row4,col2);
        seventh.width = thirdScreenWidth;
        seventh.height = fifthScreenHeight;
        btAnswer5.setLayoutParams(seventh);
        btAnswer5.setGravity(Gravity.CENTER);
        btAnswer5.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        btAnswer5.setText("Gerhard Gugerbauer Idiot sasdasdasdadasdasdadsafsadf");
        btAnswer5.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        btAnswer5.setTag("105");
        btAnswer5.setTextColor(getResources().getColor(R.color.green));
        btAnswer5.setBackground(getResources().getDrawable(R.drawable.answer_border));
        layout.removeView(btAnswer5);
        gridLayout.addView(btAnswer5, seventh);

        //gridLayout.setUseDefaultMargins(true);

        layout.addView(gridLayout);
    }

    public void InfoScreen()
    {
        ViewGroup layout = (ViewGroup)findViewById(R.id.InfoLayout);
        GridLayout.Spec row0 = GridLayout.spec(0);
        GridLayout.Spec row1 = GridLayout.spec(1);
        GridLayout.Spec row2 = GridLayout.spec(2);
        GridLayout.Spec row3 = GridLayout.spec(3);
        GridLayout.Spec row4 = GridLayout.spec(4);
        GridLayout.Spec rowspan0 = GridLayout.spec(1,4);
        GridLayout.Spec rowspan1 = GridLayout.spec(1,3);

        GridLayout.Spec col0 = GridLayout.spec(0);
        GridLayout.Spec col1 = GridLayout.spec(1);
        GridLayout.Spec colspan = GridLayout.spec(0,2);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(2);
        gridLayout.setRowCount(5);

        ImageView ivInfoMarvin = (ImageView) layout.findViewById(R.id.ivInfoMarvin);
        GridLayout.LayoutParams first = new GridLayout.LayoutParams(rowspan0,col0);
        first.width = halfScreenWidth;
        first.height = fifthScreenHeight*4;
        ivInfoMarvin.setLayoutParams(first);
        layout.removeView(ivInfoMarvin);
        gridLayout.addView(ivInfoMarvin, first);

        TextView tvInfo1 = (TextView) layout.findViewById(R.id.tvInfo1);
        GridLayout.LayoutParams second = new GridLayout.LayoutParams(row0,colspan);
        second.width = screenWidth;
        second.height = fifthScreenHeight;
        tvInfo1.setLayoutParams(second);
        tvInfo1.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.headings));
        tvInfo1.setGravity(Gravity.CENTER);
        tvInfo1.setText("TOP");
        tvInfo1.setTextColor(getResources().getColor(R.color.green));
        layout.removeView(tvInfo1);
        gridLayout.addView(tvInfo1, second);

        TextView tvInfo2 = (TextView) layout.findViewById(R.id.tvInfo2);
        GridLayout.LayoutParams third = new GridLayout.LayoutParams(rowspan1,col1);
        third.width = halfScreenWidth;
        third.height = fifthScreenHeight*3;
        tvInfo2.setLayoutParams(third);
        tvInfo2.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.textView));
        tvInfo2.setGravity(Gravity.CENTER);
        tvInfo2.setText("Gerhard Gugerbauer Idiot");
        tvInfo2.setTextColor(getResources().getColor(R.color.green));
        tvInfo2.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.textView));
        layout.removeView(tvInfo2);
        gridLayout.addView(tvInfo2, third);

        TextView tvInfo3 = (TextView) layout.findViewById(R.id.tvInfo3);
        GridLayout.LayoutParams fourth = new GridLayout.LayoutParams(row4,col1);
        fourth.width = halfScreenWidth;
        fourth.height = fifthScreenHeight;
        tvInfo3.setLayoutParams(fourth);
        tvInfo3.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.textView));
        tvInfo3.setGravity(Gravity.CENTER);
        tvInfo3.setTextColor(getResources().getColor(R.color.green));
        tvInfo3.setText("TOP");
        layout.removeView(tvInfo3);
        gridLayout.addView(tvInfo3, fourth);

        gridLayout.setBackgroundColor(getResources().getColor(R.color.hellviolett));

        layout.addView(gridLayout);
    }
    public void CreditsScreen()
    {
        ViewGroup layout = (ViewGroup)findViewById(R.id.CreditsScreenLayout);
        GridLayout.Spec row0 = GridLayout.spec(0);
        GridLayout.Spec row1 = GridLayout.spec(1);
        GridLayout.Spec row2 = GridLayout.spec(2);
        GridLayout.Spec row3 = GridLayout.spec(3);
        GridLayout.Spec row4 = GridLayout.spec(4);
        GridLayout.Spec row5 = GridLayout.spec(5);
        GridLayout.Spec row6 = GridLayout.spec(6);
        GridLayout.Spec row7 = GridLayout.spec(7);
        GridLayout.Spec row8 = GridLayout.spec(8);
        GridLayout.Spec rowspan0 = GridLayout.spec(0,3);
        GridLayout.Spec rowspan1 = GridLayout.spec(3,5);

        GridLayout.Spec col0 = GridLayout.spec(0);
        GridLayout.Spec col1 = GridLayout.spec(1);
        GridLayout.Spec col2 = GridLayout.spec(2);
        GridLayout.Spec colspan = GridLayout.spec(0,3);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(9);



       TextView tvCreditsText = (TextView) layout.findViewById(R.id.tvCreditsText);
        GridLayout.LayoutParams first = new GridLayout.LayoutParams(rowspan0,colspan);
        first.width = screenWidth;
        first.height = eigthScreenHeight *3;
        tvCreditsText.setLayoutParams(first);
        tvCreditsText.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.headings));
        tvCreditsText.setGravity(Gravity.CENTER);
        tvCreditsText.setText("11111111111111");
        tvCreditsText.setTextColor(getResources().getColor(R.color.green));
        layout.removeView(tvCreditsText);
        gridLayout.addView(tvCreditsText, first);

        ImageView ivCreditsPicture = (ImageView) layout.findViewById(R.id.ivCreditsPicture);
        GridLayout.LayoutParams second = new GridLayout.LayoutParams(rowspan1,colspan);
        second.width = screenWidth;
        second.height = eigthScreenHeight *5;
        ivCreditsPicture.setLayoutParams(second);
        layout.removeView(ivCreditsPicture);
        gridLayout.addView(ivCreditsPicture, second);

        gridLayout.setBackgroundColor(getResources().getColor(R.color.hellviolett));

        layout.addView(gridLayout);
    }

    public void StartScreen()
    {
        ViewGroup layout = (ViewGroup)findViewById(R.id.MainScreenLayout);

        GridLayout.Spec row0 = GridLayout.spec(0);
        GridLayout.Spec row1 = GridLayout.spec(1);
        GridLayout.Spec row2 = GridLayout.spec(2);
        GridLayout.Spec row3 = GridLayout.spec(3);
        GridLayout.Spec row4 = GridLayout.spec(4);
        GridLayout.Spec row5 = GridLayout.spec(5);
        GridLayout.Spec row6 = GridLayout.spec(6);
        GridLayout.Spec row7 = GridLayout.spec(7);
        GridLayout.Spec row8 = GridLayout.spec(8);
        GridLayout.Spec row9 = GridLayout.spec(9);
        GridLayout.Spec row10 = GridLayout.spec(10);
        GridLayout.Spec row11 = GridLayout.spec(11);
        GridLayout.Spec row12 = GridLayout.spec(12);

        GridLayout.Spec rowspan0 = GridLayout.spec(0,6);
        GridLayout.Spec rowspan1 = GridLayout.spec(6,3);
        GridLayout.Spec rowspan2 = GridLayout.spec(10,3);
        GridLayout.Spec rowspan3 = GridLayout.spec(0,13);


        GridLayout.Spec col0 = GridLayout.spec(0);
        GridLayout.Spec col1 = GridLayout.spec(1);
        GridLayout.Spec col2 = GridLayout.spec(2);
        GridLayout.Spec col3 = GridLayout.spec(3);
        GridLayout.Spec col4 = GridLayout.spec(4);
        GridLayout.Spec colspan = GridLayout.spec(0,2);
        GridLayout.Spec colspan1 = GridLayout.spec(3,1);
        GridLayout.Spec colspan2 = GridLayout.spec(3,2);
        GridLayout.Spec colspan3 = GridLayout.spec(2,3);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(5);
        gridLayout.setRowCount(13);
        gridLayout.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));


        ImageView ivMainMarvin = (ImageView) layout.findViewById(R.id.ivMainMarvin);
        GridLayout.LayoutParams first = new GridLayout.LayoutParams(rowspan0,colspan);
        first.width = fifthScreenWidth*2;
        first.height = thirteenthScreenHeight *6;
        ivMainMarvin.setLayoutParams(first);
        layout.removeView(ivMainMarvin);
        gridLayout.addView(ivMainMarvin, first);

        Button start = (Button) layout.findViewById(R.id.start);
        GridLayout.LayoutParams second = new GridLayout.LayoutParams(row6,colspan2);
        start.setOnClickListener(this);
        second.width = fifthScreenWidth*2;
        second.height = thirteenthScreenHeight;
        start.setLayoutParams(second);
        start.setGravity(Gravity.CENTER);
        start.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        start.setText("Start");
        start.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        start.setTextColor(getResources().getColor(R.color.green));
        start.setTag("1");
        start.setBackground(getResources().getDrawable(R.drawable.button_border));
        layout.removeView(start);
        gridLayout.addView(start, second);

        Button info = (Button) layout.findViewById(R.id.info);
        info.setOnClickListener(this);
        GridLayout.LayoutParams third = new GridLayout.LayoutParams(row8,colspan2);
        third.width = fifthScreenWidth*2;
        third.height = thirteenthScreenHeight;
        info.setLayoutParams(third);
        info.setGravity(Gravity.CENTER);
        info.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        info.setText("Info");
        info.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        info.setTag("2");
        info.setTextColor(getResources().getColor(R.color.green));
        info.setBackground(getResources().getDrawable(R.drawable.button_border));
        layout.removeView(info);
        gridLayout.addView(info, third);

        Button credits = (Button) layout.findViewById(R.id.credits);
        credits.setOnClickListener(this);
        GridLayout.LayoutParams fourth = new GridLayout.LayoutParams(row10,colspan2);
        fourth.width = fifthScreenWidth*2;
        fourth.height = thirteenthScreenHeight;
        credits.setLayoutParams(fourth);
        credits.setGravity(Gravity.CENTER);
        credits.setBackgroundColor(this.getResources().getColor(R.color.hellviolett));
        credits.setText("Credits");
        credits.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.button));
        credits.setBackground(getResources().getDrawable(R.drawable.button_border));
        credits.setTextColor(getResources().getColor(R.color.green));
        credits.setTag("3");
        layout.removeView(credits);
        gridLayout.addView(credits, fourth);

        Button deu = (Button) layout.findViewById(R.id.deu);
        deu.setOnClickListener(this);
        GridLayout.LayoutParams fifth = new GridLayout.LayoutParams(rowspan1,colspan);
        fifth.width = fifthScreenWidth*2;
        fifth.height = thirteenthScreenHeight *3;
        deu.setLayoutParams(fifth);
        deu.setGravity(Gravity.CENTER);
        deu.setBackgroundColor(Color.RED);
        deu.setTag("4");
        deu.setBackgroundResource(R.drawable.oesterreich);
        //deu.setBackground();

        layout.removeView(deu);
        gridLayout.addView(deu, fifth);

        Button eng = (Button) layout.findViewById(R.id.eng);
        eng.setOnClickListener(this);
        GridLayout.LayoutParams sixth = new GridLayout.LayoutParams(rowspan2,colspan);
        sixth.width = fifthScreenWidth*2;
        sixth.height = thirteenthScreenHeight *3;
        eng.setLayoutParams(second);
        eng.setGravity(Gravity.CENTER);
        eng.setTag("5");
        eng.setBackgroundResource(R.drawable.engusa);
        layout.removeView(eng);
        gridLayout.addView(eng, sixth);

        Space spColumnPlaceholder = (Space) layout.findViewById(R.id.spMainColumnPlaceholder);
        GridLayout.LayoutParams seventh = new GridLayout.LayoutParams(rowspan3,col2);
        seventh.width = fifthScreenWidth;
        seventh.height = screenHeight;
        spColumnPlaceholder.setLayoutParams(seventh);
        layout.removeView(spColumnPlaceholder);
        gridLayout.addView(spColumnPlaceholder, seventh);

        TextView tvMainText = (TextView)layout.findViewById(R.id.tvStartText);
        GridLayout.LayoutParams eighth = new GridLayout.LayoutParams(rowspan0,colspan3);
        eighth.width = fifthScreenWidth*3;
        eighth.height = thirteenthScreenHeight *6;
        tvMainText.setLayoutParams(eighth);
        tvMainText.setText("dsfsdfsdfsdfsfsdfsdf");
        tvMainText.setTextColor(getResources().getColor(R.color.green));
        tvMainText.setTextSize(getResources().getInteger(R.integer.headings));
        tvMainText.setGravity(Gravity.CENTER);
        layout.removeView(tvMainText);
        gridLayout.addView(tvMainText,eighth);

        //gridLayout.setBackground(getResources().getDrawable(R.drawable.layout_border));
        //gridLayout.setUseDefaultMargins(true);

        layout.addView(gridLayout);
    }
    private void EndScreen()
    {
        ViewGroup layout = (ViewGroup)findViewById(R.id.EndScreenLayout);
        GridLayout.Spec row0 = GridLayout.spec(0);
        GridLayout.Spec row1 = GridLayout.spec(1);
        GridLayout.Spec row2 = GridLayout.spec(2);
        GridLayout.Spec row3 = GridLayout.spec(3);
        GridLayout.Spec row4 = GridLayout.spec(4);
        GridLayout.Spec row5 = GridLayout.spec(5);
        GridLayout.Spec row6 = GridLayout.spec(6);
        GridLayout.Spec row7 = GridLayout.spec(7);
        GridLayout.Spec row8 = GridLayout.spec(8);
        GridLayout.Spec row9 = GridLayout.spec(9);
        GridLayout.Spec row10 = GridLayout.spec(10);
        GridLayout.Spec row11 = GridLayout.spec(11);
        GridLayout.Spec row12 = GridLayout.spec(12);

        GridLayout.Spec rowspan0 = GridLayout.spec(0,3);
        GridLayout.Spec rowspan1 = GridLayout.spec(3,3);
        GridLayout.Spec rowspan3 = GridLayout.spec(6,6);

        GridLayout.Spec col0 = GridLayout.spec(0);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);
        gridLayout.setRowCount(13);

        gridLayout.setBackgroundColor(getResources().getColor(R.color.hellviolett));

        TextView tvEndHeader = (TextView) layout.findViewById(R.id.tvEndHeader);
        GridLayout.LayoutParams second = new GridLayout.LayoutParams(rowspan0,col0);
        second.width = screenWidth;
        second.height = thirteenthScreenHeight *3;
        tvEndHeader.setLayoutParams(second);
        tvEndHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.headings));
        tvEndHeader.setGravity(Gravity.CENTER);
        tvEndHeader.setText("Header");
        tvEndHeader.setTextColor(getResources().getColor(R.color.green));
        layout.removeView(tvEndHeader);
        gridLayout.addView(tvEndHeader, second);

        TextView tvEndSubtitle = (TextView) layout.findViewById(R.id.tvEndSubtitle);
        GridLayout.LayoutParams third = new GridLayout.LayoutParams(rowspan1,col0);
        third.width = screenWidth;
        third.height = thirteenthScreenHeight *3;
        tvEndSubtitle.setLayoutParams(third);
        tvEndSubtitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getInteger(R.integer.textView));
        tvEndSubtitle.setGravity(Gravity.CENTER);
        tvEndSubtitle.setText("Sub");
        tvEndSubtitle.setTextColor(getResources().getColor(R.color.green));
        layout.removeView(tvEndSubtitle);
        gridLayout.addView(tvEndSubtitle, third);

        ImageView ivEndPicture = (ImageView) layout.findViewById(R.id.ivEndPicture);
        GridLayout.LayoutParams fourth = new GridLayout.LayoutParams(rowspan3,col0);
        fourth.width = screenWidth;
        fourth.height = thirteenthScreenHeight *7;
        ivEndPicture.setLayoutParams(fourth);
        layout.removeView(ivEndPicture);
        gridLayout.addView(ivEndPicture, fourth);
        layout.addView(gridLayout);
    }


    public void thingsConcerningPlayScreen(boolean neu)
    {
        //get access to assets folder: getBaseContext().getApplicationContext().getAssets()

        if(neu)
        {
            setContentView(R.layout.general_playscreen);
            PlayScreen();
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

        TextView tv = (TextView) findViewById(R.id.btQuestion);

        try
        {
            if(qh == null)
            {
                System.out.println("qh = null in things....");
                qh = new QuestionHandler(getBaseContext().getApplicationContext().getAssets());
            }

            Question q = qh.getNextQuestion();

            if(q == null)
            {
                finish();
                goToNextScreen(6);
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

        } catch (Exception e) {}
    }
    public void thingsConcerningInfoScreen()
    {
        setContentView(R.layout.info_screen);
        InfoScreen();

        info1= (TextView) findViewById(R.id.tvInfo1);
        info2= (TextView) findViewById(R.id.tvInfo2);
        info3= (TextView) findViewById(R.id.tvInfo3);
    }
    public void thingsConcerningCreditsScreen()
    {
        setContentView(R.layout.credits_screen);
        CreditsScreen();

        creditsScreenTV = (TextView) findViewById(R.id.tvCreditsText);

        //To close an intent after a specified time (first parameter in milliseconds, do not modify the second).
        /*new CountDownTimer(10000, 100)
        {
            public void onTick(long millisUntilFinished)
            {
                if(millisUntilFinished<=1000)
                {
                    creditsScreenTV.setText((millisUntilFinished/1000+1)+language.getActualLanguage()[8]);
                }
                else
                {
                    creditsScreenTV.setText((millisUntilFinished/1000+1)+language.getActualLanguage()[7]);
                }
            }
            public void onFinish(){cancel();finish();}
        }.start();*/
    }
    public void thingsConcerningStartScreen()
    {
        setContentView(R.layout.main);
        StartScreen();

        //we need these because the language can be changed.
        credits =(Button) findViewById(R.id.credits);
        credits.setOnClickListener(this);
        info=(Button) findViewById(R.id.info);
        info.setOnClickListener(this);
        start=(Button) findViewById(R.id.start);
        start.setOnClickListener(this);
        tvOnStartScreen=(TextView) findViewById(R.id.tvStartText);
    }
    public void thingsConcerningEndScreen()
    {
        setContentView(R.layout.end_screen);
        EndScreen();
        tv1 = (TextView) findViewById(R.id.tvEndHeader);
        tv2 = (TextView) findViewById(R.id.tvEndSubtitle);
    }

    int getScreenNumber()
    {
        return getIntent().getIntExtra("screenNumber",0);
    }

    void goToNextScreen (int whichButton)
    {
        /*  These are the screen numbers for the intents corresponding with the pressed buttons:
            whichButton = 1 -> Start (General playscreen)
            whichButton = 2 -> Info
            whichButton = 3 -> Credits
            whichButton = 6-> Endscreen*/

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
        else
        {
            nextIntent.putExtra("screenNumber",6);
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
        changeLanguage(0);
    }

    public void changeLanguage(int screennumber)
    {
        //Place the "variablenname.setText(language.getActualLanguage()[x])" things here.

        if(screennumber==0) //start-screen
        {
            start.setText(language.getActualLanguage()[0]);
            info.setText(language.getActualLanguage()[1]);
            credits.setText(language.getActualLanguage()[2]);
            tvOnStartScreen.setText(language.getActualLanguage()[12]);
        }
        else if(screennumber==3)   //credits-screen
        {
            creditsScreenTV.setText(language.getActualLanguage()[3]);
        }
        else if(screennumber==2) //info-screen
        {
            info1.setText(language.getActualLanguage()[4]);
            info2.setText(language.getActualLanguage()[5]);
            info3.setText(language.getActualLanguage()[6]);
        }
        else if(screennumber==6) //end-screen
        {
            tv1.setText(language.getActualLanguage()[9]);  //we don't need 7 and 8
            tv2.setText(language.getActualLanguage()[10]+qh.getRight()+ language.getActualLanguage()[11]);
            qh = null;
        }
    }

    public void onClick(View v)
    {
        Button button=(Button) v;
        int whichButton = Integer.parseInt(button.getTag().toString());

        //Buttons 1-3:     menu things in main.xml
        //Buttons 4+5:     language buttons in main.xml
        //Buttons 101-105: Answer-Buttons in general-playscreen.xml, but the tag is not used.
        //Button  6:       Endscreen


        //to go to a website when a button is clicked:
        /*
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.google.com"));
        startActivity(intent);*/

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
            if(button != null)
            {
                if(qh != null) {
                    qh.checkAnswer((String) button.getText());
                    thingsConcerningPlayScreen(false);
                }
            }
        }
    }
}
