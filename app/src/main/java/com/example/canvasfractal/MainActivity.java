package com.example.canvasfractal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    SeekBar seekBarD;
    Button btn;
    String value;
    String degree;
    String radioId;
    TextView textView, textViewD;
    RadioGroup radioGroup;


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


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                case R.id.simplefractal:
                    seekBar.setEnabled(true);
                    seekBarD.setEnabled(true);
                    radioId="simplefractal";
                    break;
                case R.id.sierpinski:
                    seekBarD.setClickable(false);
                    radioId="sierpinski";

                    break;
                case R.id.barnsley:
                    seekBar.setEnabled(false);
                    seekBarD.setEnabled(false);
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
    }


    public void onClick(View view){
        Intent intent = new Intent(this, drawActivity.class);
        intent.putExtra("count", value);
        intent.putExtra("degree", degree);
        intent.putExtra("id", radioId);
        startActivity(intent);
    }
}


