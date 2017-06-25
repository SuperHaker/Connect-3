package com.example.android.connect3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public void dropIn(View view){

        ImageView token = (ImageView) view;
        token.setTranslationY(-1000f);
        token.setImageResource(R.drawable.yellow);
        token.animate().translationYBy(1000f).rotation(360).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
