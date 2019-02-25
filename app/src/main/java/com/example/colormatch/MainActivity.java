package com.example.colormatch;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Get text form input and set background to that color
     * @param view
     */
    public void buttonClick(View view){
        EditText input = findViewById(R.id.input);
        String name = input.getText().toString().toUpperCase();
        setColorByName(name);
    }
    private void setColorByName(String c){
        TextView display = findViewById(R.id.output);
        int colorID = getResources().getIdentifier(c,"color",this.getPackageName());
        if (colorID != 0) {
            int color = ContextCompat.getColor(this, colorID);
            display.setBackgroundColor(color);
        }else{
            Toast.makeText(this,"Your color is wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
