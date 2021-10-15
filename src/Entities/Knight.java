package Entities;

/*
* This class represents a Knight chess piece for our chess game. 
*/
public class Knight extends ChessPiece {

  public Knight(int row, int column, String color){

    super(row, column, color);
    if(color.equals("black")){
      super.setLetter('K');
    }
    else{
      super.setLetter('k');
    }
  }
}
