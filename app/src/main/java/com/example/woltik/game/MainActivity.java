package com.example.woltik.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView highScoreTextView;
    TextView aboutTextView;
    TextView settingsTextView;
    TextView multiPlayerTextView;
    TextView singlePlayerView;
    MediaPlayer menuMusic;
    ToggleButton muteBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        highScoreTextView = (TextView)findViewById(R.id.highScoreLabel);
        highScoreTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getApplicationContext(), HighScore.class);
                startActivity(intent);
                return false;
            }
        });

        aboutTextView = (TextView)findViewById(R.id.aboutLabel);
        aboutTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
                return false;
            }
        });

        multiPlayerTextView = (TextView)findViewById(R.id.twoPlayerModeLabel);
        multiPlayerTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getApplicationContext(), EnterNames.class);
                intent.putExtra("MODE", 2);
                startActivity(intent);
                return false;
            }
        });

        singlePlayerView = (TextView)findViewById(R.id.singleModeLabel);
        singlePlayerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getApplicationContext(), EnterNames.class);
                intent.putExtra("MODE", 1);
                startActivity(intent);
                return false;
            }
        });

        settingsTextView = (TextView)findViewById(R.id.settingsLabel);
        settingsTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getApplicationContext(), Options.class);
                startActivity(intent);
                return false;
            }
        });

        muteBtn = (ToggleButton) findViewById(R.id.mute_btn);
        muteBtn.setChecked(true);
        muteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(muteBtn.isChecked()){
                    menuMusic.stop();
                }else{
                   menuMusic = MediaPlayer.create(MainActivity.this, R.raw.menu_music);
                    menuMusic.start();
                }
            }
        });
    }



}