package com.example.pitjesbak;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity implements View.OnClickListener
{

    String one, two;
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


    TextView scorePlayer1, scorePlayer2;

    int score1 = 7, score2 = 7;

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

                    if (counter == 3 || stop1 && stop2 && stop3){
                        stop1 = false;
                        stop2 = false;
                        stop3 = false;
                        hidden1.setVisibility(View.INVISIBLE);
                        hidden2.setVisibility(View.INVISIBLE);
                        hidden3.setVisibility(View.INVISIBLE);


                        uitkomst1.add(value1);
                        uitkomst1.add(value2);
                        uitkomst1.add(value3);

                        for (int i = 0; i < 3; i++){
                            uitkomst1som += uitkomst1.get(i);
                        }

                        counter = 3;

                       Toast.makeText(getApplicationContext(), "punten " + uitkomst1som, Toast.LENGTH_SHORT).show();
                        speler1.setTextColor(Color.BLACK);
                        speler2.setTextColor(Color.BLUE);

                    } else if (stop1 && stop2 && stop3 || counter == 6 || counter == 4 && counterStops == 2 || counter == 5 && counterStops == 4 ){
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

                        for (int i = 0; i < 3; i++){
                            uitkomst2som += uitkomst2.get(i);
                        }

                        Toast.makeText(getApplicationContext(), "punten " + uitkomst2som, Toast.LENGTH_SHORT).show();
                        speler2.setTextColor(Color.BLACK);
                        speler1.setTextColor(Color.BLUE);



                       if (uitkomst1som < uitkomst2som) {
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

                       } else {
                           Toast.makeText(getApplicationContext(), "It's a draw", Toast.LENGTH_SHORT).show();

                           uitkomst1som = 0;
                           uitkomst1.clear();
                           uitkomst2som = 0;
                           uitkomst2.clear();
                       }
                    }


                if (score1 == 0 || score1 < 0 ){

                    Toast.makeText(getApplicationContext(), "speler 1 is gewonnen", Toast.LENGTH_SHORT).show();
                    score1 = 7;
                    score2 = 7;
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

                    Toast.makeText(getApplicationContext(), "speler 2 is gewonnen", Toast.LENGTH_SHORT).show();
                    score1 = 7;
                    score2 = 7;
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
                    Toast.makeText(getApplicationContext(), "stop 1", Toast.LENGTH_SHORT).show();
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

        speler1.setText(one);
        speler2.setText(two);



    }

    @Override
    public void onClick(View v) {

    }
}