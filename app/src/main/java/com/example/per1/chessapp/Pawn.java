package com.example.per1.chessapp;
import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */

public class Pawn extends Piece
{
    // instance variables - replace the example below with your own
    boolean firstMove = true;

    public Pawn(boolean isWhite)
    {
        this.setTeam(isWhite);
        this.setName("Pawn");
        this.setValue(1);
    }



    public ArrayList<Space> canMove(Board b)
    {
        // put your code here
        ArrayList<Space> moves = new ArrayList<Space>();
        int x = this.getX();
        int y = this.getY();
        int mod = -1;
        if(this.getTeam().equals("black")){
            mod = 1;
        }

        if(firstMove) {
            Space s = new Space(x, (int)(3.9-mod*0.2));
            //makes 3 for black, 4 for white
            if(b.thePiece(s.getY(),s.getX()) == null){
                moves.add(s);
            }
        }

        if(b.thePiece(y+mod,x) == null){
            Space s = new Space(x, y+ mod);
            moves.add(s);
        }
        if(x>0 && !b.pieceAt(x-1,y+mod ).equals(this.getTeam())
                && !b.pieceAt(x-1,y+mod).equals("")){
            Space s = new Space(x-1, y+ mod);
            moves.add(s);
        }
        if(x<7 && !b.pieceAt(x+1,y+mod ).equals(this.getTeam())
                && !b.pieceAt(x+1,y+mod).equals("")){
            Space s = new Space(x+1, y+ mod);
            moves.add(s);
        }

        return moves;
    }

    public Piece move(int newX, int newY, Board b){
        Piece p =super.move(newX, newY, b);
        firstMove = false;
        if(this.getTeam().equals("black") && newY == 7){
            Queen q = new Queen(false);
            b.setPos(newX,newY, q);
        }
        if(this.getTeam().equals("white") && newY == 0){
            Queen q = new Queen(true);
            b.setPos(newX,newY, q);
        }
        return p;
    }
}

