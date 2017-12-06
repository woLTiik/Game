package com.example.woltik.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.woltik.game.dataInput.DBhandler;
import com.example.woltik.game.dataInput.Score;

import java.util.ArrayList;
import java.util.List;

public class HighScore extends AppCompatActivity {
    public static final String TAG = "HighScore";

    private ArrayList<Score> scores;
    private ListView scoresListView;
    private Button deleteScores;
    DBhandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        db = new DBhandler(HighScore.this);

        scores = db.getAllScore();
        scoresListView = (ListView) findViewById(R.id.scoreListView);
        deleteScores = (Button) findViewById(R.id.deleteScoreButton);

        ArrayList<String> scoreLabel = new ArrayList<>();

        for (Score s : scores){
            scoreLabel.add(s.getScore()+".b " + s.getName1() + " v.s. "+ s.getName2() + " " + s.getDate());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(HighScore.this, android.R.layout.simple_list_item_1, scoreLabel);

        scoresListView.setAdapter(arrayAdapter);

        deleteScores.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                db.deleteScore();
                scoresListView.setVisibility(View.GONE);
                deleteScores.setVisibility(View.GONE);
                return false;
            }
        });
    }
}
