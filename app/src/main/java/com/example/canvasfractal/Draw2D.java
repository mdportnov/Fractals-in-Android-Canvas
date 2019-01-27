package com.example.canvasfractal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;


public class Draw2D extends View {

    private Paint mPaint = new Paint();

    public Draw2D(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);



        // рисуем узор

        drawSelectedFractal(canvas, paint);

    }

    private void drawSelectedFractal(Canvas canvas, Paint paint) {

        int n = drawActivity.getCount();
        float degree = drawActivity.getDegree();
        String selectedFractal = drawActivity.getSelectedFractal();
        float inc = drawActivity.getInc();
        int iter = drawActivity.getIter();

        switch (selectedFractal){
            case "simplefractal":
                fractal(canvas, paint, n, degree, canvas.getWidth() / 2, canvas.getHeight() / 2 - 125, canvas.getWidth() / 2, canvas.getHeight() / 2 + 125);
                break;

            case "sierpinski":

                break;

            case "barnsley":
                pBarnsleyFern(canvas, paint, iter+20000, -inc/100);
                break;

        }
    }




    Random rand = new Random();
    private void fractal(Canvas canvas, Paint ppaint, int n, float degree, float x0, float y0, float x1, float y1) {
        float angle = (float) (degree * Math.PI / 180);
        if (n == 0) {

            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);

            ppaint.setColor(Color.rgb(r, g, b));
            canvas.drawLine(x0, y0, x1, y1, ppaint);
        } else {
            float xx = (float) (Math.cos(angle) * ((x1 - x0) * Math.cos(angle) - (y1 - y0) * Math.sin(angle)) + x0);
            float yy = (float) (Math.cos(angle) * ((x1 - x0) * Math.sin(angle) + (y1 - y0) * Math.cos(angle)) + y0);
            fractal(canvas, ppaint, n - 1, degree, x0, y0, xx, yy); //A1, A3
            fractal(canvas, ppaint, n - 1, degree, xx, yy, x1, y1);

        }

    }

    private void pBarnsleyFern(Canvas canvas, Paint ppaint, int lim, float inc) {
        float x=0f,y=0f,xw,yw, r1;

        // Clean canvas
        ppaint.setColor(Color.WHITE);
        canvas.drawPaint(ppaint);

        // MAIN LOOP
        for(int i=0; i<lim; i++) {

            r1=randgp(100);

            if (r1<=1) {
                xw=0; yw=(0.16f+inc)*y;
            }
            else if (r1<=8) {
                xw=(0.2f*x+inc)-(0.26f+inc)*y;
                yw=(0.23f*x+inc)+(0.22f+inc)*y+(1.6f+inc);
            }
            else if (r1<=15) {
                xw=(-0.15f+inc)*x+(0.28f+inc)*y;
                yw=(0.26f+inc)*x+(0.24f+inc)*y+0.44f;
            }
            else {
                xw=(0.85f+inc)*x+(0.04f+inc)*y;
                yw=(-0.04f+inc)*x+(0.85f+inc)*y+1.6f;
            }

            x=xw;y=yw;

            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);

            ppaint.setColor(Color.rgb(r, g, b));

            canvas.drawCircle(x*120+canvas.getWidth()/2,-y*120+(float)canvas.getHeight()/(float)(1.3),2, ppaint);

        }
    }

    private float randgp(float max) {
        float n=(float)(Math.floor(Math.random()*max));
        return n;
    }


}