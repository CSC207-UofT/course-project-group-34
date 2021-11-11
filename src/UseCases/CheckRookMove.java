package UseCases; 

import Entities.ChessPiece; 
import Other.GameState; 

import java.util.ArrayList; 
import java.util.Arrays;

public class CheckRookMove extends CheckPlayerMove {

    public CheckRookMove() { } 
    
    public int[][] validMoves(ChessPiece rook, GameState gameState) {
        ArrayList result = new ArrayList(); 
        int row = rook.getRow(); 
        int column = rook.getColumn(); 
        ChessPiece[][] board = gameState.getBoard(); 
        
        // Moving up
        int currentRow = row - 1; 
        while (currentRow > -1 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column}); 
            currentRow--;
        }

        if (currentRow > -1) { 
            result.add(new int[] {currentRow, column}); 
        }

        // Moving right
        int currentColumn = column + 1;
        while (currentColumn < 8 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn++;
        }

        if (currentColumn < 8) { 
            result.add(new int[] {row, currentColumn});
        }

        // Moving down
        currentRow = row + 1;
        while (currentRow < 8 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column}); 
            currentRow++;
        }

        if (currentRow < 8) { 
            result.add(new int[] {currentRow, column}); 
        }

        // Moving left
        currentColumn = column - 1;
        while (currentColumn > -1 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn--; 
        }

        if (currentColumn > -1) {
            result.add(new int[] {row, currentColumn});
        }

        int[][] array = result.toArray(); 
        return array; 

    }
  
}