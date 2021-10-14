public class Queen extends ChessPiece {
  
  public Queen(int xPosition, int yPosition, String color){
      super(xPosition, yPosition, color );
      if(color.equals("black")){
          super.setLetter('Q');
      }
      else{
          super.setLetter('q');
      }
    }
}
