package com.example.per1.chessapp;
import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */



public class Knight extends Piece
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class Knight
     */
    public Knight(boolean isWhite)
    {
        this.setTeam(isWhite);
        this.setName("Knight");
        this.setValue(3);
    }

    public Knight(int x, int y, boolean isWhite)
    {
        this.setX(x);
        this.setY(y);
        this.setTeam(isWhite);
        this.setName("Knight");
        this.setValue(3);
    }


    public ArrayList<Space> canMove(Board b)
    {
        // put your code here
        int x = this.getX();
        int y = this.getY();
        ArrayList<Space> moves = new ArrayList<>();
        for(int i = 2; i>=-2; i--){
            if(i != 0){
                if(x+3-Math.abs(i)<=7 && y+i>=0 && y+i<=7  &&
                        b.pieceAt(x+3-Math.abs(i),y+i) == null){
                    Space s = new Space(x+3-Math.abs(i),y+i);
                    moves.add(s);
                }
                else if(x+3-Math.abs(i)<=7 && y+i>=0 && y+i<=7
                        && !b.pieceAt(x+3-Math.abs(i),y+i).equals(this.getTeam())){
                    Space s = new Space(x+3-Math.abs(i),y+i);
                    moves.add(s);
                }
                if(x-3+Math.abs(i)>= 0 && y+i>=0 && y+i<=7  &&
                        b.pieceAt(x-3+Math.abs(i),y+i) == null){
                    Space s = new Space(x-3+Math.abs(i),y+i);
                    moves.add(s);
                }
                else if( x-3+Math.abs(i)>= 0 && y+i>=0 && y+i<=7
                        && !b.pieceAt(x+Math.abs(i)-3,y+i).equals(this.getTeam())){
                    Space s = new Space(x-3+Math.abs(i),y+i);
                    moves.add(s);
                }
            }
        }

        return moves;
    }
    //p
}

