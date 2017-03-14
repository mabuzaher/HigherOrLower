package com.example.dell.higherorlower;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int RandomNumber;
    EditText input ;
    View backGround;
    ImageView  higher , lower;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        RandomNumber = r.nextInt(10);
        input = (EditText) findViewById(R.id.editText);
        backGround = findViewById(R.id.activity_main);
        higher = (ImageView) findViewById(R.id.higher);
        lower = (ImageView) findViewById(R.id.lower);
        msg = (TextView) findViewById(R.id.Massage);

        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    higherOrLower();
                    return true;
                }else {
                    return false;
                }
            }
        });
    }



    private void higherOrLower(){


        if (!input.getText().toString().isEmpty()) {

            lower.setTranslationY(-20f);
            higher.setTranslationY(20f);

            int inputConverted = Integer.parseInt(input.getText().toString());

            if (RandomNumber == inputConverted) {
                msg.setText("You've Got It Right! Try Again?");
                Random r = new Random();
                RandomNumber = r.nextInt(10) + 1;
                lower.animate().alpha(0f).setDuration(1000);
                higher.animate().alpha(0f).setDuration(1000);
                backGround.setBackgroundColor(Color.MAGENTA);


            } else if (RandomNumber < inputConverted) {
                msg.setText(inputConverted+" is higher!");
                higher.animate().alpha(0f).translationYBy(-20f).setDuration(1000);
                backGround.setBackgroundColor(Color.GREEN);
                lower.animate().alpha(1f).translationYBy(20f).setDuration(1000);
            } else if (RandomNumber > inputConverted) {
                msg.setText(inputConverted+" is lower!");
                lower.animate().alpha(0f).translationYBy(20f).setDuration(1000);
                backGround.setBackgroundColor(Color.RED);
                higher.animate().alpha(1f).translationYBy(-20f).setDuration(1000);
            }
            input.setText("");
            input.requestFocus();
        }
    }
}
