package UseCases;

import Entities.ChessPiece;

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
    public int[][] validMoves(ChessPiece king, ChessPiece[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        int row = king.getRow();
        int column = king.getColumn();
        String color = king.getColor();

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

        // Checking castling

        if (color.equals("white")) {
            if (!king.getHasMovedOnce() && !board[8][8].getHasMovedOnce() && board[8][6] == null && board[8][7] == null){
                result.add(new int[]{row, column + 2});
            }
            if (!king.getHasMovedOnce() && !board[8][1].getHasMovedOnce() && board[8][2] == null && board[8][3] == null
                && board[8][4] == null){
                result.add(new int[]{row, column - 2});
            }
        }

        if (color.equals("black")) {
            if (!king.getHasMovedOnce() && !board[1][8].getHasMovedOnce() && board[1][6] == null && board[1][7] == null){
                result.add(new int[]{row, column + 2});
            }
            if (!king.getHasMovedOnce() && !board[1][1].getHasMovedOnce() && board[1][2] == null && board[1][3] == null
                    && board[1][4] == null){
                result.add(new int[]{row, column - 2});
            }
        }

        return super.toArrayMoves(result);

    }

}
