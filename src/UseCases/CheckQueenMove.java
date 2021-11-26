package UseCases; 

import Entities.ChessPiece;

import java.util.ArrayList;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Queens.
 */
public class CheckQueenMove extends CheckPlayerMove {

    public CheckQueenMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the Queen can make with respect to the current state of the game.
     */
    public int[][] validMoves(ChessPiece queen, ChessPiece[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        int row = queen.getRow(); 
        int column = queen.getColumn();
        
        // Moving up
        int currentRow = row - 1; 
        while (currentRow > -1 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column}); 
            currentRow--;
        }

        if (currentRow > -1 && super.isEnemy(queen, board[currentRow][column])) {
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

        if (currentRow > -1 && currentColumn < 8 && super.isEnemy(queen, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn}); 
        }

        // Moving right
        currentColumn = column + 1;
        while (currentColumn < 8 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn++;
        }

        if (currentColumn < 8 && super.isEnemy(queen, board[row][currentColumn])) {
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

        if (currentRow < 8 && currentColumn < 8 && super.isEnemy(queen, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn}); 
        }

        // Moving down
        currentRow = row + 1;
        while (currentRow < 8 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column}); 
            currentRow++;
        }

        if (currentRow < 8 && super.isEnemy(queen, board[currentRow][column])) {
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

        if (currentRow < 8 && currentColumn > -1 && super.isEnemy(queen, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn}); 
        }

        // Moving left
        currentColumn = column - 1;
        while (currentColumn > -1 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn--; 
        }

        if (currentColumn > -1 && super.isEnemy(queen, board[row][currentColumn])) {
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

        if (currentRow > -1 && currentColumn > -1 && super.isEnemy(queen, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn}); 
        }

        return super.toArrayMoves(result);
    }
  
}
