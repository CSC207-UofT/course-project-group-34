package Entities;

/**
* This abstract class represents the shared attributes and methods
* all other instances of ChessPiece will share. 
*/
public abstract class ChessPiece implements java.io.Serializable {

    private static final long serialVersionUID = 602355574925137630L;

    private int row;
    private int column;
    private String color;
    private char letter;
    private boolean hasMovedOnce;

    // The constructor takes in its row and column and the color
    // of the player representing this object.
    public ChessPiece(int row, int column, String color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int num) {
        this.row = num;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int num) {
        this.column = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLetter(char letter){
        this.letter = letter;
    }

    public char getLetter(){
        return this.letter;
    }

    public boolean getHasMovedOnce() {
        return this.hasMovedOnce;
    }
  
    public void setHasMovedOnce(){
        this.hasMovedOnce = true;
    }

}
