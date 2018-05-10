package com.example.per1.chessapp;
import java.util.ArrayList;


public abstract class Piece
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int value;
    boolean white = true;
    String name;


    public Piece move(int newX, int newY, Board b){
        Piece p = b.thePiece(newY, newX);
        b.setPos(newX,newY,this);
        b.setPos(x,y,null);
        x = newX;
        y = newY;
        return p;
    }
    public abstract ArrayList<Space> canMove(Board b);

    public void removeChecks(ArrayList<Space> moves, Board b){
        for(int i = moves.size()-1; i >=0; i --) {
            Board d = new Board(b);
            Space s = moves.get(i);
            d.setPos(s.getX(), s.getY(), this);
            if (d.inCheck(this.getTeam())) {
                moves.remove(i);
            }
        }

    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int val){
         x = val;
    }
    public void setY(int val){
         y = val;
    }

    public int getValue(){
        return value;
    }
    public void setValue(int val){
        value = val;
    }


    public void setTeam(boolean isWhite){
        if(isWhite){
            white = true;
        }
        else{
            white = false;
        }
    }
    public String getTeam(){

        if(white)
            return "white";
        return "black";
    }

}

