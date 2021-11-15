package Entities;

/*
* This class represents a Queen chess piece for our chess game.
*/
public class Queen extends ChessPiece  implements java.io.Serializable {
  
  public Queen(int row, int column, String color){
      super(row, column, color );
      if(color.equals("black")){
          super.setLetter('Q');
      }
      else{
          super.setLetter('q');
      }
    }
}
