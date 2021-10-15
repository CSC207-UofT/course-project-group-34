package Entities;

/**
* This class represents a Rook chess piece for our chess game.
*/
public class Rook extends ChessPiece {

  public Rook(int row, int column, String color) {
    super(row, column, color);
    
    if(color.equals("black")){
      super.setLetter('R');
    }
    else{
      super.setLetter('r');
    }
  } 
}
