package com.example.per1.chessapp;

import android.util.Log;
import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */


public class Game
{
    // instance variables - replace the example below with your own
    private Board board = new Board();
    int turns = 0;
    int whiteScore = 0;
    int blackScore = 0;
    boolean gameInSession = true;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        // initialize instance variables

    }


    public static void test() {
        Board testBoard = new Board();
        ArrayList<Space> moves = testBoard.thePiece(7,1).canMove(testBoard);
        int x = moves.get(0).getX(); int y = moves.get(0).getY();
        testBoard.thePiece(1,1).move(x,y,testBoard);
        System.out.println("Yo it worked!");

    }

    public static void endGame(String winner){
        System.out.println("CHECKMATE!");
        System.out.println(winner + " Wins!");//change this.
        System.out.println("Turns: ");
    }

    public static void main(String[] args)
    {
        Board board = new Board();
        //Game.test();
        int turns = 0;
        boolean gameInSession = true;
        while(gameInSession){
            if(turns % 2 == 0){
                //check if checkmate
                boolean done = false;
                for(int x = 7; x >= 0 && !done; x --){
                    for(int y = 7; y >= 0 && !done; y --){
                        Piece p = board.thePiece(y,x);
                        if(p != null && p.getTeam().equalsIgnoreCase("white")){
                            //ADDED
                            ArrayList<Space> list = p.canMove(board);
                            p.removeChecks(list,board);
                            if(list.size() > 0){
                                done = true;
                            }
                        }
                    }
                }
                if(!done){Game.endGame("Player 2");}
                //Player 1 takes turn
                if(turns == 0){board.thePiece(6,5).move(5, 4, board);}
                if(turns == 2){board.thePiece(6,6).move(6,4, board);}
                //Select piece, select space. If can't move piece to space, say so + repeat choice.
            }
            else{
                //check if checkmate
                boolean done = false;
                for(int x = 7; x >= 0 && !done; x --){
                    for(int y = 7; y >= 0 && !done; y --){
                        Piece p = board.thePiece(y,x);
                        if(p != null && p.getTeam().equalsIgnoreCase("black")){
                            //Added
                            ArrayList<Space> list = p.canMove(board);
                            p.removeChecks(list,board);
                            if(list.size() > 0){
                                done = true;
                            }
                        }
                    }
                }
                if(!done){Game.endGame("Player 1");}
                //Player 2 takes turn
                if(turns == 1){board.thePiece(1,4).move(4, 2, board);}
                if(turns == 3){board.thePiece(0, 3).move(7,4,board);}
                //Select piece, select space. If can't move piece to space, say so + repeat choice.
            }
            turns++;
        }
    }
}
