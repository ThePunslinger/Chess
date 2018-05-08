package com.example.per1.chessapp;

import android.util.Log;
import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */


public class Game
{
    // instance variables - replace the example below with your own
    private Piece[][] board = new Piece[8][8];
    int turns = 0;
    boolean gameInSession = true;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        // initialise instance variables

    }


    public static void test() {
        Board testBoard = new Board();
        ArrayList<Space> moves = testBoard.thePiece(7,1).canMove(testBoard);
        int x = moves.get(0).getX(); int y = moves.get(0).getY();
        testBoard.thePiece(1,1).move(x,y,testBoard);
        System.out.println("Yo it worked!");

    }

    public static void main(String[] args)
    {
        Game.test();
        /*// put your code here
        int turns = 0;
        boolean gameInSession = true;
        while(gameInSession){
            if(turns % 2 == 0){
                //Player 1 takes turn
            }
            else{
                //Player 2 takes turn
            }
            turns++;
        }*/
    }
}
