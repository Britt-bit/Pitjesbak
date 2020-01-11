package com.example.pitjesbak;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    String one, two;
    EditText player1;
    EditText player2;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        submitButton = findViewById(R.id.submitButton);

        player1.addTextChangedListener(playerTextWatcher);
        player2.addTextChangedListener(playerTextWatcher);
        submitButton.setEnabled(false);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity_game = new Intent(MainActivity.this,Game.class);
                one = player1.getText().toString();
                two = player2.getText().toString();
                activity_game.putExtra("value1",one);
                activity_game.putExtra("value2",two);
                startActivity(activity_game);
                finish();
            }
        });
    }

    private TextWatcher playerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String player1Input = player1.getText().toString().trim();
            String player2Input = player2.getText().toString().trim();
            submitButton.setEnabled(!player1Input.isEmpty() && !player2Input.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}


