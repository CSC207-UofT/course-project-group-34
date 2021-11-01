package UseCases;

import Entities.Pawn;
import Entities.ChessPiece;
import Other.GameState;

import java.util.Arrays;

public class CheckPawnMove extends CheckPlayerMove {

    public CheckPawnMove() { }

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

            if (!pawn.getHasMovedOnce() && row - 2 > -1 && board[row - 1][column] == null && board[row - 2][column] == null) {
                result[1][0] = row - 2;
                result[1][1] = column;
            }

            // Check attack moves
            if (row - 1 > -1 && column - 1 > -1 && board[row - 1][column - 1] != null) {
                result[2][0] = row - 1;
                result[2][1] = column - 1;
            }

            if (row - 1 > -1 && column + 1 < 8 && board[row - 1][column + 1] != null) {
                result[3][0] = row - 1;
                result[3][1] = column + 1;
            }
        } else {
            // Check non-attack moves
            if (row + 1 < 8 && board[row + 1][column] == null) {
                result[0][0] = row + 1;
                result[0][1] = column;
            }

            if (!pawn.getHasMovedOnce() && row + 2 < 8 && board[row + 1][column] == null && board[row + 2][column] == null) {
                result[1][0] = row + 2;
                result[1][1] = column;
            }

            // Check attack moves
            if (row + 1 < 8 && column - 1 > -1 && board[row + 1][column - 1] != null) {
                result[2][0] = row + 1;
                result[2][1] = column - 1;
            }

            if (row + 1 < 8 && column + 1 < 8 && board[row + 1][column + 1] != null) {
                result[3][0] = row + 1;
                result[3][1] = column + 1;
            }
        }

        return result;
    }
     
    public boolean checkMove(int newRow, int newColumn, ChessPiece pawn, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves((Pawn) pawn, gameState);
        
        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }

        return false;
    }
}
