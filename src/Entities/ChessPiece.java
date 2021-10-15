package Entities;

/**
* This abstract class represents the shared atributes and methods
* all other instances of ChessPiece will share. 
*/
public abstract class ChessPiece {

    private int xPosition;
    private int yPosition;
    private String color;
    private char letter;

    // The constructor takes in it's (x, y) co-ordinates and the color
    // of the player representing this object.
    public ChessPiece(int xPosition, int yPosition, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(int num) {
        this.xPosition = num;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(int num) {
        this.yPosition = num;
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

}
