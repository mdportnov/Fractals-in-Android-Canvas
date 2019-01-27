package com.example.canvasfractal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class drawActivity extends AppCompatActivity {
    private static int draw_value=5;
    private static float degree=45;
    private static String selectedFractal;
    private static float Inc=0;
    private static int Iter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Draw2D draw2D = new Draw2D(this);
        setContentView(draw2D);

        selectedFractal=getIntent().getStringExtra("id");
        draw_value=Integer.parseInt(getIntent().getStringExtra("count"));
        degree=Float.parseFloat(getIntent().getStringExtra("degree"));
        Inc=Float.parseFloat(getIntent().getStringExtra("Inc"));
        Iter=Integer.parseInt(getIntent().getStringExtra("Iter"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Draw2D draw2D = new Draw2D(this);
        setContentView(draw2D);

        selectedFractal=getIntent().getStringExtra("id");
        draw_value=Integer.parseInt(getIntent().getStringExtra("count"));
        degree=Float.parseFloat(getIntent().getStringExtra("degree"));
        Inc=Float.parseFloat(getIntent().getStringExtra("Inc"));
        Iter=Integer.parseInt(getIntent().getStringExtra("Iter"));
    }

    public static int getCount(){
        return draw_value;
    }

    public static float getDegree() {
        return  degree;
    }

    public static String getSelectedFractal() {
        return selectedFractal;
    }

    public static float getInc() {
        return Inc;
    }

    public static int getIter() {
        return Iter;
    }
}
