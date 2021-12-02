package UseCases; 

import Entities.ChessPiece;

import java.util.ArrayList;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Rooks.
 */
public class CheckRookMove extends CheckPlayerMove {

    public CheckRookMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the Rook can make with respect to the current state of the game.
     */
    public int[][] validMoves(ChessPiece rook, ChessPiece[][] board) {
        ArrayList<int[]> result = super.verticalHorizontalMoves(rook, board);
        return super.toArrayMoves(result);
    }
  
}
