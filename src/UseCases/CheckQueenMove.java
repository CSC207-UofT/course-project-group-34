package UseCases; 

import Entities.Queen;
import Entities.ChessPiece; 
import Other.GameState; 

import java.util.ArrayList; 

public class CheckQueenMove extends CheckPlayerMove {

    public checkQueenMove() { } 
    
    public int[][] validMoves(Queen queen, GameState gameState) { 
        ArrayList result = new ArrayList(); 
        int row = queen.getRow(); 
        int column = queen.getColumn(); 
        ChessPiece[][] board = gameState.getBoard(); 
        
        // Moving up
        int currentRow = row - 1; 
    }
  
}
