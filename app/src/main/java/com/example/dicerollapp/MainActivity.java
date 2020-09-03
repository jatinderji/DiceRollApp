package com.example.dicerollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnRoll;
    private ImageView diceImage;
    private TextView txt;
    private int dice[]={R.mipmap.dice1,R.mipmap.dice2,R.mipmap.dice3,R.mipmap.dice4,R.mipmap.dice5,R.mipmap.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        diceImage = findViewById(R.id.diceImage);
        btnRoll = findViewById(R.id.btnRoll);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            Random r = new Random();
            @Override
            public void onClick(View v) {

                new CountDownTimer(1000,100){
                    int i=0;
                    @Override
                    public void onTick(long millisUntilFinished) {
                      i = r.nextInt(6);
                      diceImage.setImageResource(dice[i]);
                    }

                    @Override
                    public void onFinish() {
                        txt.setText("You Scored: "+(i+1));
                    }
                }.start();

            }
        });

    }
}