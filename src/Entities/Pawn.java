public class Pawn extends ChessPiece { 
  
  private boolean hasMovedOnce;
  private boolean madeMove;

  public Pawn(int xPosition, int yPosition, String color){
    super(xPosition, yPosition, color );
    this.hasMovedOnce = false;
    this.madeMove = false;
  }
  
  public boolean getHasMovedOnce(){
    return this.hasMovedOnce;
  }
  
  public void setHasMovedOnce(boolean cond){
    this.hasMovedOnce = cond;
  }

  public boolean getMadeMove() {
    return madeMove;
  }

  public void setMadeMoveTrue() {
    madeMove = true;
  }
  
}
