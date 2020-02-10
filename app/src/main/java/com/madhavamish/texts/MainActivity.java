package com.madhavamish.texts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button change;
    TextView label;
    EditText input;
    Button mood_change;
    TextView mood;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change = findViewById(R.id.button1);
        mood_change = findViewById(R.id.mood_change);
        mood = findViewById(R.id.mood);
        label = findViewById(R.id.text);
        input = findViewById(R.id.input);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable s = input.getText();
                label.setText(s);
            }
        });

        mood_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                String[] emotions = res.getStringArray(R.array.moods);
                mood.setText(emotions[counter]);
                counter++;
                if(counter >= emotions.length){
                    counter = 0;
                }
            }
        });
    }
}
