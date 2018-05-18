package com.example.per1.chessapp;


/**
 * Write a description of class Space here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Space
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Space
     */
    public Space(int x, int y)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return
                "x=" + x +
                ", y=" + y + ";";
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}

