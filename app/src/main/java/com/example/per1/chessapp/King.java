package com.example.per1.chessapp;
import java.util.ArrayList;


/**
 * Created by per1 on 4/18/18.
 */

public class King extends Piece
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class Queen
     */
    public King(boolean isWhite)
    {
        this.setTeam(isWhite);
        this.setName("King");
    }


    public ArrayList<Space> canMove(Board b)
    {
        ArrayList<Space> moves = new ArrayList<Space>();
        for(int r = getY() - 1; r <= getY() + 1; r++){
            for(int c = getX() -1; c <= getX() + 1; c++){
                //not same space
                if(r == getY() && c == getX()){
                }
                // not out of board
                else if(!(c>7) && !(c<0) &&
                        !(r>7) && !(r<0)){
                    if(!this.getTeam().equals(b.pieceAt(c,r))){
                        Space s = new Space(c,r);
                        moves.add(s);
                    }
                }
            }
        }

        for(int i = moves.size()-1; i >=0; i --) {
            Board d = new Board(b);
            Space s = moves.get(i);
            d.setPos(s.getX(), s.getY(), this);
            if (d.inCheck(this.getTeam())) {
                moves.remove(i);
            }
        }

        return moves;
    }

}
