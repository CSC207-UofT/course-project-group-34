package UseCases; 

import Entities.Rook;
import Entities.ChessPiece; 
import Other.GameState; 

import java.util.ArrayList; 
import java.util.Arrays;

public class CheckRookMove extends CheckPlayerMove {

    public CheckRookMove() { } 
    
    public int[][] validMoves(Rook rook, GameState gameState) { 
        ArrayList result = new ArrayList(); 
        int row = rook.getRow(); 
        int column = rook.getColumn(); 
        ChessPiece[][] board = gameState.getBoard(); 
        
        // Moving up
        int currentRow = row - 1; 
        while (currentRow > -1 && board[currentRow][column] == null) {
            result.add({currentRow, column}); 
            currentRow--;
        }

        if (currentRow > -1) { 
            result.add({currentRow, column}); 
        }

        // Moving right
        int currentColumn = column + 1;
        while (currentColumn < 8 && board[row][currentColumn] == null) {
            result.add({row, currentColumn});
            currentColumn++;
        }

        if (currentColumn < 8) { 
            result.add({row, currentColumn});
        }

        // Moving down
        int currentRow = row + 1; 
        while (currentRow < 8 && board[currentRow][column] == null) {
            result.add({currentRow, column}); 
            currentRow++;
        }

        if (currentRow < 8) { 
            result.add({currentRow, column}); 
        }

        // Moving left
        int currentColumn = column - 1;
        while (currentColumn > -1 && board[row][currentColumn] == null) {
            result.add({row, currentColumn});
            currentColumn--; 
        }

        if (currentColumn > -1) {
            result.add({row, currentColumn});
        }

        int[][] final = result.toArray(); 
        return final; 

    }

    public boolean checkMove(int newRow, int newColumn, ChessPiece rook, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves((Rook) rook, gameState);
        
        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }

        return false;
    }
  
}