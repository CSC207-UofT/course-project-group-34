package UseCases;

import Entities.ChessPiece;
import Controllers.GameState;

import java.util.ArrayList;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Kings.
 */
public class CheckKingMove extends CheckPlayerMove {

    public CheckKingMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the King can make with respect to the current state of the game.
     */
    public int[][] validMoves(ChessPiece king, GameState gameState) {
        ArrayList<int[]> result = new ArrayList<>();
        int row = king.getRow();
        int column = king.getColumn();
        ChessPiece[][] board = gameState.getBoard();

        // Checking moves to one row above

        if (row - 1 > -1) {
            if (board[row - 1][column] == null || super.isEnemy(king, board[row - 1][column])) {
                result.add(new int[]{row - 1, column});
            }

            if (column - 1 > -1 &&
                    (board[row - 1][column - 1] == null || super.isEnemy(king, board[row - 1][column - 1]))) {
                result.add(new int[]{row - 1, column - 1});
            }

            if (column + 1 < 8 &&
                    board[row - 1][column + 1] == null || super.isEnemy(king, board[row - 1][column + 1])) {
                result.add(new int[]{row - 1, column + 1});
            }
        }

        // Checking moves to the left or right

        if (column - 1 > -1 && (board[row][column - 1] == null || super.isEnemy(king, board[row][column - 1]))) {
            result.add(new int[]{row, column - 1});
        }

        if (column + 1 < 8 && (board[row][column + 1] == null || super.isEnemy(king, board[row][column + 1]))) {
            result.add(new int[]{row, column + 1});
        }

        // Checking moves to one row below

        if (row + 1 < 8) {
            if (board[row + 1][column] == null || super.isEnemy(king, board[row + 1][column]))
                result.add(new int[]{row + 1, column});

            if (column - 1 > -1 &&
                    (board[row + 1][column - 1] == null || super.isEnemy(king, board[row + 1][column - 1]))) {
                result.add(new int[]{row + 1, column - 1});
            }

            if (column + 1 < 8 &&
                    (board[row + 1][column + 1] == null || super.isEnemy(king, board[row + 1][column + 1]))) {
                result.add(new int[]{row + 1, column + 1});
            }
        }

        return super.toArrayMoves(result);

    }

}
