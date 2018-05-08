package com.example.per1.chessapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridBoard = (GridLayout) findViewById(R.id.grid_board);

        ViewTreeObserver viewTreeObserver = gridBoard.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    gridBoard.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int viewHeight = gridBoard.getHeight();
                    int viewWidth = gridBoard.getWidth();

                    int i=0;
                    for(int row=0; row<8; row++)
                    {

                        for(int col=0; col<8; col++)
                        {
                            ImageView image = new ImageView(MainActivity.this);

                            if(row%2!=0) {
                                if (i % 2 == 0)
                                    image.setBackgroundColor(Color.BLACK);
                                else
                                    image.setBackgroundColor(Color.WHITE);
                                image.setMinimumWidth(viewWidth / 8);
                                image.setMinimumHeight(viewHeight / 8);
                                gridBoard.addView(image, i);

                                i++;
                            }
                            else
                            {
                                if (i % 2 == 0)
                                    image.setBackgroundColor(Color.WHITE);
                                else
                                    image.setBackgroundColor(Color.BLACK);
                                image.setMinimumWidth(viewWidth / 8);
                                image.setMinimumHeight(viewHeight / 8);
                                gridBoard.addView(image, i);

                                i++;
                            }
                        }
                    }

                }
            });
        }



    }
}
//HI