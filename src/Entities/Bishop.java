package Entities;

/**
* This class represents a Bishop chess piece object in our chess game. 
*/
public class Bishop extends ChessPiece implements java.io.Serializable {
  
  // The constructor takes in its row and column and the color 
  // of the player representing this object.
  public Bishop(int row, int column, String color){

    super(row, column, color );
    if(color.equals("black")){
      super.setLetter('B');
    }
    else{
      super.setLetter('b');
    }
  }
}
