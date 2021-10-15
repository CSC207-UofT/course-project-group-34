package UseCases;

import Entities.ChessPiece;
import Other.GameState;

public abstract class CheckPlayerMove {
    
    public CheckPlayerMove() { }
    
    abstract boolean checkMove(int newXPosition, int newYPosition, ChessPiece piece, GameState gameState);
}
