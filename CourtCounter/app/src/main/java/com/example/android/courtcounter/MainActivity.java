package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pointsA, pointsB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(pointsA);
        displayForTeamB(pointsB);

    }

    public void addOneTeamA(View view) {
        pointsA = pointsA + 1;
        displayForTeamA(pointsA);
    }

    public void addTwoTeamA(View view) {
        pointsA = pointsA + 2;
        displayForTeamA(pointsA);
    }

    public void addThreeTeamA(View view) {
        pointsA = pointsA + 3;
        displayForTeamA(pointsA);
    }


    public void addOneTeamB(View view) {
        pointsB = pointsB + 1;
        displayForTeamB(pointsB);
    }

    public void addTwoTeamB(View view) {
        pointsB = pointsB + 2;
        displayForTeamB(pointsB);
    }

    public void addThreeTeamB(View view) {
        pointsB = pointsB + 3;
        displayForTeamB(pointsB);
    }

    public void resetScore(View view){
        pointsA= 0;
        pointsB= 0;
        displayForTeamA(0);
        displayForTeamB(0);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
