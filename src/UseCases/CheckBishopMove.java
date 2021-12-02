package UseCases; 

import Entities.ChessPiece;

import java.util.ArrayList;

/**
 * This class is a subclass of CheckPlayerMove responsible for verifying the validity of moves
 * for Bishops.
 */
public class CheckBishopMove extends CheckPlayerMove {

    public CheckBishopMove() { }

    /**
     * This method generates a 2-dimensional array of integers that represents a list of valid moves
     * that the Bishop can make with respect to the current state of the game.
     */
    public int[][] validMoves(ChessPiece bishop, ChessPiece[][] board) {
        ArrayList<int[]> result = super.diagonalMoves(bishop, board);
        return super.toArrayMoves(result);
    }
  
}
