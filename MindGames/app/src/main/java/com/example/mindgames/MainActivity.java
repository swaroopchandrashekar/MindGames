package com.example.mindgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonStartGame;
    private Button buttonStartGame1;
    private Button buttonStartGame2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStartGame = findViewById(R.id.button_start_game);
        buttonStartGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,GameActivity.class));
            }
        });
        buttonStartGame1 = findViewById(R.id.button_start_game1);
        buttonStartGame1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,AnagramActivity.class));
            }
        });
        buttonStartGame2 = findViewById(R.id.button_start_game2);
        buttonStartGame2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,MemoryActivity.class));
            }
        });
    }
}