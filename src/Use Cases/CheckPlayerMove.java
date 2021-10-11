public abstract class CheckPlayerMove {
    
    public CheckPlayerMove() { }
    
    abstract boolean checkMove(int newXPosition, int newYPosition, ChessPiece piece, GameState gameState);
}
