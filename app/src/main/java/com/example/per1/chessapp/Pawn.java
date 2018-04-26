package com.example.per1.chessapp;
import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */

public class Pawn extends Piece
{
    // instance variables - replace the example below with your own


    public Pawn(boolean isWhite)
    {
        this.setTeam(isWhite);
        this.setName("Pawn");
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
        if(b.pieceAt(x,y+mod).equals("")){
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

    public void move(int newX, int newY, Board b){
        super.move(newX, newY, b);
        if(this.getTeam().equals("black") && newY == 7){
            Queen q = new Queen(false);
            b.setPos(newX,newY, q);
        }
        if(this.getTeam().equals("white") && newY == 0){
            Queen q = new Queen(true);
            b.setPos(newX,newY, q);
        }
    }
}

