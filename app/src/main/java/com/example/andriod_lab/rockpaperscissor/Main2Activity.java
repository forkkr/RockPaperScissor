package com.example.andriod_lab.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView congratulationText , winnerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameoverlayout);
        congratulationText = (TextView) findViewById(R.id.wishText);
        winnerName = (TextView) findViewById(R.id.winnerName);
        if (MainActivity.pscore > MainActivity.cscore) {
            winnerName.setText("Player!. Well played");
        } else if (MainActivity.cscore > MainActivity.pscore) {
            winnerName.setText("Computer");

        } else
        {
            winnerName.setText("Both Player and Computer");
        }

    }
}
