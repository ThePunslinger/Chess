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
        this.setTeam(isWhite);
        this.setName("Bishop");
    }

    public Bishop(int x, int y, boolean isWhite)
    {
        this.setX(x);
        this.setY(y);
        this.setTeam(isWhite);
        this.setName("Bishop");
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

