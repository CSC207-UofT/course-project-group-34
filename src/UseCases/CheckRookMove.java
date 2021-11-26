package UseCases; 

import Entities.ChessPiece;

import java.util.ArrayList;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Rooks.
 */
public class CheckRookMove extends CheckPlayerMove {

    public CheckRookMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the Rook can make with respect to the current state of the game.
     */
    public int[][] validMoves(ChessPiece rook, ChessPiece[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        int row = rook.getRow(); 
        int column = rook.getColumn();
        
        // Moving up
        int currentRow = row - 1; 
        while (currentRow > -1 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column}); 
            currentRow--;
        }

        if (currentRow > -1 && super.isEnemy(rook, board[currentRow][column])) {
            result.add(new int[] {currentRow, column}); 
        }

        // Moving right
        int currentColumn = column + 1;
        while (currentColumn < 8 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn++;
        }

        if (currentColumn < 8 && super.isEnemy(rook, board[row][currentColumn])) {
            result.add(new int[] {row, currentColumn});
        }

        // Moving down
        currentRow = row + 1;
        while (currentRow < 8 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column}); 
            currentRow++;
        }

        if (currentRow < 8 && super.isEnemy(rook, board[currentRow][column])) {
            result.add(new int[] {currentRow, column}); 
        }

        // Moving left
        currentColumn = column - 1;
        while (currentColumn > -1 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn--; 
        }

        if (currentColumn > -1 && super.isEnemy(rook, board[row][currentColumn])) {
            result.add(new int[] {row, currentColumn});
        }

        return super.toArrayMoves(result);

    }
  
}
