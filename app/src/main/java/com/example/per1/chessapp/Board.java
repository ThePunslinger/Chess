package com.example.per1.chessapp;
import java.util.ArrayList;

/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    private Piece[][] board = new Piece[8][8];
    int blackKingXPos =4;
    int blackKingYPos=0;
    int whiteKingXPos=4;
    int whiteKingYPos=7;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        // initialise instance variables

    }

    public Board(Board b)
    {
        for(int r = 0; r <8; r++){
            for(int c = 0; c<8; c ++) {
                board[r][c] = b.thePiece(r,c);
            }
        }
    }



    public void setPos(int x, int y, Piece p){
        board[y][x] = p;
        if(p.getName().equals("King")){
            if(p.getTeam().equals("white")){
                whiteKingXPos=x;
                whiteKingYPos=y;
            }
            else{
                blackKingXPos=x;
                blackKingYPos=y;
            }
        }
    }

    public String pieceAt(int x, int y){
        Piece p = board[y][x];
        if(p == null){
            return "";
        }
        return p.getTeam();
    }

    public Piece thePiece(int r, int c){
        Piece p = board[r][c];
        return p;
    }

    //possibly too much time!
    public boolean inCheck(String team){
        if(team.equals("white")){
            for(int r = 0; r <8; r ++){
                for(int c = 0; c < 8; c++){
                    Piece p = board[r][c];
                    if(p.getTeam().equals("black")){
                        ArrayList<Space> s = p.canMove(this);
                        for(int i = 0; i < s.size(); i++){
                            if(s.get(i).getX() == whiteKingXPos &&
                                    s.get(i).getY() == whiteKingYPos){
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        else{
            for(int r = 0; r <8; r ++){
                for(int c = 0; c < 8; c++){
                    Piece p = board[r][c];
                    if(p.getTeam().equals("white")){
                        ArrayList<Space> s = p.canMove(this);
                        for(int i = 0; i < s.size(); i++){
                            if(s.get(i).getX() == blackKingXPos &&
                                    s.get(i).getY() == blackKingYPos){
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

}
