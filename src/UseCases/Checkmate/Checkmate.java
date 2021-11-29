package UseCases.Checkmate;

import Entities.ChessPiece;
import Entities.King;
import UseCases.*;
import Entities.*;

import java.util.Arrays;

/**
 * This class is responsible for determining if the GameState, and it's chess game are in checkmate.
 *
 * Checkmate in a chess game occurs when :
 *      1. The King is in check
 *      2. The King cannot get out of check
 */
public class Checkmate {

    private int[] sharedPos = null;
    private boolean hasSharedPos;

    /**
     * This method is responsible for determining whether the GameState in is Checkmate.
     * Recall the Checkmate only occurs within a game when:
     *      1. A player's King is in Check, and
     *      2. That player's King cannot get out of Check.
     *
     * @return - true, if the GameState is in Checkmate
     *         - false, otherwise
     */
    public boolean isCheckmate(King king, ChessPiece[][] board){

        // If the King is not in check initially, return false early on
        Check check = new Check();
        if(!(check.isKingInCheck(king, board))) {
            return false;
        }

        // Generate list of valid moves for the King piece and keeping track of its original position
        CheckKingMove checkMoves = new CheckKingMove();
        int[][] validMoves = checkMoves.validMoves(king, board);

        int[][] positions = check.getPositions();

        removeChessPiece(board, king.getRow(), king.getColumn());
        for(int[] move : validMoves) {
            // Creates a temporary King object to test checkmate on
            King tempKing = new King(move[0], move[1], king.getColor());
            addChessPiece(board, tempKing);

            // Loops through each valid move, and determines whether the tempKing is still in check or not.
            if(!(check.isKingInCheck(tempKing, board))){
                removeChessPiece(board, move[0], move[1]);
                addChessPiece(board, king);

                return false;
            }
            removeChessPiece(board, move[0], move[1]);
        }

        // If there are no valid moves where the King can take itself out of check, we then
        // see if the opposing piece can be captured or blocked, and determine whether our
        // game is in checkmate based on that.
        addChessPiece(board, king);

        return !(checkPositions(positions, board, king));
    }

    /**
     * This is a helper method used to determine whether we can block or capture the opposing
     * chess piece putting the king in check. Returns true if the opposing piece can be blocked
     * or captured, and false otherwise.
     */
    private boolean checkPositions(int[][] positions, ChessPiece[][] board, King king){
        CheckerGenerator currChecker = new CheckerGenerator();

        // For each position in the chess board, IF there is piece that belongs to the same team,
        // AND that piece has a valid move that corresponds with any position in positions, THEN
        // that piece can block or capture the piece that has our King in Check.
        for(int i = 0; i < 8; i++){
            for(int x = 0; x < 8; x++){
                if(board[i][x] != null && board[i][x].getColor().equals(king.getColor()) && !(board[i][x] instanceof King) ){

                    CheckPlayerMove moves = currChecker.generateChecker(board[i][x]);
                    int[][] validMoves = getValidMoves(moves, board[i][x], board);
                    hasSharedPosition(positions, validMoves);

                    if(this.hasSharedPos && !(moveCausesCheck(king, board[i][x], board, sharedPos[0], sharedPos[1]))){
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
    private boolean moveCausesCheck(King king, ChessPiece currPiece, ChessPiece[][] board, int row, int col){
        Check check = new Check();
        int currRow = currPiece.getRow();
        int currCol = currPiece.getColumn();

        ChessPiece tempPiece = getCopy(currPiece, row, col);
        removeChessPiece(board, currRow, currCol);
        addChessPiece(board, tempPiece);
        if(check.isKingInCheck(king, board)){
            removeChessPiece(board, row, col);
            addChessPiece(board, currPiece);
            return true;
        }
        removeChessPiece(board, row, col);
        addChessPiece(board, currPiece);
        return false;
    }

    /**
     * This method takes in a chess piece instance and returns a copy of that instance.
     */
    private ChessPiece getCopy(ChessPiece currPiece, int row, int col){
        if(currPiece instanceof Pawn){
            return new Pawn(row, col, currPiece.getColor());
        }
        if(currPiece instanceof Queen){
            return new Queen(row, col, currPiece.getColor());
        }
        if(currPiece instanceof Knight){
            return new Knight(row, col, currPiece.getColor());
        }
        if(currPiece instanceof Rook){
            return new Rook(row, col, currPiece.getColor());
        }
        else{
            return new Bishop(row, col, currPiece.getColor());
        }
    }


    /**
     * Helper method used to generate the 2D list of valid moves for each chess piece.
     */
    private int[][] getValidMoves(CheckPlayerMove moves, ChessPiece piece, ChessPiece[][] board){
        if(moves instanceof CheckPawnMove){
            return ((CheckPawnMove) moves).validMoves(piece, board);
        }
        if(moves instanceof CheckKnightMove){
            return ((CheckKnightMove) moves).validMoves(piece, board);
        }
        if(moves instanceof CheckQueenMove){
            return ((CheckQueenMove) moves).validMoves(piece, board);
        }
        if(moves instanceof CheckBishopMove){
            return ((CheckBishopMove) moves).validMoves(piece, board);
        }
        return ((CheckRookMove) moves).validMoves(piece, board);
    }

    /**
     * Helper method used in checkPosition. Used to iterate over two separate 2d arrays. Returns
     * true if they share at least one array element, false otherwise.
     */
    private void hasSharedPosition(int[][] arr1, int[][] arr2){
        if(arr1.length == 0 || arr2.length == 0){
            this.hasSharedPos = false;
            return;
        }
        for(int[] pos1 : arr1){
            for(int[] pos2 : arr2){
                if(Arrays.equals(pos1, pos2)){
                    this.sharedPos = pos1;
                    this.hasSharedPos = true;
                    return;
                }
            }
        }
        this.hasSharedPos = false;
    }

    /**
     * This method adds the ChessPiece object from our parameter and into our
     * 2D array that represents the chess board.
     */
    public void addChessPiece(ChessPiece[][] board, ChessPiece chessPiece){
        board[chessPiece.getRow()][chessPiece.getColumn()] = chessPiece;
    }

    /**
     * This method takes in a given position and removes that chess piece from that position.
     */
    public void removeChessPiece(ChessPiece[][] board, int row, int col) {
        board[row][col] = null;
    }

}