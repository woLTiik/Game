package com.example.woltik.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterNames extends AppCompatActivity {

    int mode;
    String name1 = "";
    String name2 = "";
    EditText name1Edit;
    EditText name2Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_names);

        Intent intent = getIntent();
        mode = intent.getIntExtra("MODE", 0);

        name1Edit = (EditText) findViewById(R.id.editText);
        name2Edit = (EditText) findViewById(R.id.editText2);
        Button btn = (Button) findViewById(R.id.button);

        if(mode == 1){
            name1Edit.setVisibility(View.GONE);
            TextView tmp = (TextView)findViewById(R.id.textView9);
            tmp.setVisibility(View.GONE);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = name1Edit.getText() + "";
                name2 = name2Edit.getText() + "";
                Intent intent2 =  new Intent(getApplicationContext(), MultiplayerGame.class);
                intent2.putExtra("MODE", mode);
                intent2.putExtra("player1", name1);
                intent2.putExtra("player2", name2);
                startActivity(intent2);
            }
        });

    }
}
