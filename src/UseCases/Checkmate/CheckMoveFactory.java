package UseCases.Checkmate;

import Entities.*;
import UseCases.*;

/**
 * This simple factory class is responsible for taking in a CheckPlayerMove object, a chess piece
 * and a Chessboard, and then returns a valid set of generated moves based upon the type
 * of chess piece that was passed onto the class.
 */
public class CheckMoveFactory{
    /**
     * Helper method used to generate the 2D list of valid moves for each chess piece.
     */
    public int[][] getValidMoves(CheckPlayerMove moves, ChessPiece piece, ChessPiece[][] board){

        if(piece.getLetter() == 'p' || piece.getLetter() == 'P'){
            return ((CheckPawnMove) moves).validMoves(piece, board);
        }
        if(piece.getLetter() == 'k' || piece.getLetter() == 'K'){
            return ((CheckKnightMove) moves).validMoves(piece, board);
        }
        if(piece.getLetter() == 'q' || piece.getLetter() == 'Q'){
            return ((CheckQueenMove) moves).validMoves(piece, board);
        }
        if(piece.getLetter() == 'b' || piece.getLetter() == 'B'){
            return ((CheckBishopMove) moves).validMoves(piece, board);
        }
        return ((CheckRookMove) moves).validMoves(piece, board);
    }
}
