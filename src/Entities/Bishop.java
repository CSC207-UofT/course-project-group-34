/**
* This class represents a Bishop chess piece object in our chess game. 
*/
public class Bishop extends ChessPiece {
  
  // The constructor takes in it's (x, y) co-ordinates and the color 
  // of the player representing this object.
  public Bishop(int xPosition, int yPosition, String color){

    super(xPosition, yPosition, color );
    if(color.equals("black")){
      super.setLetter('B');
    }
    else{
      super.setLetter('b');
    }
  };
}
