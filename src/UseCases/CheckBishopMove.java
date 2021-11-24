package UseCases; 

import Entities.ChessPiece; 
import Controllers.GameState;

import java.util.ArrayList;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Bishops.
 */
public class CheckBishopMove extends CheckPlayerMove {

    public CheckBishopMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the Bishop can make with respect to the current state of the game.
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

        if (currentRow > -1 && currentColumn < 8 && super.isEnemy(bishop, board[currentRow][currentColumn])) {
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

        if (currentRow < 8 && currentColumn < 8 && super.isEnemy(bishop, board[currentRow][currentColumn])) {
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

        if (currentRow < 8 && currentColumn > -1 && super.isEnemy(bishop, board[currentRow][currentColumn])) {
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

        if (currentRow > -1 && currentColumn > -1 && super.isEnemy(bishop, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn}); 
        }

        int[][] array = super.toArrayMoves(result);
        return array;
    }
  
}
