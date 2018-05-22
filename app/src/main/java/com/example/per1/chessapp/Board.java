package com.example.per1.chessapp;
import java.util.ArrayList;

/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    private Piece[][] board = new Piece[8][8];
    int blackKingXPos =4;
    int blackKingYPos=0;
    int whiteKingXPos=4;
    int whiteKingYPos=7;
    String lastMove = "Welcome";

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        // initialise instance variables
        Rook bRook1 = new Rook(false);
        Rook bRook2 = new Rook(false);
        Knight bKnight1 = new Knight(false);
        Knight bKnight2 = new Knight(false);
        Bishop bBishop1 = new Bishop(false);
        Bishop bBishop2 = new Bishop(false);
        Queen bQueen = new Queen(false);
        King bKing = new King(false);
        Pawn bPawn1 = new Pawn(false);
        Pawn bPawn2 = new Pawn(false);
        Pawn bPawn3 = new Pawn(false);
        Pawn bPawn4 = new Pawn(false);
        Pawn bPawn5 = new Pawn(false);
        Pawn bPawn6 = new Pawn(false);
        Pawn bPawn7 = new Pawn(false);
        Pawn bPawn8 = new Pawn(false);

        Piece[] blackPieces = {bRook1, bKnight1, bBishop1, bQueen, bKing, bBishop2, bKnight2, bRook2,
                                bPawn1, bPawn2, bPawn3, bPawn4, bPawn5, bPawn6, bPawn7, bPawn8};
        for(int c=0; c < 8; c ++) {
            board[0][c]=blackPieces[c];
            blackPieces[c].setX(c);
            blackPieces[c].setY(0);
        }
        for(int c=0; c < 8; c ++) {
            board[1][c]=blackPieces[c+8];
            blackPieces[c].setX(c);
            blackPieces[c].setY(1);
        }

        Rook wRook1 = new Rook(true);
        Rook wRook2 = new Rook(true);
        Knight wKnight1 = new Knight(true);
        Knight wKnight2 = new Knight(true);
        Bishop wBishop1 = new Bishop(true);
        Bishop wBishop2 = new Bishop(true);
        Queen wQueen = new Queen(true);
        King wKing = new King(true);
        Pawn wPawn1 = new Pawn(true);
        Pawn wPawn2 = new Pawn(true);
        Pawn wPawn3 = new Pawn(true);
        Pawn wPawn4 = new Pawn(true);
        Pawn wPawn5 = new Pawn(true);
        Pawn wPawn6 = new Pawn(true);
        Pawn wPawn7 = new Pawn(true);
        Pawn wPawn8 = new Pawn(true);

        Piece[] whitePieces = {wRook1, wKnight1, wBishop1, wQueen, wKing, wBishop2, wKnight2, wRook2,
                wPawn1, wPawn2, wPawn3, wPawn4, wPawn5, wPawn6, wPawn7, wPawn8};
        for(int c=0; c < 8; c ++) {
            board[7][c]=whitePieces[c];
            whitePieces[c].setX(c);
            whitePieces[c].setY(7);
        }
        for(int c=0; c < 8; c ++) {
            board[6][c]=whitePieces[c+8];
            whitePieces[c+8].setX(c);
            whitePieces[c+8].setY(6);
        }

    }

    public Board(Board b)
    {
        Space[] kingSpaces = b.kingInfo();
        blackKingXPos = kingSpaces[1].getX(); blackKingYPos = kingSpaces[1].getY();;
        whiteKingXPos = kingSpaces[0].getX(); whiteKingYPos = kingSpaces[0].getY();
        for(int r = 0; r <8; r++){
            for(int c = 0; c<8; c ++) {
                board[r][c] = b.thePiece(r,c);
            }
        }
    }



    public void setPos(int x, int y, Piece p){
        board[y][x] = p;
        if(p!= null && p.getName().equals("King")){
            if(p.getTeam().equals("white")){
                whiteKingXPos=x;
                whiteKingYPos=y;
            }
            else{
                blackKingXPos=x;
                blackKingYPos=y;
            }
        }
    }

    public String pieceAt(int x, int y){
        Piece p = board[y][x];
        if(p == null){
            return null;
        }
        return p.getTeam();
    }

    public Piece thePiece(int r, int c){
        Piece p = board[r][c];
        return p;
    }

    public Space[] kingInfo(){
        Space[] spaces = new Space[2];
        spaces[1]= new Space(blackKingXPos, blackKingYPos);
        spaces[0] = new Space(whiteKingXPos,whiteKingYPos);
        return spaces;
    }

    public void setLastMove(Piece p, Space old, Space next){
        lastMove = p.getName() + ": " + old.toString() + " to " + next.toString();
    }

    public String getLastMove(){
        return lastMove;
    }

    public static Space convertSpace(int num){
        int x = num%8;
        int y = num/8;
        Space s = new Space(x,y);
        return s;
    }

    //DEFINITELY too much time!
    public boolean inCheck(String team){
        if(team.equals("white")){
            for(int r = 0; r <8; r ++){
                for(int c = 0; c < 8; c++){
                    Piece p = board[r][c];
                    if(p!=null&&p.getTeam().equals("black")){
                        ArrayList<Space> s = p.canMove(this);
                        for(int i = 0; i < s.size(); i++){
                            if(s.get(i).getX() == whiteKingXPos &&
                                    s.get(i).getY() == whiteKingYPos){
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        else{
            for(int r = 0; r <8; r ++){
                for(int c = 0; c < 8; c++){
                    Piece p = board[r][c];
                    if(p!=null && p.getTeam().equals("white")){
                        ArrayList<Space> s = p.canMove(this);
                        for(int i = 0; i < s.size(); i++){
                            if(s.get(i).getX() == blackKingXPos &&
                                    s.get(i).getY() == blackKingYPos){
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

}
