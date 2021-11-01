package UseCases; 

import Entities.Queen;
import Entities.ChessPiece; 
import Other.GameState;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckQueenMove extends CheckPlayerMove {

    public CheckQueenMove() { } 
    
    public int[][] validMoves(ChessPiece queen, GameState gameState) {
        ArrayList result = new ArrayList();
        int row = queen.getRow(); 
        int column = queen.getColumn(); 
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

        // Moving up & right 
        currentRow = row - 1;
        int currentColumn = column + 1;
        while (currentRow > -1 && currentColumn < 8 && board[currentRow][currentColumn] == null) { 
            result.add(new int[] {currentRow, currentColumn});
            currentRow--;
            currentColumn++;
        } 

        if (currentRow > -1 && currentColumn < 8) { 
            result.add(new int[] {currentRow, currentColumn}); 
        }

        // Moving right
        currentColumn = column + 1;
        while (currentColumn < 8 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn++;
        }

        if (currentColumn < 8) { 
            result.add(new int[] {row, currentColumn});
        }

        // Moving down & right
        currentRow = row + 1;
        currentColumn = column + 1;
        while (currentRow < 8 && currentColumn < 8 && board[currentRow][currentColumn] == null) { 
            result.add(new int[] {currentRow, currentColumn});
            currentRow++;
            currentColumn++;
        } 

        if (currentRow < 8 && currentColumn < 8) { 
            result.add(new int[] {currentRow, currentColumn}); 
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

        // Moving down & left 
        currentRow = row + 1;
        currentColumn = column - 1;
        while (currentRow < 8 && currentColumn > -1 && board[currentRow][currentColumn] == null) { 
            result.add(new int[] {currentRow, currentColumn});
            currentRow++;
            currentColumn--;
        } 

        if (currentRow < 8 && currentColumn > -1) { 
            result.add(new int[] {currentRow, currentColumn}); 
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

        // Moving up & left 
        currentRow = row - 1;
        currentColumn = column - 1;
        while (currentRow > -1 && currentColumn > -1 && board[currentRow][currentColumn] == null) { 
            result.add(new int[] {currentRow, currentColumn});
            currentRow--;
            currentColumn--;
        } 

        if (currentRow > -1 && currentColumn > -1) { 
            result.add(new int[] {currentRow, currentColumn}); 
        }

        int[][] array = result.toArray();
        return array;
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
