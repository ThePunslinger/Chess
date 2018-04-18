package com.example.per1.chessapp;

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


    public static void main(String[] args)
    {
        // put your code here
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
        }
    }
}
