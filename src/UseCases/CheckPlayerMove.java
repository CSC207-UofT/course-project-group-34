package UseCases;

import Entities.ChessPiece;
import Other.GameState;

public abstract class CheckPlayerMove {
    
    abstract int[][] validMoves(ChessPiece piece, GameState gameState); 
    
    public boolean checkMove(int newRow, int newColumn, ChessPiece piece, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves(piece, gameState);
        
        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }

        return false;
    }
}
