package UseCases;

import Entities.ChessPiece;
import Other.GameState;

public abstract class CheckPlayerMove {
    
    abstract int[][] validMoves(ChessPiece piece, GameState gameState); 
    
    abstract boolean checkMove(int newRow, int newColumn, ChessPiece piece, GameState gameState);
}
