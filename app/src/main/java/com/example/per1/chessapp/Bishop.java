package com.example.per1.chessapp;
import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */


public class Bishop extends Piece
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Bishop
     */


    public Bishop(boolean isWhite)
    {
        this.setSymbol("♗");
        int alpha = 0;
        if(!isWhite){
            alpha =6;
            this.setSymbol("♝");
        }
        this.setImageIndex(alpha+1);
        this.setTeam(isWhite);
        this.setName("Bishop");
        this.setValue(3);
    }

    public Bishop(int x, int y, boolean isWhite)
    {
        int alpha = 0;
        if(!isWhite){
            alpha =6;
        }
        this.setImageIndex(alpha+1);
        this.setX(x);
        this.setY(y);
        this.setTeam(isWhite);
        this.setName("Bishop");
        this.setValue(3);
    }


    public ArrayList<Space> canMove(Board b)
    {
        ArrayList<Space> moves = new ArrayList<Space>();

        for(int x = 1; this.getX()+x < 8 && this.getY()+x < 8; x++){
            if(this.getY()+x <=7 && this.getX()+x <=7) {
                if (b.thePiece(this.getY() + x, this.getX() + x) == null) {
                    Space s = new Space(this.getX() + x, this.getY() + x);
                    moves.add(s);
                } else if (b.thePiece(this.getY() + x, this.getX() + x).getTeam().equals(this.getTeam())) {
                    break;
                } else {
                    Space s = new Space(this.getX() + x, this.getY() + x);
                    moves.add(s);
                    break;
                }
            }
        }

        for(int x = -1; this.getX()+x >=0 && this.getY()+x >=0; x--){
            if(this.getY()+x >=0 && this.getX()-x >=0) {
                if (b.thePiece(this.getY() + x, this.getX() + x) == null) {
                    Space s = new Space(this.getX() + x, this.getY() + x);
                    moves.add(s);
                } else if (b.thePiece(this.getY() + x, this.getX() + x).getTeam().equals(this.getTeam())) {
                    break;
                } else {
                    Space s = new Space(this.getX() + x, this.getY() + x);
                    moves.add(s);
                    break;
                }
            }
        }

        for(int x = 1; this.getX()+x < 8 && this.getY()-x >=0; x++){//check
            if(this.getY()-x >=0 && this.getX()+x <=7) {
                if (b.thePiece(this.getY() - x, this.getX() + x) == null) {
                    Space s = new Space(this.getX() + x, this.getY() - x);
                    moves.add(s);
                } else if (b.thePiece(this.getY() -x, this.getX() + x).getTeam().equals(this.getTeam())) {
                    break;
                } else {
                    Space s = new Space(this.getX() + x, this.getY() - x);
                    moves.add(s);
                    break;
                }
            }
        }

        for(int x = -1; this.getX()+x >=0 && this.getY()-x < 8; x--){
            if(this.getX()+x>=0 && this.getY()-x<=7) {
                if (b.thePiece(this.getY() - x, this.getX() + x) == null) {
                    Space s = new Space(this.getX() + x, this.getY() - x);
                    moves.add(s);
                } else if (b.thePiece(this.getY() - x, this.getX() + x).getTeam().equals(this.getTeam())) {
                    break;
                } else {
                    Space s = new Space(this.getX() + x, this.getY() - x);
                    moves.add(s);
                    break;
                }
            }
        }

        return moves;
    }
}

