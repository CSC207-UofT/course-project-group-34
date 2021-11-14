package Other.Checkmate;

import Entities.ChessPiece;
import Entities.King;
import Other.GameState;
import UseCases.*;

import java.util.Arrays;

/**
 * This class is responsible for determining if the GameState, and it's chess game are in checkmate.
 *
 * Checkmate in a chess game occurs when :
 *      1. The King is in check
 *      2. The King cannot get out of check
 */
public class Checkmate {

    /**
     * This method is responsible for determining whether the GameState in is Checkmate.
     * Recall the Checkmate only occurs within a game when:
     *      1. A player's King is in Check, and
     *      2. That player's King cannot get out of Check.
     *
     * @return - true, if the GameState is in Checkmate
     *         - false, otherwise
     */
    public boolean isCheckmate(King king, GameState state){

        // If the King is not in check initially, return false early on
        Check check = new Check();
        if(!(check.isKingInCheck(king, state))){
            return false;
        }

        // Generate list of valid moves for the King piece and keeping track of its original position
        CheckKingMove checkMoves = new CheckKingMove();
        int[][] validMoves = checkMoves.validMoves(king, state);
        int[][] positions = check.getPositions();

        state.removeChessPiece(king.getRow(), king.getColumn());
        for(int[] move : validMoves) {
            // Creates a temporary King object to test checkmate on
            King tempKing = new King(move[0], move[1], king.getColor());
            state.addChessPiece(tempKing);

            // Loops through each valid move, and determines whether the tempKing is still in check or not.
            if(!(check.isKingInCheck(tempKing, state))){
                state.removeChessPiece(move[0], move[1]);
                state.addChessPiece(king);
                return false;
            }
            state.removeChessPiece(move[0], move[1]);
        }

        // If there are no valid moves where the King can take itself out of check, we then
        // see if the opposing piece can be captured or blocked, and determine whether our
        // game is in checkmate based on that.
        state.addChessPiece(king);
        return checkPositions(positions, state, king);
    }

    /**
     * This is a helper method used to determine whether we can block or capture the opposing
     * chess piece putting the king in check. Returns true if the opposing piece can be blocked
     * or captured, and false otherwise.
     */
    private boolean checkPositions(int[][] positions, GameState state, King king){
        ChessPiece[][] board = state.getBoard();
        CheckerGenerator currChecker = new CheckerGenerator();

        // For each position in the chess board, IF there is piece that belongs to the same team,
        // AND that piece has a valid move that corresponds with any position in positions, THEN
        // that piece can block or capture the piece that has our King in Check.
        for(int i = 0; i < 8; i++){
            for(int x = 0; x < 8; x++){
                if(board[i][x] != null && board[i][x].getColor().equals(king.getColor())){

                    CheckPlayerMove moves = currChecker.generateChecker(board[i][x]);
                    int[][] validMoves = getValidMoves(moves, board[i][x], state);

                    // Used to see if the King can be put in check once we move the piece.
                    Object[][] sharedPos = hasSharedPosition(positions, validMoves);
                    if((boolean) sharedPos[0][0] && !(moveCausesCheck(king, board[i][x], state))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method is used to determine if the king is in check once we remove a chess piece from the board.
     * Returns true if the king is still in check, and false otherwise.
     */
    private boolean moveCausesCheck(King king, ChessPiece currPiece, GameState state){
        Check check = new Check();
        int currRow = currPiece.getRow();
        int currCol = currPiece.getColumn();

        state.removeChessPiece(currRow, currCol);
        if(check.isKingInCheck(king, state)){
            state.addChessPiece(currPiece);
            return true;
        }
        state.addChessPiece(currPiece);
        return false;
    }


    /**
     * Helper method used to generate the 2D list of valid moves for each chess piece.
     */
    private int[][] getValidMoves(CheckPlayerMove moves, ChessPiece piece, GameState state){
        if(moves instanceof CheckPawnMove){
            return ((CheckPawnMove) moves).validMoves(piece, state);
        }
        if(moves instanceof CheckKnightMove){
            return ((CheckKnightMove) moves).validMoves(piece, state);
        }
        if(moves instanceof CheckQueenMove){
            return ((CheckQueenMove) moves).validMoves(piece, state);
        }
        if(moves instanceof CheckBishopMove){
            return ((CheckBishopMove) moves).validMoves(piece, state);
        }
        return ((CheckRookMove) moves).validMoves(piece, state);
    }

    /**
     * Helper method used in checkPosition. Used to iterate over two separate 2d arrays. Returns
     * true if they share at least one array element, false otherwise.
     */
    private Object[][] hasSharedPosition(int[][] arr1, int[][] arr2){
        if(arr1.length == 0 || arr2.length == 0){
            return new Object[][]{{false}};
        }

        for(int[] pos1 : arr1){
            for(int[] pos2 : arr2){
                if(Arrays.equals(pos1, pos2)){
                    return new Object[][]{{true},{pos2}};
                }
            }
        }
        return new Object[][]{{false}};
    }

}
