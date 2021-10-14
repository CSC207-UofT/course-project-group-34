public class Bishop extends ChessPiece {
  
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
