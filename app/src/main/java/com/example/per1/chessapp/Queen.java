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
        this.setValue(9);
    }


    public ArrayList<Space> canMove(Board b)
    {
        ArrayList<Space> moves = new ArrayList<>();
        boolean white = true;

        if(this.getTeam().equals("white")) {
            white = false;
        }

        /* IMPLEMENT
        Bishop bi = new Bishop(x,y,white);
        Rook r = new Rook(x,y,white);

        moves.addAll(bi.canMove(b));
        moves.addAll(r.canMove(b));

        return moves;*/
        for(int x = 1; this.getX()+x < 8 && this.getY()+x < 8; x++){
            if(b.thePiece(this.getY()+x,this.getX() + x) == null){
                Space s = new Space(this.getX()+x,this.getY() + x);
                moves.add(s);
            }
            else if(b.thePiece(this.getY()+x,this.getX() + x).getTeam().equals(this.getTeam())){
                break;
            }
            else{
                Space s = new Space(this.getX()+x,this.getY() + x);
                moves.add(s);
                break;
            }
        }

        for(int x = -1; this.getX()+x >=0 && this.getY()+x >=0; x--){
            if(b.thePiece(this.getY()+x,this.getX() + x) == null){
                Space s = new Space(this.getX()+x,this.getY() + x);
                moves.add(s);
            }
            else if(b.thePiece(this.getY()+x,this.getX() + x).getTeam().equals(this.getTeam())){
                break;
            }
            else{
                Space s = new Space(this.getX()+x,this.getY() + x);
                moves.add(s);
                break;
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

        for(int mod = 1; mod >= -1; mod -=2) {
            for (int y = this.getY() + mod; y <= 7 && y>=0; y+=mod) {
                if (b.pieceAt(this.getX(), y) == null) {
                    moves.add(new Space(this.getX(), y));
                }
                else if (b.pieceAt(this.getX(), y).equals(this.getTeam())) {
                    break;
                }
                else {
                    moves.add(new Space(this.getX(), y));
                    break;
                }
            }

        }

        for(int mod = 1; mod >= -1; mod -=2) {
            for (int x = this.getX() + mod; x <= 7 && x>=0; x+=mod) {
                if (b.pieceAt(x, this.getY()) == null) {
                    moves.add(new Space(x, this.getY()));
                }
                else if (b.pieceAt(x, this.getY()).equals(this.getTeam())) {
                    break;
                }
                else {
                    moves.add(new Space(x, this.getY()));
                    break;
                }
            }
        }

        return moves;
    }

}

