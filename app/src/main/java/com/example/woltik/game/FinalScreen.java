package com.example.woltik.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.woltik.game.dataInput.DBhandler;
import com.example.woltik.game.dataInput.Score;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FinalScreen extends AppCompatActivity {

    String name1;
    String name2;
    TextView winersName;
    TextView scoreText;
    int mode;
    Button menu;
    Button scores;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        winersName = (TextView)findViewById(R.id.player_name);
        scoreText = (TextView)findViewById(R.id.points_earned);
        menu = (Button) findViewById(R.id.menu_button);
        scores = (Button) findViewById(R.id.high_scores_button);

        Intent intent = getIntent();
        mode = intent.getIntExtra("MODE", 0);
        name1 = intent.getStringExtra("name1");
        score = intent.getIntExtra("score",0);
        winersName.setText(name1);
        scoreText.setText(score+"");


        String dateString = "";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        dateString = df.format(c.getTime());

        if(mode != 1) {
            name2 = intent.getStringExtra("name2");
            DBhandler db = new DBhandler(this);
            db.addScore(new Score(dateString, score, name1, name2));
        }

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HighScore.class);
                startActivity(intent);
            }
        });
    }
}
