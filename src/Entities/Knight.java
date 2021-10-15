package Entities;

/*
* This class represents a Knight chess piece for our chess game. 
*/
public class Knight extends ChessPiece {

  public Knight(int xPosition, int yPosition, String color){

    super(xPosition, yPosition, color);
    if(color.equals("black")){
      super.setLetter('K');
    }
    else{
      super.setLetter('k');
    }
  }
}
