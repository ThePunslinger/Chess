package com.example.per1.chessapp;
import java.util.ArrayList;


/**
 * Created by per1 on 4/18/18.
 */

public class King extends Piece
{
    // instance variables - replace the example below with your own
    boolean hasMoved = false;

    /**
     * Constructor for objects of class King
     */
    public King(boolean isWhite)
    {
        int alpha = 0;
        if(!isWhite){
            alpha =6;
        }
        this.setImageIndex(alpha+5);
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
                    if(b.pieceAt(c,r) == null || !this.getTeam().equals(b.pieceAt(c,r))){
                        Space s = new Space(c,r);
                        moves.add(s);
                    }
                }
            }
        }

        //Checks for Castling -- make sure can't castle out of check!
        if(!hasMoved && b.thePiece(this.getY(),5) == null && b.thePiece(this.getY(),6) == null &&
                b.thePiece(this.getY(),7) != null &&  b.thePiece(this.getY(),7).getName().equals("Rook")
                && b.thePiece(this.getY(),7).getTeam().equals(this.getTeam())
                && !((Rook)b.thePiece(this.getY(),7)).hasItMoved()
                ){
            Space s = new Space(6, this.getY());
            moves.add(s);

        }

        if(!hasMoved && b.thePiece(this.getY(),3) == null && b.thePiece(this.getY(),2) == null &&
                b.thePiece(this.getY(),1) != null &&  b.thePiece(this.getY(),0).getName().equals("Rook")
                && b.thePiece(this.getY(),0).getTeam().equals(this.getTeam())
                && !((Rook)b.thePiece(this.getY(),0)).hasItMoved()
                ){
            Space s = new Space(2, this.getY());
            moves.add(s);

        }

        return moves;

    }

    @Override
    public Piece move(int newX, int newY, Board b) {
        if(!hasMoved && (newX == 6 && newY == this.getY())){
            int oldX = this.getX();
            Rook r = (Rook)b.thePiece(this.getY(), 7);
            b.setPos(newX,newY,this);
            b.setPos(oldX+1,this.getY(),r);
            this.setX(newX);
            this.setY(newY);
            hasMoved = true;
            return null;
        }
        else if(!hasMoved && (newX == 2 && newY == this.getY())){
            int oldX = this.getX();
            Rook r = (Rook)b.thePiece(this.getY(), 0);
            b.setPos(newX,newY,this);
            b.setPos(oldX-1,this.getY(),r);
            this.setX(newX);
            this.setY(newY);
            hasMoved = true;
            return null;
        }
        else{
            hasMoved = true;
            return super.move(newX, newY, b);
        }
    }

}
