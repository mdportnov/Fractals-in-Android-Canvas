package com.example.canvasfractal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


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

        switch (selectedFractal){
            case "simplefractal":
                fractal(canvas, paint, n, degree, canvas.getWidth() / 2, canvas.getHeight() / 2 - 125, canvas.getWidth() / 2, canvas.getHeight() / 2 + 125);
                break;

            case "sierpinski":

                break;

            case "barnsley":
                pBarnsleyFern(canvas, 20000);
                break;

        }
    }





    private void fractal(Canvas canvas, Paint paint, int n, float degree, float x0, float y0, float x1, float y1) {
        float angle = (float) (degree * Math.PI / 180);
        if (n == 0) {
            canvas.drawLine(x0, y0, x1, y1, paint);
        } else {
            float xx = (float) (Math.cos(angle) * ((x1 - x0) * Math.cos(angle) - (y1 - y0) * Math.sin(angle)) + x0);
            float yy = (float) (Math.cos(angle) * ((x1 - x0) * Math.sin(angle) + (y1 - y0) * Math.cos(angle)) + y0);
            fractal(canvas, paint, n - 1, degree, x0, y0, xx, yy); //A1, A3
            fractal(canvas, paint, n - 1, degree, xx, yy, x1, y1);

        }

    }

    private void pBarnsleyFern(Canvas canvas, int lim) {
        float x=0f,y=0f,xw,yw, r;

        // Clean canvas
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        // MAIN LOOP
        for(int i=0; i<lim; i++) {

            r=randgp(200);

            if (r<=1) {xw=0; yw=0.16f*y;}
            else if (r<=8) {xw=0.2f*x-0.26f*y; yw=0.23f*x+0.22f*y+1.6f;}
            else if (r<=15) {xw=-0.15f*x+0.28f*y;yw=0.26f*x+0.24f*y+0.44f;}
            else {xw=0.85f*x+0.04f*y;yw=-0.04f*x+0.85f*y+1.6f;}
            x=xw;y=yw;

            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(x*50+260,-y*50+540,1, mPaint);

        }//fend i
    }

    private float randgp(float max) {
        float n=(float)(Math.floor(Math.random()*max));
        return n;
    }


}