package UseCases;

import Entities.ChessPiece;
import Entities.King;
import UseCases.Checkmate.Check;
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

        // Castling
        if (!king.getHasMovedOnce() && board[row][column - 1] == null && board[row][column - 2] == null
                && board[row][column - 3] == null && board[row][column - 4] != null
                && (board[row][column - 4].getLetter() == 'r' || board[row][column - 4].getLetter() == 'R')
                && !board[row][column - 4].getHasMovedOnce()) {
            Check check = new Check();
            king.setColumn(column - 1);
            board[row][column] = null;
            board[row][column - 1] = king;
            if (!check.isKingInCheck((King) king, board)) {
                king.setColumn(column);
                board[row][column] = king;
                board[row][column - 1] = null;
                result.add(new int[] {row, column - 2});
            }
        }

        if (!king.getHasMovedOnce() && board[row][column + 1] == null && board[row][column + 2] == null
                && board[row][column + 3] != null && (board[row][column + 3].getLetter() == 'r'
                || board[row][column + 3].getLetter() == 'R') && !board[row][column + 3].getHasMovedOnce()) {
            Check check = new Check();
            king.setColumn(column + 1);
            board[row][column] = null;
            board[row][column + 1] = king;
            if (!check.isKingInCheck((King) king, board)) {
                king.setColumn(column);
                board[row][column] = king;
                board[row][column + 1] = null;
                result.add(new int[] {row, column + 2});
            }
        }

        return super.toArrayMoves(result);

    }

}
