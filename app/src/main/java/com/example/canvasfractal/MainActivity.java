package com.example.canvasfractal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    SeekBar seekBarD;
    Button btn;
    String value="1";
    String degree="45";
    String radioId="simplefractal";
    TextView textView, textViewD;
    RadioGroup radioGroup;
    LinearLayout simpleFractalContainer;
    LinearLayout barnsleyContainer;

    SeekBar seekbarInc;
    SeekBar seekbarIter;
    String Inc="0", Iter="20000";
    TextView textViewB, textViewB2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        seekBar=findViewById(R.id.seekBar);
        textView=findViewById(R.id.text);
        seekBarD=findViewById(R.id.seekBar2);
        textViewD=findViewById(R.id.text2);
        radioGroup=findViewById(R.id.radiogroup);
        simpleFractalContainer=findViewById(R.id.simpleFractalContainer);

        seekbarInc=findViewById(R.id.seekBarInc);
        seekbarIter=findViewById(R.id.seekBarIteration);
        textViewB=findViewById(R.id.textB);
        textViewB2=findViewById(R.id.textB2);
        barnsleyContainer=findViewById(R.id.barnsleyContainer);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                case R.id.simplefractal:
                    simpleFractalContainer.setVisibility(View.VISIBLE);
                    barnsleyContainer.setVisibility(View.GONE);
                    radioId="simplefractal";
                    break;
                case R.id.sierpinski:
                    seekBarD.setClickable(false);
                    radioId="sierpinski";

                    break;
                case R.id.barnsley:
                    simpleFractalContainer.setVisibility(View.GONE);
                    barnsleyContainer.setVisibility(View.VISIBLE);
                    radioId="barnsley";
                    break;
                }
            }
        });


        //degrees listener
        seekBarD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                degree=String.valueOf(seekBarD.getProgress());
                textViewD.setText(degree);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //iteration listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value=String.valueOf(seekBar.getProgress());
                textView.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //barnsley inc listener
        seekbarInc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Inc=String.valueOf(seekBar.getProgress());
                textViewB2.setText(String.valueOf(Float.parseFloat(Inc)/10));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbarIter.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Iter=String.valueOf(seekBar.getProgress());
                textViewB.setText(String.valueOf(Integer.parseInt(Iter)+20000));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    public void onClick(View view){
        Intent intent = new Intent(this, drawActivity.class);
        intent.putExtra("count", value);
        intent.putExtra("degree", degree);
        intent.putExtra("id", radioId);
        intent.putExtra("Inc", Inc);
        intent.putExtra("Iter", Iter);
        startActivity(intent);
    }
}


