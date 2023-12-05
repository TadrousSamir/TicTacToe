package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  AddPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        final EditText playrOne = findViewById(R.id.PlayerOneName);
        final EditText playerTwo= findViewById(R.id.PlayerTwoName);
        final Button startGame = findViewById(R.id.StartGamebtn);




        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getplayerOneName=playrOne.getText().toString();
                final String getpalyerTwoName=playerTwo.getText().toString();

                if(getplayerOneName.isEmpty() ||getpalyerTwoName.isEmpty()){
                    Toast.makeText(getBaseContext(),"Enter player name",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent in1=new Intent(AddPlayer.this,MainActivity.class);
                    in1.putExtra("playerOne", getplayerOneName);
                    in1.putExtra("playerTwo",getpalyerTwoName);
                    startActivity(in1);

                }
            }
        });
    }
}