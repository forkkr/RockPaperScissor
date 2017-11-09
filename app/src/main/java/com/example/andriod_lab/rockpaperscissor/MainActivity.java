package com.example.andriod_lab.rockpaperscissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rockButton, paperButton , scissorButton;
    TextView playerScore , computerScore , result , round;
    ImageView computer , player;
    public  static int roundCount = 0 , pscore = 0, cscore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockButton = (Button)findViewById(R.id.b_rock);
        paperButton = (Button)findViewById(R.id.b_paper);
        scissorButton = (Button) findViewById(R.id.b_scissors);
        playerScore = (TextView) findViewById(R.id.playerScore);
        computerScore = (TextView) findViewById(R.id.computerScore);
        result = (TextView) findViewById(R.id.resultText);
        computer = (ImageView) findViewById(R.id.computerImage);
        player = (ImageView) findViewById(R.id.playerImage);
        round = (TextView) findViewById(R.id.roundNumber);

        rockButton.setOnClickListener(new View.OnClickListener() {

            int playerValue , computerValue;
            public void onClick(View view) {
                playerValue = 0;
                Random random = new Random();
                computerValue = random.nextInt(3);
                function(playerValue , computerValue);
                roundCount++;

            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            int playerValue , computerValue;
            public void onClick(View view) {
                playerValue = 1;
                Random random = new Random();
                computerValue = random.nextInt(3);
                function(playerValue , computerValue);
                roundCount++;

            }
        });
        scissorButton.setOnClickListener(new View.OnClickListener() {
            int playerValue , computerValue;
            public void onClick(View view) {
                playerValue = 2;
                Random random = new Random();
                computerValue = random.nextInt(3);
                function(playerValue , computerValue);
                roundCount++;

            }
        });
    }

    public void function(int playerValue , int computerValue) {
        System.out.println(playerValue +" "+ computerValue);
        if(playerValue==0)
        {
            player.setImageResource(R.drawable.rock);
        }
        else if(playerValue==1)
        {
            player.setImageResource(R.drawable.paper);
        }
        else
        {
            player.setImageResource(R.drawable.scissos);
        }
        if(computerValue==0)
        {
            computer.setImageResource(R.drawable.rock);
        }
        else if(computerValue==1)
        {
            computer.setImageResource(R.drawable.paper);
        }
        else
        {
            computer.setImageResource(R.drawable.scissos);
        }
        if(playerValue == (computerValue+1)%3)
        {
            pscore++;
            String s ="Player: ";
            s+=pscore;
            playerScore.setText(s);
            s="Round: ";
            s+=roundCount;
            round.setText(s);
            s="";
            s+="Winner: Player";
            result.setText(s);
        }
        else if(computerValue == (playerValue+1)%3)
        {
            cscore++;
            String s="Computer: ";
            s+=cscore;
            computerScore.setText(s);
            s="Round: ";
            s+=roundCount;
            round.setText(s);
            s="";
            s+="Winner: Computer";
            result.setText(s);
        }
        else
        {
            String s="Round: ";
            s+=roundCount;
            round.setText(s);
            s="";
            s+="DRAWN";
            result.setText(s);
        }
        if(roundCount >=20)
        {
            roundCount = 0;
            Intent intent = new Intent(MainActivity.this , Main2Activity.class);
            startActivity(intent);
            finish();
        }

    }
}
