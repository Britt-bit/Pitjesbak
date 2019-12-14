package com.example.pitjesbak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;


import java.util.Random;

public class Game extends AppCompatActivity {

    String one, two;
    TextView speler1;
    TextView speler2;


    Button soixante_neuf;
    Button apen;
    Button zand;
    Button zeven;

    boolean stop1;
    boolean stop2;
    boolean stop3;


    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageButton1, imageButton2, imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        rollDices = findViewById(R.id.rollDices);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        //array van maken?

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int value1 = randomDiceValue();
                int value2 = randomDiceValue();
                int value3 = randomDiceValue();

                if(stop1 == false){
                    int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.example.pitjesbak");
                    imageButton1.setImageResource(res1);
                }

                if(stop2 == false){
                    int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.example.pitjesbak");
                    imageButton2.setImageResource(res2);
                }

                if(stop3 == false){
                    int res3 = getResources().getIdentifier("dice_" + value3, "drawable", "com.example.pitjesbak");
                    imageButton3.setImageResource(res3);
                }
            }
        });




        imageButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (stop1==false){
                    stop1 = true;
                }else{
                    stop1 =false;
                }
            }
        });


        imageButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (stop2==false){
                    stop2 = true;
                }else{
                    stop2 =false;
                }
            }
        });


        imageButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (stop3==false){
                    stop3 = true;
                }else{
                    stop3 =false;
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


        //dobbel hulp buttons

        soixante_neuf = findViewById(R.id.soixante_neuf);
        soixante_neuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int res1 = getResources().getIdentifier("dice_6", "drawable", "com.example.pitjesbak");
                int res2 = getResources().getIdentifier("dice_5", "drawable", "com.example.pitjesbak");
                int res3 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                imageButton1.setImageResource(res1);
                imageButton2.setImageResource(res2);
                imageButton3.setImageResource(res3);
            }
        });


        apen = findViewById(R.id.apen);
        apen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int res1 = getResources().getIdentifier("dice_1", "drawable", "com.example.pitjesbak");
                int res2 = getResources().getIdentifier("dice_1", "drawable", "com.example.pitjesbak");
                int res3 = getResources().getIdentifier("dice_1", "drawable", "com.example.pitjesbak");
                imageButton1.setImageResource(res1);
                imageButton2.setImageResource(res2);
                imageButton3.setImageResource(res3);
            }
        });


        zand = findViewById(R.id.zand);
        zand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int res1 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                int res2 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                int res3 = getResources().getIdentifier("dice_4", "drawable", "com.example.pitjesbak");
                imageButton1.setImageResource(res1);
                imageButton2.setImageResource(res2);
                imageButton3.setImageResource(res3);
            }
        });


        zeven = findViewById(R.id.zeven);
        zeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int res1 = getResources().getIdentifier("dice_2", "drawable", "com.example.pitjesbak");
                int res2 = getResources().getIdentifier("dice_2", "drawable", "com.example.pitjesbak");
                int res3 = getResources().getIdentifier("dice_3", "drawable", "com.example.pitjesbak");
                imageButton1.setImageResource(res1);
                imageButton2.setImageResource(res2);
                imageButton3.setImageResource(res3);
            }
        });













   //     rollDices.setOnClickListener(new View.OnClickListener() {
   //         public void onClick(View v) {
   //             if (v == rollDices){
   //               int value1 = randomDiceValue();
   //               int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.example.pitjesbak");
   //               imageButton1.setImageResource(res1);
   //             }else{
   //                 imageButton1.setImageResource();
   //             Toast.makeText(Game.this, "It works", Toast.LENGTH_SHORT).show();
   //            }
   //         }
   //     });

//        imageButton2.setOnClickListener(new View.OnClickListener() {
//            boolean value2clicked = false;

//            public void onClick(View v) {
//                value2clicked = true;

//                Toast.makeText(Game.this, "It works 2", Toast.LENGTH_SHORT).show();


//            }

//            public boolean getValue2clicked(){
//
 //               return value2clicked;

//            }
//        });

//        imageButton3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Toast.makeText(Game.this, "It works 3", Toast.LENGTH_SHORT).show();
//            }
//        });


    }
    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }



}