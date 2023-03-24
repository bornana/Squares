package com.example.squares;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SquareGame extends AppCompatActivity {
        Paint paint;
        String currentColor = "#FFFFFFFF";
        FrameLayout frame;

        private PaintView paintView;
        DisplayMetrics displayMetrics = new DisplayMetrics();


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_square);
                frame = findViewById(R.id.frm);
                Intent intent = getIntent();
                int numOfSquares = intent.getExtras().getInt("numOfSquares");
                int height = intent.getExtras().getInt("height");

                int width = intent.getExtras().getInt("width");

                paintView = new PaintView(this, numOfSquares,height, width);
                frame.addView(paintView);


            }
}
