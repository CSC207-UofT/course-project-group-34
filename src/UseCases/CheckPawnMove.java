package UseCases;

import Entities.Pawn;
import Entities.ChessPiece;
import Other.GameState;

public class CheckPawnMove extends CheckPlayerMove {

    public int[][] validMoves(Pawn pawn, GameState gameState) {
        int[][] result = new int[4][2];
        int xPosition = pawn.getXPosition();
        int yPosition = pawn.getYPosition();
        ChessPiece[][] board = gameState.getBoard();


        if (pawn.getColor().equals("white")) {
            // Check non-attack moves
            if (yPosition - 1 > 0 && board[yPosition - 1][xPosition] == null) {
                result[0][0] = yPosition;
                result[0][1] = xPosition - 1;
            }

            if (!pawn.getHasMovedOnce() && yPosition + 2 < 8 && board[xPosition][yPosition + 1] == null && board[xPosition][yPosition + 2] == null) {
                result[1][0] = xPosition;
                result[1][1] = yPosition - 2;
            }

            // Check attack moves
            if (xPosition - 1 > -1 && yPosition + 1 < 8 && board[xPosition - 1][yPosition + 1] != null) {
                result[2][0] = xPosition - 1;
                result[2][1] = yPosition - 1;
            }

            if (xPosition + 1 < 8 && yPosition + 1 < 8 && board[xPosition + 1][yPosition + 1] != null) {
                result[3][0] = xPosition + 1;
                result[3][1] = yPosition - 1;
            }
        } else {
            // Check non-attack moves
            if (yPosition + 1 < 8 && board[xPosition][yPosition + 1] == null) {
                result[0][0] = xPosition;
                result[0][1] = yPosition + 1;
            }

            if (!pawn.getHasMovedOnce() && yPosition + 2 < 8 && board[xPosition][yPosition + 1] == null && board[xPosition][yPosition + 2] == null) {
                result[1][0] = xPosition;
                result[1][1] = yPosition + 2;
            }

            // Check attack moves
            if (xPosition - 1 > -1 && yPosition + 1 < 8 && board[xPosition - 1][yPosition + 1] != null) {
                result[2][0] = xPosition - 1;
                result[2][1] = yPosition + 1;
            }

            if (xPosition + 1 < 8 && yPosition + 1 < 8 && board[xPosition + 1][yPosition + 1] != null) {
                result[3][0] = xPosition + 1;
                result[3][1] = yPosition + 1;
            }
        }
        return result;
    }

    public boolean checkMove(int newXPosition, int newYPosition, ChessPiece pawn, GameState gameState) {
        int[] desiredMove = {newXPosition, newYPosition};
        int[][] possibleMoves = validMoves((Pawn) pawn, gameState);
        for (int[] move : possibleMoves) {
            if (desiredMove.equals(move)) {
                return true;
            }
        }

        return false;

    }
}
