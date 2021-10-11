public class Pawn extends ChessPiece { 
  
  private bool hasMovedOnce;

  public Pawn(int xPosition, int yPosition, String color){
    super(xPosition, yPosition, color );
    this.hasMovedOnce = false;
  };
  
  public bool getHasMovedOnce(){
    return this.hasMovedOnce;
  }
  
  public void setHasMovedOnce(bool cond){
    this.hasMovedOnce = cond;
  }
  
}
