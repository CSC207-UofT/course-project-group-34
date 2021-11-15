package UseCases;

import Entities.ChessPiece;
import Other.GameState;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckKingMove extends CheckPlayerMove {

    public CheckKingMove() { }

    public int[][] validMoves(ChessPiece king, GameState gameState) {
        ArrayList result = new ArrayList();
        int row = king.getRow();
        int column = king.getColumn();
        ChessPiece[][] board = gameState.getBoard();

        // Checking moves to one row above

        if (row - 1 > -1) {
            result.add(new int[]{row - 1, column});

            if (column - 1 > -1) {
                result.add(new int[]{row - 1, column - 1});
            }

            if (column + 1 < 8) {
                result.add(new int[]{row - 1, column + 1});
            }
        }

        // Checking moves to the left or right

        if (column - 1 > -1) {
            result.add(new int[]{row, column - 1});
        }

        if (column + 1 < 8) {
            result.add(new int[]{row, column + 1});
        }

        // Checking moves to one row below

        if (row + 1 < 8) {
            result.add(new int[]{row + 1, column});

            if (column - 1 > -1) {
                result.add(new int[]{row + 1, column - 1});
            }

            if (column + 1 < 8) {
                result.add(new int[]{row + 1, column + 1});
            }
        }

        int[][] array = result.toArray();
        return array;

    }

}