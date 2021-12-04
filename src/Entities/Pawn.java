package Entities;

/*
* This class represents a Pawn chess piece for our chess game.
*/
public class Pawn extends ChessPiece  implements java.io.Serializable {

  public Pawn(int row, int column, String color) {
    super(row, column, color);
    if(color.equals("black")){
      super.setLetter('P');
    }
    else{
      super.setLetter('p');
    }
  }

}
