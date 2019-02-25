package com.example.colormatch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListener();
    }
    private void addListener(){
        EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event){
                if (actionID == EditorInfo.IME_ACTION_DONE){
                    buttonClick(null);
                    return true;
                }else{
                    return false;
                }
            }
        };
        EditText input = findViewById(R.id.input);
        input.setOnEditorActionListener(listener);
    }
    /**
     * Get text form input and set background to that color
     * @param view
     */
    public void buttonClick(View view){
        EditText input = findViewById(R.id.input);
        String name = input.getText().toString().toUpperCase();
        setColorByName(name);
        hideKeyboardFrom(getApplicationContext(), getCurrentFocus());
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
    public void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
