package com.example.per1.chessapp;
import java.util.ArrayList;


public abstract class Piece
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    boolean white = true; //POSSIBLE ERROR--WILL IT COUNT
    //EMPTY AS WHITE???
    String name;


    public void move(int newX, int newY, Board b){
        b.setPos(newX,newY,this);
        b.setPos(x,y,null);
        x = newX;
        y = newY;
    }
    public abstract ArrayList<Space> canMove(Board b);

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

