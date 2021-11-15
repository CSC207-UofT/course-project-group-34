package UseCases; 

import Entities.Bishop;
import Entities.ChessPiece; 
import Other.GameState; 

import java.util.ArrayList; 
import java.util.Arrays;

public class CheckBishopMove extends CheckPlayerMove {

    public CheckBishopMove() { } 
    
    /**
    *
    * Considers valid moves made by the bishop
    * returns an array of the updated gamestate after the bishop has moved
    *
    */
    
    public int[][] validMoves(ChessPiece bishop, GameState gameState) {
        ArrayList result = new ArrayList(); 
        int row = bishop.getRow(); 
        int column = bishop.getColumn(); 
        ChessPiece[][] board = gameState.getBoard(); 

        // Moving up & right 
        int currentRow = row - 1;
        int currentColumn = column + 1;
        while (currentRow > -1 && currentColumn < 8 && board[currentRow][currentColumn] == null) { 
            result.add(new int[] {currentRow, currentColumn});
            currentRow--;
            currentColumn++;
        } 

        if (currentRow > -1 && currentColumn < 8) { 
            result.add(new int[] {currentRow, currentColumn}); 
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

    
     /**
    *
    * Checker to see if a bishop move is valid
    * returns true/false depending on the validity of the move
    *
    */
    public boolean checkMove(int newRow, int newColumn, ChessPiece bishop, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves((Bishop) bishop, gameState);
        
        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }

        return false;
    }
  
}
