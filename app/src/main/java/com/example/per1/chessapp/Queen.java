package com.example.per1.chessapp;
import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */


public class Queen extends Piece
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class Queen
     */
    public Queen(boolean isWhite)
    {
        this.setTeam(isWhite);
        this.setName("Queen");
    }


    public ArrayList<Space> canMove(Board b)
    {
        ArrayList<Space> moves = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();
        boolean white = true;

        if(this.getTeam().equals("white")) {
            white = false;
        }

        // IMPLEMENT
        Bishop bi = new Bishop(x,y,white);
        //Rook r = new Rook(x,y,white);

        moves.addAll(bi.canMove(b));
        //moves.addAll(r.canMove(b));

        return moves;
    }

}

