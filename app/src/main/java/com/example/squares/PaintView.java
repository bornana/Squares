package com.example.squares;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;
import java.util.Stack;

public class PaintView extends View {

    private Paint paint;
    private Paint bgPaint;
    private String currentShape = "Rect";
    private String currentColor = "#FFFFFFFF";
    private boolean fill;

    int y = 0, x = 0,yMax,xMax, numToDraw;
    Random r = new Random();
    public PaintView(Context context, int numOfSquaresToDraw, int screenheight, int screenwidth) {
        super(context);
        yMax = screenheight;
        xMax = screenwidth;
        numToDraw = numOfSquaresToDraw;
        paint = new Paint();
        bgPaint = new Paint();
        bgPaint.setColor(Color.rgb(255,255,255));


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(bgPaint);
        for(int i = 0; i< numToDraw; i++){
            paint.setColor(Color.rgb(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            x = r.nextInt(xMax);
            y = r.nextInt(yMax);
            canvas.drawRect(x, y, x+ 100, y + 100, paint);
        }
    }

}
