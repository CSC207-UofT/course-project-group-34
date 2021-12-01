package Entities;

/*
* This class represents a Pawn chess piece for our chess game.
*/
public class Pawn extends ChessPiece  implements java.io.Serializable {
  
  private boolean hasMovedOnce;

  public Pawn(int row, int column, String color) {
    super(row, column, color);
    this.hasMovedOnce = false;
    if(color.equals("black")){
      super.setLetter('P');
    }
    else{
      super.setLetter('p');
    }
  }

}
