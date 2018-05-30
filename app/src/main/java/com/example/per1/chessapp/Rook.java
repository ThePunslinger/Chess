package com.example.per1.chessapp;

import java.util.ArrayList;

/**
 * Created by per1 on 4/18/18.
 */

public class Rook extends Piece {

    boolean hasMoved = false;


    public Rook(boolean isWhite)
    {
        this.setSymbol("♖");
        int alpha = 0;
        if(!isWhite){
            alpha =6;
            this.setSymbol("♜");
        }
        this.setImageIndex(alpha+3);
        this.setTeam(isWhite);
        this.setName("Rook");
        this.setValue(5);
    }

    public Rook(int x, int y, boolean isWhite)
    {
        int alpha = 0;
        if(!isWhite){
            alpha =6;
        }
        this.setImageIndex(alpha+3);
        this.setX(x);
        this.setY(y);
        this.setTeam(isWhite);
        this.setName("Rook");
        this.setValue(5);
    }


    public ArrayList<Space> canMove(Board b)
    {
        ArrayList<Space> moves = new ArrayList<>();


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

    @Override
    public Piece move(int newX, int newY, Board b) {
        hasMoved = true;
        return super.move(newX, newY, b);
    }

    public boolean hasItMoved(){
        return hasMoved;
    }
}
