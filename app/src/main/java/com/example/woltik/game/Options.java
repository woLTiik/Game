package com.example.woltik.game;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class Options extends AppCompatActivity {
    public final String TAG = "Options";
    MediaPlayer media;
    boolean mute = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        media = MediaPlayer.create(this, R.raw.menu_music);


    }

}
