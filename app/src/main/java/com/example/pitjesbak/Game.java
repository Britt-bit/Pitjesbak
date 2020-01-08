package com.example.pitjesbak;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.dmoral.toasty.Toasty;

public class Game extends AppCompatActivity implements View.OnClickListener
{

    String one, two, OwnScore;
    TextView speler1;
    TextView speler2;




    TextView popUp;




    Button soixante_neuf;
    Button apen;
    Button zand;
    Button zeven;

    boolean stop1;
    boolean stop2;
    boolean stop3;

    int value1;
    int value2;
    int value3;

    int value1_sp1;
    int value2_sp1;
    int value3_sp1;

    int value1_sp2;
    int value2_sp2;
    int value3_sp2;

    TextView scorePlayer1, scorePlayer2;

    int score1 = 9, score2 = 9;

    TextView totalScore;
    int totalScorePlayer1 = 0, totalScorePlayer2 = 0;



    ArrayList<Integer> uitkomst1 = new ArrayList<>();
    ArrayList<Integer> uitkomst2 = new ArrayList<>();

    int uitkomst1som = 0;
    int uitkomst2som = 0;


    private Button rollDices;
    int counter = 0;
    int counterStops = 0;
    private ImageView button_0, button_1, button_2;
    TextView hidden1, hidden2, hidden3;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        scorePlayer1 = findViewById(R.id.scorePlayer1);
        scorePlayer2 = findViewById(R.id.scorePlayer2);
        totalScore = findViewById(R.id.totalScore);
        popUp = findViewById(R.id.popUp);

        rulesPop = findViewById(R.id.rulesPop);




        rollDices = findViewById(R.id.rollDices);
            button_0 = (ImageButton) findViewById(R.id.button_0);
            button_0.setOnClickListener(this);
            button_1 = (ImageButton) findViewById(R.id.button_1);
            button_1.setOnClickListener(this);
            button_2 = (ImageButton) findViewById(R.id.button_2);
            button_2.setOnClickListener(this);

            hidden1 =  findViewById(R.id.hidden1);
            hidden2 = findViewById(R.id.hidden2);
            hidden3 = findViewById(R.id.hidden3);
        //array van maken?


        Toast.makeText(getApplicationContext(), "speler 1 is aan de beurt", Toast.LENGTH_SHORT).show();



value1 = 5;
value2 = 4;
value3 = 2;










        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                List<Integer> list = new ArrayList<>();

                list.add(100);
                list.add(2);
                list.add(3);
                list.add(4);
                list.add(5);
                list.add(60);


                //button_0.setVisibility(View.VISIBLE);
                //button_1.setVisibility(View.VISIBLE);
                //button_2.setVisibility(View.VISIBLE);

                //dobbel hulp buttons

