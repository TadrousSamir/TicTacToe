package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList = new ArrayList<>();

    private int[] boxpositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int playerTurn = 1;

    private int totalSelectedBoxes = 1;

    private LinearLayout playerOnelayout, playerTwolayout;
    private TextView playerOneName, playerTwoName;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneName = findViewById(R.id.PlayerOneName);
        playerTwoName = findViewById(R.id.PlayerTwoName);

        playerOnelayout = findViewById(R.id.PlayerOnelayout);
        playerTwolayout = findViewById(R.id.PlayerTwolayout);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);


        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        combinationsList.add(new int[]{0, 3, 6});
        combinationsList.add(new int[]{1, 4, 7});
        combinationsList.add(new int[]{2, 5, 8});
        combinationsList.add(new int[]{2, 4, 6});
        combinationsList.add(new int[]{0, 4, 8});

        final String getplayerOneName = getIntent().getStringExtra("playerOne");
        final String getplayerTwoName = getIntent().getStringExtra("playerTwo");


        playerOneName.setText(getplayerOneName);
        playerTwoName.setText(getplayerTwoName);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(0)) {
                    preformAction((ImageView)v,0);
                }

            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(1)) {
                    preformAction((ImageView)v,1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(2)) {
                    preformAction((ImageView)v,2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(3)) {
                    preformAction((ImageView)v,3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(4)) {
                    preformAction((ImageView)v,4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(5)) {
                    preformAction((ImageView)v,5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(6)) {
                    preformAction((ImageView)v,6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(7)) {
                    preformAction((ImageView)v,7);
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooxSelectable(8)) {
                    preformAction((ImageView)v,8);
                }
            }
        });


    }

    private void preformAction(ImageView imageView, int selectedBoxPosition) {
        boxpositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.close);

            if (checkPlyerWin()) {
                WinDilog winDilog = new WinDilog(MainActivity.this, playerOneName.getText().toString() + "has won the match", MainActivity.this);
                winDilog.setCancelable(false);
                winDilog.show();
            } else if (totalSelectedBoxes == 9) {
                WinDilog winDilog = new WinDilog(MainActivity.this, "It is a draw !", MainActivity.this);
                winDilog.setCancelable(false);
                winDilog.show();
            } else {
                changelayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else{
            imageView.setImageResource(R.drawable.o);

            if(checkPlyerWin()){
                WinDilog winDilog = new WinDilog(MainActivity.this, playerTwoName.getText().toString() +" "+ " has won the match", MainActivity.this);
                winDilog.setCancelable(false);
                winDilog.show();
            }
            else if (selectedBoxPosition == 9) {
                WinDilog winDilog = new WinDilog(MainActivity.this, " It is a draw !", MainActivity.this);
                winDilog.setCancelable(false);

                winDilog.show();
            }
            else {
                changelayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }


    private void changelayerTurn(int currentPlyerTurn){

        playerTurn = currentPlyerTurn;

        if(playerTurn == 1){
            playerOnelayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerTwoName.setBackgroundResource(R.drawable.round_back_dark_blue);

        }
        else {
            playerOnelayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerTwoName.setBackgroundResource(R.drawable.round_back_dark_blue);}
    }

    private boolean checkPlyerWin(){
        boolean response = false;

        for (int i=0;i<combinationsList.size();i++){
            final int[] combination =combinationsList.get(i);
            if(boxpositions[combination[0]]==playerTurn &&boxpositions[combination[1]]==playerTurn &&boxpositions[combination[2]]==playerTurn)
                response=true;
        }
        return response;
    }
    private  boolean isBooxSelectable(int boxPosition){

        boolean response = false;
        if(boxpositions[boxPosition]==0){

            response=true;
        }
        return response;
    }
    public void restartMatch(){
        boxpositions = new int[]{0,0,0,0,0,0,0,0,0};

        playerTurn=1;

        totalSelectedBoxes = 1;

        image1.setImageResource(R.drawable.trans);
        image2.setImageResource(R.drawable.trans);
        image3.setImageResource(R.drawable.trans);
        image4.setImageResource(R.drawable.trans);
        image5.setImageResource(R.drawable.trans);
        image6.setImageResource(R.drawable.trans);
        image7.setImageResource(R.drawable.trans);
        image8.setImageResource(R.drawable.trans);
        image9.setImageResource(R.drawable.trans);


    }
}