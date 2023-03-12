package com.example.mindgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class AnagramActivity extends AppCompatActivity {
    TextView tv_info,tv_word;
    EditText et_guess;
    Button b_check, b_new;
    Random r;
    private TextView textViewTime;
    private Timer timer;
    private int timeCount =0;
    private boolean isTimeRunning;
    String currentWord;
    String[] dictionary={
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagram);
        tv_info=(TextView) findViewById(R.id.tv_info);
        tv_word=(TextView) findViewById(R.id.tv_word);

        et_guess =(EditText) findViewById(R.id.et_guess);

        b_check =(Button) findViewById(R.id.b_check);
        b_new=(Button) findViewById(R.id.b_new);
        r= new Random();
        newGame();
        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_guess.getText().toString().equalsIgnoreCase(currentWord)) {
                    tv_info.setText("Awesome!");
                    b_check.setEnabled(false);
                    b_new.setEnabled(true);
                    timer.cancel();
                }else{
                    tv_info.setText("Try Again!");
                }

            }
        });
        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame1();

            }
        });
    }
    private void newGame1(){
        //get random word from the dictionary
        currentWord =dictionary[r.nextInt(dictionary.length)];
        //show the shuffled word
        tv_word.setText(shuffleWord(currentWord));
        //clear the text field
        et_guess.setText("");
        //switch buttons
        b_new.setEnabled(false);
        b_check.setEnabled(true);
        textViewTime=findViewById(R.id.text_view_time);
        timeCount=0;
        isTimeRunning=true;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeCount++;
                int second =timeCount % 60;
                int hour =timeCount /3600;
                int  minute=(timeCount-hour*3600)/60;
                textViewTime.setText(String.format("Time:%02d: %02d:%02d",hour,minute,second));
            }
        },1000,1000);

    }
    //shuffle code
    private String shuffleWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled ="";
        for(String letter : letters){
            shuffled +=letter;

        }
        return shuffled;

    }
    private void newGame(){
        //get random word from the dictionary
        currentWord =dictionary[r.nextInt(dictionary.length)];
        //show the shuffled word
        tv_word.setText(shuffleWord(currentWord));
        //clear the text field
        et_guess.setText("");
        //switch buttons
        b_new.setEnabled(false);
        b_check.setEnabled(true);
        textViewTime=findViewById(R.id.text_view_time);
        loadTimer();

    }
    private void loadTimer(){
        isTimeRunning=true;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeCount++;
                setTime(timeCount);
            }
        },1000,1000);
    }
    private void setTime(int timeCount){
        int second =timeCount % 60;
        int hour =timeCount /3600;
        int  minute=(timeCount-hour*3600)/60;
        textViewTime.setText(String.format("Time:%02d: %02d:%02d",hour,minute,second));
    }
}