                soixante_neuf = findViewById(R.id.soixante_neuf);
                soixante_neuf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        int res1 = getResources().getIdentifier("dice_60", "drawable", "com.example.pitjesbak");
                        int res2 = getResources().getIdentifier("dice_5", "drawable", "com.example.pitjesbak");
                        int res3 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                        button_0.setImageResource(res1);
                        button_1.setImageResource(res2);
                        button_2.setImageResource(res3);
                        value1 = 60;
                        value2 = 5;
                        value3 = 4;
                    }
                });


                apen = findViewById(R.id.apen);
                apen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int res1 = getResources().getIdentifier("dice_100", "drawable", "com.example.pitjesbak");
                        int res2 = getResources().getIdentifier("dice_100", "drawable", "com.example.pitjesbak");
                        int res3 = getResources().getIdentifier("dice_100", "drawable", "com.example.pitjesbak");
                        button_0.setImageResource(res1);
                        button_1.setImageResource(res2);
                        button_2.setImageResource(res3);
                        value1 = 100;
                        value2 = 100;
                        value3 = 100;
                    }
                });


                zand = findViewById(R.id.zand);
                zand.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int res1 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                        int res2 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                        int res3 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                        button_0.setImageResource(res1);
                        button_1.setImageResource(res2);
                        button_2.setImageResource(res3);
                        value1 = 4;
                        value2 = 4;
                        value3 = 4;

                    }
                });


                zeven = findViewById(R.id.zeven);
                zeven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int res1 = getResources().getIdentifier("dice_2", "drawable", "com.example.pitjesbak");
                        int res2 = getResources().getIdentifier("dice_2", "drawable", "com.example.pitjesbak");
                        int res3 = getResources().getIdentifier("dice_3", "drawable", "com.example.pitjesbak");
                        button_0.setImageResource(res1);
                        button_1.setImageResource(res2);
                        button_2.setImageResource(res3);
                        value1 = 2;
                        value2 = 2;
                        value3 = 3;
                    }
                });





                    if (!stop1) {
                        value1 = randomDiceValue(list);
                        int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.example.pitjesbak");
                        button_0.setImageResource(res1);
                    }

                    if (!stop2) {
                        value2 = randomDiceValue(list);
                        int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.example.pitjesbak");
                        button_1.setImageResource(res2);
                    }

                    if (!stop3) {
                        value3 = randomDiceValue(list);
                        int res3 = getResources().getIdentifier("dice_" + value3, "drawable", "com.example.pitjesbak");
                        button_2.setImageResource(res3);
                    }



                counter++;
                counterStops++;

                    if (counter == 3 || counter <= 3 && stop1 && stop2 && stop3){
                        stop1 = false;
                        stop2 = false;
                        stop3 = false;
                        hidden1.setVisibility(View.INVISIBLE);
                        hidden2.setVisibility(View.INVISIBLE);
                        hidden3.setVisibility(View.INVISIBLE);


                        uitkomst1.add(value1);
                        uitkomst1.add(value2);
                        uitkomst1.add(value3);

                        value1_sp1 = value1;
                        value2_sp1 = value2;
                        value3_sp1 = value3;

                        for (int i = 0; i < 3; i++){
                            uitkomst1som += uitkomst1.get(i);
                        }

                        //button_0.setVisibility(View.INVISIBLE);
                        //button_1.setVisibility(View.INVISIBLE);
                        //button_2.setVisibility(View.INVISIBLE);

                        counter = 3;

                       Toast.makeText(getApplicationContext(), "punten " + uitkomst1som, Toast.LENGTH_SHORT).show();
                        speler1.setTextColor(Color.BLACK);
                        speler2.setTextColor(Color.BLUE);

                    } else if (counter >= 4 && stop1 && stop2 && stop3 || counter == 6 || counter == 4 && counterStops == 2 || counter == 5 && counterStops == 4 ){
                        counterStops = 0;
                        counter = 0;

                        stop1 = false;
                        stop2 = false;
                        stop3 = false;
                        hidden1.setVisibility(View.INVISIBLE);
                        hidden2.setVisibility(View.INVISIBLE);
                        hidden3.setVisibility(View.INVISIBLE);

                        uitkomst2.add(value1);
                        uitkomst2.add(value2);
                        uitkomst2.add(value3);

                        value1_sp2 = value1;
                        value2_sp2 = value2;
                        value3_sp2 = value3;

                        //button_0.setVisibility(View.INVISIBLE);
                        //button_1.setVisibility(View.INVISIBLE);
                        //button_2.setVisibility(View.INVISIBLE);

                        for (int i = 0; i < 3; i++){
                            uitkomst2som += uitkomst2.get(i);
                        }

                        Toast.makeText(getApplicationContext(), "punten " + uitkomst2som, Toast.LENGTH_SHORT).show();
                        speler2.setTextColor(Color.BLACK);
                        speler1.setTextColor(Color.BLUE);

                        // alle mogelijke uitkomsten

                        if(uitkomst1som == 300 && score1 <= 8){
                            score1 = 0;
                            Toasty.info(getApplicationContext(), "You rolled 3 apen", Toast.LENGTH_SHORT).show();
                            scorePlayer1.setText(String.valueOf(score1));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if ( uitkomst1som == 300 && score1 >= 9){
                            score2 = 0;
                            Toasty.info(getApplicationContext(), "You rolled 3 apen", Toast.LENGTH_SHORT).show();
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if(uitkomst2som == 300 && score2 <= 8){
                            score2 = 0;
                            Toasty.info(getApplicationContext(), "You rolled 3 apen", Toast.LENGTH_SHORT).show();
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if ( uitkomst2som == 300 && score2 >= 9) {
                            score1 = 0;
                            Toasty.info(getApplicationContext(), "You rolled 3 apen", Toast.LENGTH_SHORT).show();
                            scorePlayer1.setText(String.valueOf(score1));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else  if (uitkomst1som == 69){
                            Toasty.info(getApplicationContext(), "You rolled a soixante-neuf", Toast.LENGTH_SHORT).show();
                            score1 = score1 - 3;
                            scorePlayer1.setText(String.valueOf(score1));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (uitkomst2som == 69) {
                            Toasty.info(getApplicationContext(), "You rolled a soixante-neuf", Toast.LENGTH_SHORT).show();
                            score2 = score2 - 3;
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp1 == value2_sp1 && value2_sp1 == value3_sp1 && value1_sp1 == 5)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 5", Toast.LENGTH_SHORT).show();
                            score1 = score1 - 2;
                            scorePlayer1.setText(String.valueOf(score1));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp2 == value2_sp2 && value2_sp2 == value3_sp2 && value1_sp2 == 5)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 5", Toast.LENGTH_SHORT).show();
                            score2 = score2 - 2;
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp1 == value2_sp1 && value2_sp1 == value3_sp1 && value1_sp1 == 4)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 4", Toast.LENGTH_SHORT).show();
                            score1 = score1 - 2;
                            scorePlayer1.setText(String.valueOf(score1));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp2 == value2_sp2 && value2_sp2 == value3_sp2 && value1_sp2 == 4)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 4", Toast.LENGTH_SHORT).show();
                            score2 = score2 - 2;
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp1 == value2_sp1 && value2_sp1 == value3_sp1 && value1_sp1 == 3)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 3", Toast.LENGTH_SHORT).show();
                            score1 = score1 - 2;
                            scorePlayer1.setText(String.valueOf(score1));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp2 == value2_sp2 && value2_sp2 == value3_sp2 && value1_sp2 == 3)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 3", Toast.LENGTH_SHORT).show();
                            score2 = score2 - 2;
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp1 == value2_sp1 && value2_sp1 == value3_sp1 && value1_sp1 == 2)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 2", Toast.LENGTH_SHORT).show();
                            score1 = score1 - 2;
                            scorePlayer1.setText(String.valueOf(score1));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (value1_sp2 == value2_sp2 && value2_sp2 == value3_sp2 && value1_sp2 == 2)  {
                            Toasty.info(getApplicationContext(), "You rolled a zand with 2", Toast.LENGTH_SHORT).show();
                            score2 = score2 - 2;
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();

                        } else if (uitkomst1som == 7 || uitkomst2som == 7) {
                            Toasty.info(getApplicationContext(), "You rolled a seven", Toast.LENGTH_SHORT).show();
                            score1++;
                            score2++;
                            scorePlayer1.setText(String.valueOf(score1));
                            scorePlayer2.setText(String.valueOf(score2));
                            uitkomst1som = 0;
                            uitkomst1.clear();
                            uitkomst2som = 0;
                            uitkomst2.clear();
                        } else if (uitkomst1som < uitkomst2som) {
                           score2--;
                           scorePlayer2.setText(String.valueOf(score2));
                           uitkomst1som = 0;
                           uitkomst1.clear();
                           uitkomst2som = 0;
                           uitkomst2.clear();

                       } else if (uitkomst1som > uitkomst2som) {
                           score1--;
                           scorePlayer1.setText(String.valueOf(score1));
                           uitkomst1som = 0;
                           uitkomst1.clear();
                           uitkomst2som = 0;
                           uitkomst2.clear();

                       }
                    }


                if (score1 == 0 || score1 < 0 ){

                    score1 = 9;
                    score2 = 9;
                    scorePlayer1.setText(String.valueOf(score1));
                    scorePlayer2.setText(String.valueOf(score2));

                    totalScorePlayer1 ++;

                    totalScore.setText("Score: " + one + ": " + totalScorePlayer1 + "  " + two + ": " + totalScorePlayer2);

                    popUp.setText( one + " is gewonnen. De score is nu: " + totalScorePlayer1 + " tegen " + totalScorePlayer2 );
                    popUp.setVisibility(view.VISIBLE);

                    popUp.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            popUp.setVisibility(view.INVISIBLE);
                        }
                    });



                } else if (score2 == 0 || score2 < 0){

                    score1 = 9;
                    score2 = 9;
                    scorePlayer1.setText(String.valueOf(score1));
                    scorePlayer2.setText(String.valueOf(score2));

                    totalScorePlayer2 ++;

                    totalScore.setText("Score: " + one + ": " + totalScorePlayer1 + "  " + two + ": " + totalScorePlayer2);

                    popUp.setText( two + " is gewonnen. De score is nu: " + totalScorePlayer1 + " tegen " + totalScorePlayer2 );
                    popUp.setVisibility(view.VISIBLE);

                    popUp.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            popUp.setVisibility(view.INVISIBLE);
                        }
                    });
                }

            }

            public int randomDiceValue(List<Integer> list){
                Random rand = new Random();
                return list.get(rand.nextInt(list.size()));
            }
       });


        //stop button met rolling

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!stop1) {
                    stop1 = true;
                    hidden1.setVisibility(View.VISIBLE);
                } else {
                    stop1 = false;
                    hidden1.setVisibility(View.INVISIBLE);
                }
            }
        });



        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!stop2) {
                    stop2 = true;
                    hidden2.setVisibility(View.VISIBLE);
                } else {
                    stop2 = false;
                    hidden2.setVisibility(View.INVISIBLE);
                }

            }
        });


        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!stop3) {
                    stop3 = true;
                    hidden3.setVisibility(View.VISIBLE);

                } else {
                    stop3 = false;
                    hidden3.setVisibility(View.INVISIBLE);

                }
            }
        });








        //get text from main to here

        speler1 = findViewById(R.id.speler1);
        speler2 = findViewById(R.id.speler2);
        one = getIntent().getExtras().getString("value1");
        two = getIntent().getExtras().getString("value2");
       // OwnScore = getIntent().getExtras().getString("9");

        speler1.setText(one);
        speler2.setText(two);
      //  scorePlayer1.setText(OwnScore);
       // scorePlayer2.setText(OwnScore);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);

        return true;
    }


    Intent shareIntent;
    LinearLayout rulesPop;




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My App");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "This pietjesbak App is amazing, you should really try it out. " + one + " played against " + two + " with a score of " + totalScorePlayer1 + " against " + totalScorePlayer2);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
                return true;

            case R.id.rules:
                rulesPop.setVisibility(View.VISIBLE);
                rollDices.setVisibility(View.INVISIBLE);
                rulesPop.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        rulesPop.setVisibility(view.INVISIBLE);
                        rollDices.setVisibility(View.VISIBLE);
                    }
                });
                break;

            case R.id.restart:
                Intent activity_main = new Intent(Game.this,MainActivity.class);

                startActivity(activity_main);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}