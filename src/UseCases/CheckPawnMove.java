package UseCases;

import Entities.ChessPiece;
import Other.GameState;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Pawns.
 */
public class CheckPawnMove extends CheckPlayerMove {

    public CheckPawnMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the Pawn can make with respect to the current state of the game.
     */
    public int[][] validMoves(ChessPiece pawn, GameState gameState) {
        int[][] result = new int[4][2];
        int row = pawn.getRow();
        int column = pawn.getColumn();
        ChessPiece[][] board = gameState.getBoard();


        if (pawn.getColor().equals("white")) {
            // Check non-attack moves
            if (row - 1 > -1 && board[row - 1][column] == null) {
                result[0][0] = row - 1;
                result[0][1] = column;
            }

            if (!pawn.getHasMovedOnce() && row - 2 > -1 && board[row - 1][column] == null
                    && board[row - 2][column] == null) {
                result[1][0] = row - 2;
                result[1][1] = column;
            }

            // Check attack moves
            if (row - 1 > -1 && column - 1 > -1 && board[row - 1][column - 1] != null
                    && super.isEnemy(pawn, board[row - 1][column - 1])) {
                result[2][0] = row - 1;
                result[2][1] = column - 1;
            }

            if (row - 1 > -1 && column + 1 < 8 && board[row - 1][column + 1] != null
                    && super.isEnemy(pawn, board[row - 1][column + 1])) {
                result[3][0] = row - 1;
                result[3][1] = column + 1;
            }
        } else {
            // Check non-attack moves
            if (row + 1 < 8 && board[row + 1][column] == null) {
                result[0][0] = row + 1;
                result[0][1] = column;
            }

            if (!pawn.getHasMovedOnce() && row + 2 < 8 && board[row + 1][column] == null
                    && board[row + 2][column] == null) {
                result[1][0] = row + 2;
                result[1][1] = column;
            }

            // Check attack moves
            if (row + 1 < 8 && column - 1 > -1 && board[row + 1][column - 1] != null
                    && super.isEnemy(pawn, board[row + 1][column - 1])) {
                result[2][0] = row + 1;
                result[2][1] = column - 1;
            }

            if (row + 1 < 8 && column + 1 < 8 && board[row + 1][column + 1] != null
                    && super.isEnemy(pawn, board[row + 1][column + 1])) {
                result[3][0] = row + 1;
                result[3][1] = column + 1;
            }
        }

        return result;
    }
     
}
