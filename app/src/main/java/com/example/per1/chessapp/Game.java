package com.example.per1.chessapp;

import java.util.Scanner;
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


    //ADD USER INPUT!
    public static void main(String[] args)
    {
        Board board = new Board();
        String winner = "Stalemate";
        Scanner in = new Scanner(System.in);
        //Game.test();
        int turns = 0;
        boolean gameInSession = true;
        while(gameInSession){
            if(turns % 2 == 0){ //white turns
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
                                if(turns<8)
                                System.out.println(p.getName()+"  " + p.getTeam() +": " + list.toString());
                            }

                        }
                    }
                }
                if(!done){winner = "player2"; gameInSession = false;}
                //Player 1 takes turn
                else { //Currently only text based!
                    boolean turnOver = false;
                    while(!turnOver) {
                        System.out.print("Please Select Piece: ");
                        int a = in.nextInt();
                        Space s = Board.convertSpace(a);
                        //check to see if piece selected is of same team
                        if (board.pieceAt(s.getX(), s.getY()) != null &&
                        board.pieceAt(s.getX(), s.getY()).equalsIgnoreCase("white")){
                            Piece p = board.thePiece(s.getY(),s.getX());
                            ArrayList<Space> moves = p.canMove(board);
                            p.removeChecks(moves, board);
                            System.out.println(moves); // cool thing
                            if(moves.size() == 0){
                                System.out.println("Error: " + p.getName()+" has no legal moves");
                            }
                            else{
                                System.out.print("Please Select Space: ");
                                int c = in.nextInt();
                                Space sp = Board.convertSpace(c);
                                System.out.println(sp); // cool thing
                                for (int i = 0; i < moves.size(); i++) {
                                    System.out.println(moves.get(i)); // cool thing
                                    if (sp.equals(moves.get(i))) {
                                        turnOver = true;
                                        p.move(sp.getX(), sp.getY(), board);
                                        break;
                                    }
                                }
                                if (!turnOver) {
                                    System.out.println("Error: " + p.getName() + " cannot move there");
                                }
                            }
                        }
                        else if(board.pieceAt(s.getX(), s.getY()) == null){
                            System.out.println("Error: That space does not contain a piece");
                        }
                        else{
                            System.out.println("Error: It's white's turn");
                        }
                    }
                }
                //Select piece, select space. If can't move piece to space, say so + repeat choice.
            }
            else{ //black turns
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
                                if(turns<8)
                                System.out.println(p.getName() + "  " + p.getTeam() + ": " + list.toString());
                            }

                        }
                    }
                }
                if(!done){winner = "Player 1"; gameInSession = false;}
                //Player 2 takes turn
                else { //Currently only text based!
                    boolean turnOver = false;
                    while(!turnOver) {
                        System.out.print("Please Select Piece: ");
                        int a = in.nextInt();
                        Space s = Board.convertSpace(a);
                        //check to see if piece selected is of same team
                        if (board.pieceAt(s.getX(), s.getY()) != null &&
                                board.pieceAt(s.getX(), s.getY()).equalsIgnoreCase("black")){
                            Piece p = board.thePiece(s.getY(),s.getX());
                            ArrayList<Space> moves = p.canMove(board);
                            p.removeChecks(moves, board);
                            if(moves.size() == 0){
                                System.out.println("Error: " + p.getName()+" has no legal moves");
                            }
                            else{
                                System.out.print("Please Select Space: ");
                                int c = in.nextInt();
                                Space sp = Board.convertSpace(c);
                                for (int i = 0; i < moves.size(); i++) {
                                    if (sp.equals(moves.get(i))) {
                                        turnOver = true;
                                        p.move(sp.getX(), sp.getY(), board);
                                        break;
                                    }
                                }
                                if (!turnOver)
                                    System.out.println("Error: " + p.getName() + " cannot move there");
                            }
                        }
                        else if(board.pieceAt(s.getX(), s.getY()) == null){
                            System.out.println("Error: That space does not contain a piece");
                        }
                        else{
                            System.out.println("Error: It's black's turn");
                        }
                    }
                }
                //Select piece, select space. If can't move piece to space, say so + repeat choice.
            }
            turns++;
        }
        Game.endGame(winner);
    }
}
