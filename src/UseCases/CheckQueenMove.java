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
        ArrayList<int[]> result = super.verticalHorizontalMoves(queen, board);
        result.addAll(super.diagonalMoves(queen, board));
        return super.toArrayMoves(result);
    }
  
}
