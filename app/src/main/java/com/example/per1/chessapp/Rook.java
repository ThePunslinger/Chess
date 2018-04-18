package com.example.per1.chessapp;

import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */

public class Rook extends Piece {
    /**
     * Constructor for objects of class Bishop
     */


    public Rook(boolean isWhite)
    {
        this.setTeam(isWhite);
        this.setName("Rook");
    }

    public Rook(int x, int y, boolean isWhite)
    {
        this.setX(x);
        this.setY(y);
        this.setTeam(isWhite);
        this.setName("Rook");
    }


    public ArrayList<Space> canMove(Board b)
    {
        ArrayList<Space> moves = new ArrayList<Space>();

        for(int mod = -1; mod <= 1; mod +=2){
            for(int mod2 = -1; mod2 < 1; mod2 +=2){
                for(int i = mod; i + getX()< 8 && i + getX() >= 0
                        && i + getY() < 8 && i + getY()>=0; i+=mod){
                    if(b.pieceAt(i+getX(),mod2*i+getY()).equals(null)){
                        Space s = new Space(i+getX(),i+getY());
                        moves.add(s);
                    }
                    else if (b.pieceAt(i+getX(),mod2*i+getY()).equals(this.getTeam())){
                        break;
                    }
                    else{
                        Space s = new Space(i+getX(),mod2*i+getY());
                        moves.add(s);
                        break;
                    }
                }
            }
        }
        return moves;
    }
}
