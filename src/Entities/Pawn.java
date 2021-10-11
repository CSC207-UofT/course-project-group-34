public class Pawn extends ChessPiece { 
  
  private boolean hasMovedOnce;

  public Pawn(int xPosition, int yPosition, String color){
    super(xPosition, yPosition, color );
    this.hasMovedOnce = false;
  };
  
  public boolean getHasMovedOnce(){
    return this.hasMovedOnce;
  }
  
  public void setHasMovedOnce(bool cond){
    this.hasMovedOnce = cond;
  }
  
}
