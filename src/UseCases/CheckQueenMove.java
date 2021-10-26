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
        while (currentRow > -1 && board[currentRow][column] == null) {
            result.add({currentRow, column}); 
            currentRow--;
        }

        if (currentRow > -1) { 
            result.add({currentRow, column}); 
        }

        // Moving up & right 
        int currentRow = row - 1;
        int currentColumn = column + 1;
        while (currentRow > -1 && currentColumn < 8 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow--;
            currentColumn++;
        } 

        if (currentRow > -1 && currentColumn < 8) { 
            result.add({currentRow, currentColumn}); 
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

        // Moving down & right
        int currentRow = row + 1;
        int currentColumn = column + 1;
        while (currentRow < 8 && currentColumn < 8 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow++;
            currentColumn++;
        } 

        if (currentRow < 8 && currentColumn < 8) { 
            result.add({currentRow, currentColumn}); 
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

        // Moving down & left 
        int currentRow = row + 1;
        int currentColumn = column - 1;
        while (currentRow < 8 && currentColumn > -1 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow++;
            currentColumn--;
        } 

        if (currentRow < 8 && currentColumn > -1) { 
            result.add({currentRow, currentColumn}); 
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

        // Moving up & left 
        int currentRow = row - 1;
        int currentColumn = column - 1;
        while (currentRow > -1 && currentColumn > -1 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow--;
            currentColumn--;
        } 

        if (currentRow > -1 && currentColumn > -1) { 
            result.add({currentRow, currentColumn}); 
        }

        return result;
    }

    public boolean checkMove(int newRow, int newColumn, ChessPiece queen, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves((Queen) queen, gameState);
        
        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }

        return false;
    }
  
}
