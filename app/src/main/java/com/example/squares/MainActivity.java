package com.example.squares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView numOfSquares, entertext;
    Button addSquare, remSquare,startbutton;
    int currentnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numOfSquares = (TextView)findViewById(R.id.num);
        entertext = (TextView)findViewById(R.id.enternum);
        addSquare = findViewById(R.id.add);
        remSquare = findViewById(R.id.remove);
        startbutton = findViewById(R.id.start);
        currentnum = 0;
        DisplayMetrics displayMetrics = new DisplayMetrics();

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated
        addSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentnum++;
                numOfSquares.setText("" + currentnum);
            }
        });
        remSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentnum--;
                numOfSquares.setText("" + currentnum);
            }
        });
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentnum <= 0){
                    entertext.setText("enter sufficient amount of squares(over 0)");
                }
                else{
                    entertext.setText("ready to draw!");
                    Intent intent = new Intent(MainActivity.this, SquareGame.class);
                    intent.putExtra("numOfSquares", currentnum);
                    intent.putExtra("height", height);
                    intent.putExtra("width", width);
                    startActivity(intent);

                }
            }
        });

    }
}
