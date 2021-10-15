package Entities;

/**
* This class represents a Rook chess piece for our chess game.
*/
public class Rook extends ChessPiece {

  public Rook(int xPosition, int yPosition, String color){

    super(xPosition, yPosition, color );
    if(color.equals("black")){
      super.setLetter('R');
    }
    else{
      super.setLetter('r');
    }
  } 
}
