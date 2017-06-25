package com.example.android.connect3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View layout;
    boolean gameActive = true;
    int activePlayer = 0;
    int[] gameStates = {2,2,2,2,2,2,2,2,2};
    int[][] winningPos = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn(View view) {

        ImageView token = (ImageView) view;
        int tappedToken = Integer.parseInt(token.getTag().toString());

        if (gameStates[tappedToken] == 2 && gameActive) {
            token.setTranslationY(-1000f);
            gameStates[tappedToken] = activePlayer;
            if (activePlayer == 0) {
                token.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                token.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            token.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for(int[] winning : winningPos){
                if(gameStates[winning[0]] == gameStates[winning[1]] && gameStates[winning[1]] == gameStates[winning[2]]
                        && gameStates[winning[0]] != 2){
                    String winner = "Red";
                    if(gameStates[winning[0]] == 0){
                        winner = "Yellow";
                    }
                    layout = findViewById(R.id.play_again_layout);
                    TextView tv = (TextView) findViewById(R.id.winner);
                    tv.setText(winner + " has won!");
                    gameActive = false;
                    layout.setVisibility(View.VISIBLE);

                }
                else{
                    boolean gameOver = true;
                    for(int counterStates : gameStates) {
                        if (counterStates == 2) gameOver = false;
                    }
                        if(gameOver){
                            TextView tv = (TextView) findViewById(R.id.winner);
                            tv.setText("Draw occured");
                            gameActive = false;
                            layout = findViewById(R.id.play_again_layout);
                            layout.setVisibility(View.VISIBLE);
                        }

                }
            }

        }
    }

    public void playAgain(View view){
        layout = findViewById(R.id.play_again_layout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        gameActive = true;
        for(int i=0; i<gameStates.length;i++){
            gameStates[i] = 2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);
        for(int i=0; i<gridLayout.getChildCount(); i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
