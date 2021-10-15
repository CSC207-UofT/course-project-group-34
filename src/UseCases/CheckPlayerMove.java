package UseCases;

import Entities.ChessPiece;
import Other.GameState;

public abstract class CheckPlayerMove {
    
    public CheckPlayerMove() { }
    
    abstract boolean checkMove(int newRow, int newColumn, ChessPiece piece, GameState gameState);
}
