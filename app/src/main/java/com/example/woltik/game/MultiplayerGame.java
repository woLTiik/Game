package com.example.woltik.game;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.woltik.game.dataInput.Question;
import com.example.woltik.game.dataInput.Questions;


public class MultiplayerGame extends AppCompatActivity {

    TextView quest1;
    TextView quest2;
    TextView points1;
    TextView points2;
    Button pl1Yes;
    Button pl1No;
    Button pl2Yes;
    Button pl2No;

    int mode;
    Questions questions = new Questions();
    Question question = questions.getRandomQuestion();
    String name1;
    String name2;
    int points = 0;
    int moves = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_multiplayer_game);

        quest1 = (TextView)findViewById(R.id.question2);
        quest2 = (TextView)findViewById(R.id.question   );
        points1 = (TextView)findViewById(R.id.points1);
        points2 = (TextView)findViewById(R.id.points2);
        pl1Yes = (Button)findViewById(R.id.yes_pl1);
        pl1No = (Button)findViewById(R.id.no_pl1);
        pl2Yes = (Button)findViewById(R.id.yes_pl2);
        pl2No = (Button)findViewById(R.id.no_pl2);

        Intent intent = getIntent();
        mode = intent.getIntExtra("MODE", 0);
        name1 = intent.getStringExtra("player1");
        name2 = intent.getStringExtra("player2");

        if(mode == 1){
            pl2No.setVisibility(View.GONE);
            pl2Yes.setVisibility(View.GONE);
            quest2.setVisibility(View.GONE);
            points2.setVisibility(View.GONE);
        }


        changeQuestion();
        redrawScore();


        pl1Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(1);
            }
        });
        pl1No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(-1);
            }
        });
        pl2Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(2);
            }
        });
        pl2No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(-2);
            }
        });
    }

    public void changeQuestion(){
        Question newQuestion;
        while(true){
            newQuestion = questions.getRandomQuestion();
            if(newQuestion.question != question.question){
                question = newQuestion;
                break;
            }
        }
        quest1.setText(question.question);
        quest2.setText(question.question);
    }

    public void redrawScore(){
        points1.setText(points + "");
        points2.setText((points*(-1)) + "");
    }

    public void move(int pressedButton){
        switch (pressedButton){
            case 1:
                if(question.isTrue){
                    points++;
                } else {
                    points--;
                }
                break;
            case -1:
                if(!question.isTrue){
                    points++;
                } else {
                    points--;
                }
                break;
            case 2:
                if(question.isTrue){
                    points--;
                } else {
                    points++;
                }
                break;
            case -2:
                if(!question.isTrue){
                    points--;
                } else {
                    points++;
                }
                break;
            default:
                break;
        }

        moves--;

        if(moves == 0){
            Intent intent = new Intent(getApplicationContext(), FinalScreen.class);
            if(points >0 ) {
                intent.putExtra("name1", name1);
                intent.putExtra("name2", name2);
                intent.putExtra("score", points);
                intent.putExtra("MODE", mode);
            } else {
                intent.putExtra("name1", name2);
                intent.putExtra("name2", name1);
                intent.putExtra("score", (points * (-1)));
                intent.putExtra("MODE", mode);
            }
            startActivity(intent);
        } else {
            changeQuestion();
            redrawScore();
        }
    }

}
