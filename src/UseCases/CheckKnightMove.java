package UseCases; 

import Entities.ChessPiece;

import java.util.ArrayList;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Knights.
 */
public class CheckKnightMove extends CheckPlayerMove {

    public CheckKnightMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the Knight can make with respect to the current state of the game.
     */
    public int[][] validMoves(ChessPiece knight, ChessPiece[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        int row = knight.getRow(); 
        int column = knight.getColumn();

        if (row - 2 > -1 && column - 1 > -1 &&
                (board[row - 2][column - 1] == null || super.isEnemy(knight, board[row - 2][column - 1]))) {
            result.add(new int[] {row - 2, column - 1});
        }

        if (row - 2 > -1 && column + 1 < 8 &&
                (board[row - 2][column + 1] == null || super.isEnemy(knight, board[row - 2][column + 1]))) {
            result.add(new int[] {row - 2, column + 1});
        }

        if (row - 1 > -1 && column + 2 < 8 &&
                (board[row - 1][column + 2] == null || super.isEnemy(knight, board[row - 1][column + 2]))) {
            result.add(new int[] {row - 1, column + 2});
        }

        if (row + 1 < 8 && column + 2 < 8 &&
                (board[row + 1][column + 2] == null || super.isEnemy(knight, board[row + 1][column + 2]))) {
            result.add(new int[] {row + 1, column + 2});
        }

        if (row + 2 < 8 && column + 1 < 8 &&
                (board[row + 2][column + 1] == null || super.isEnemy(knight, board[row + 2][column + 1]))) {
            result.add(new int[] {row + 2, column + 1}); 
        }

        if (row + 2 < 8 && column - 1 > -1 &&
                (board[row + 2][column - 1] == null || super.isEnemy(knight, board[row + 2][column - 1]))) {
            result.add(new int[] {row + 2, column - 1}); 
        }

        if (row + 1 < 8 && column - 2 > -1 &&
                (board[row + 1][column - 2] == null || super.isEnemy(knight, board[row + 1][column - 2]))) {
            result.add(new int[] {row + 1, column - 2});
        }

        if (row - 1 > -1 && column - 2 > -1 &&
                (board[row - 1][column - 2] == null || super.isEnemy(knight, board[row - 1][column - 2]))) {
            result.add(new int[] {row - 1, column - 2});
        }

        return super.toArrayMoves(result);

    }
  
}
