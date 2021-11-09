package UseCases.Checkmate;

import Entities.*;
import Other.GameState;

public class Check {

    /**
     * This method takes in a king chess piece as well as the GameState it belongs to and determines whether
     * that King chess piece is in check or not. Recall that a King is in check when it is in a viable position
     * to be "captured" by an opposing player's piece.
     *
     * @return - true, if the King is in check
     *         - false, otherwise
     */
    public boolean isKingInCheck(King king, GameState state){

        return checkLeftRight(king, state) && checkForwadsBackwards(king, state) &&
                checkDiagonals(king, state) && checkKnight(king, state) && checkPawn(king, state);
    }

    /**
     * This method is used to determine whether there is an opposing Queen or Rook that
     * can capture the King piece from the Left or Right.
     *
     * @return - true, if there is an opposing Queen or Rook that can capture the King
     *         - false, otherwise
     */
    private boolean checkLeftRight(King king, GameState state){
        int col = king.getColumn();
        int row = king.getRow();
        ChessPiece[][] board = state.getBoard();

        // Checking for any Rooks or Queens to the Right of the king
        while(col + 1 != 8){
            col++;
            int x = hasOpposingQueenRook(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }

        col = king.getColumn();

        //Checking for any Rooks or Queens to the Left of the King
        while(col - 1 != -1){
            col--;
            int x = hasOpposingQueenRook(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }
        return false;
    }

    /**
     * This method is used to determine whether there is an opposing Queen or Rook that
     * can capture the King piece from directly above or behind it.
     *
     * @return - true, if there is an opposing Queen or Rook that can capture the King
     *         - false, otherwise
     */
    private boolean checkForwadsBackwards(King king, GameState state){
        int col = king.getColumn();
        int row = king.getRow();
        ChessPiece[][] board = state.getBoard();

        // Checking for any Queens or Rooks directly down the board
        while(row + 1 != 8){
            row++;
            int x = hasOpposingQueenRook(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }

        row = king.getRow();

        // Checking for any Queens or Rooks directly up the board
        while(row - 1 != -1) {
            row--;
            int x = hasOpposingQueenRook(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }
        return false;
    }


    /**
     * This is a helper method used to determine whether the there is an opposing Queen or Rook
     * chess piece located at the board in the given position.
     *
     * @return -  1, if there is an opposing Queen or Rook at the given position
     *         -  0, if there is no chess piece at this given position
     *         - -1, if there is a chess piece at this given position, but it is not an opposing one
     */
    private int hasOpposingQueenRook(ChessPiece[][] board, int row, int col, String color) {
        if (board[row][col] != null) {
            if (!(board[row][col].getColor().equals(color)) &&
                    board[row][col] instanceof Queen || board[row][col] instanceof Rook) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    /**
     * This method is used to check is there is an opposing Queen or Bishop that can capture
     * the king through a diagonal.
     *
     * @return - true, if there is either an opposing Queen or Bishop that can capture the King
     *         - false, otherwise
     */
    private boolean checkDiagonals (King king, GameState state){
        int col = king.getColumn();
        int row = king.getRow();
        ChessPiece[][] board = state.getBoard();

        // Check for Queens or Bishops within up-right diagonal
        while (col + 1 != 8 && row - 1 != -1) {
            col++;
            row--;
            int x = hasOpposingQueenBishop(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }

        col = king.getColumn();
        row = king.getRow();

        // Check for Queens or Bishops within up-Left Diagonal
        while (col - 1 != -1 && row - 1 != -1) {
            col--;
            row--;
            int x = hasOpposingQueenBishop(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }

        col = king.getColumn();
        row = king.getRow();

        // Check for Queens or Bishops within down-Right Diagonal
        while (col + 1 != 8 && row + 1 != 8) {
            col++;
            row++;
            int x = hasOpposingQueenBishop(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }

        col = king.getColumn();
        row = king.getRow();

        // Check for Queens or Bishops within down-Left Diagonal
        while (col - 1 != -1 && row + 1 != 8) {
            col--;
            row++;
            int x = hasOpposingQueenBishop(board, row, col, king.getColor());
            if (x == 1) {
                return true;
            } else if (x == -1) {
                break;
            }
        }
        return false;
    }

    /**
     * This is a helper method used to determine whether the there is an opposing Queen or Bishop
     * chess piece located at the board in the given position.
     *
     * @return -  1, if there is an opposing Queen or Bishop at the given position
     *         -  0, if there is no chess piece at this given position
     *         - -1, if there is a chess piece at this given position, but it is not an opposing one
     */
    private int hasOpposingQueenBishop(ChessPiece[][] board, int row, int col, String color) {
        if (board[row][col] != null) {
            if (!(board[row][col].getColor().equals(color)) &&
                    board[row][col] instanceof Queen || board[row][col] instanceof Bishop) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    /**
     * This method returns true if there are any opposing Knight pieces that
     * are able to capture the King, and false otherwise.
     *
     * @return - true, if there opposing knight pieces that can capture the king
     *         - false, otherwise
     */
    private boolean checkKnight(King king, GameState state){
        ChessPiece[][] board = state.getBoard();
        int row = king.getRow();
        int col = king.getColumn();

        // Opposing Knight two spaces UP and one space LEFT
        if (row - 2 > -1 && col - 1 > -1){
            if(hasOpposingKnight(board, row - 2, col - 1, king.getColor())){
                return true;
            }
        }

        // Opposing Knight two spaces UP and one space RIGHT
        if (row - 2 > -1 && col + 1 < 8 ){
            if(hasOpposingKnight(board, row - 2, col + 1, king.getColor())){
                return true;
            }
        }

        // Opposing Knight two spaces DOWN and one space LEFT
        if (row + 2 < 8 && col - 1 > -1){
            if(hasOpposingKnight(board, row + 2, col - 1, king.getColor())){
                return true;
            }
        }

        // Opposing Knight two spaces DOWN and one space RIGHT
        if (row + 2 < 8 && col + 1 < 8){
            if(hasOpposingKnight(board, row + 2, col + 1, king.getColor())){
                return true;
            }
        }

        // Opposing Knight two spaces LEFT and one space UP
        if (row - 1 > - 1 && col - 2 > -1){
            if(hasOpposingKnight(board, row - 1, col - 2, king.getColor())){
                return true;
            }
        }

        // Opposing Knight two spaces LEFT and one space DOWN
        if (row + 1 < 8 && col - 2 > -1){
            if(hasOpposingKnight(board, row + 1, col - 2, king.getColor())){
                return true;
            }
        }

        // Opposing knight two spaces RIGHT and one space UP
        if (row - 1 > -1 && col + 2 < 8){
            if(hasOpposingKnight(board, row -1, col + 2, king.getColor())){
                return true;
            }
        }

        // Opposing knight two spaces RIGHT and one space DOWN
        if (row + 1 < 8 && col + 2 < 8){
            if(hasOpposingKnight(board, row + 1, col +2, king.getColor())){
                return true;
            }
        }

        return false;
    }

    /**
     * This is a helper method used to determine whether the there is an opposing Knight
     * chess piece located at the board in the given position.
     *
     * @return - true, if there is an opposing knight piece
     *         - false, otherwise
     */
    private boolean hasOpposingKnight(ChessPiece[][] board, int row, int col, String color){
        if (board[row][col] != null) {
            return !(board[row][col].getColor().equals(color)) &&
                    board[row][col] instanceof Knight;
        }
        return false;
    }

    /**
     * This method is used to determine whether there are any opposing pawn pieces that are in
     * position to capture the King.
     *
     * @return - true, if there is an opposing Pawn piece that can capature the King,
     *         - false, otherwise
     */
    private boolean checkPawn(King king, GameState state){
        ChessPiece[][] board = state.getBoard();
        String color = king.getColor();
        int row = king.getRow();
        int col = king.getColumn();

        if(color.equals("Black")){
            // If the pawn is to the bottom Left
            if(row + 1 < 8 && col - 1 > - 1){
                if(hasOpposingPawn(board, row + 1, col - 1, king.getColor())){
                    return true;
                }
            }
            // If the pawn is to the bottom Right
            if(row + 1 < 8 && col + 1 < 8){
                if(hasOpposingPawn(board, row + 1, col + 1, king.getColor())){
                    return true;
                }
            }
        }
        else{
            // If the pawn is to the upper Left
            if(row - 1 > -1 && col - 1 > - 1){
                if(hasOpposingPawn(board, row - 1, col - 1, king.getColor())){
                    return true;
                }
            }
            // If the pawn is to the upper Right
            if(row - 1 > -1 && col + 1 < 8){
                if(hasOpposingPawn(board, row - 1, col + 1, king.getColor())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This is a helper method used to determine whether the there is an opposing Pawn
     * chess piece located at the board in the given position.
     *
     * @return - true, if there is an opposing pawn in the given position
     *         - false, otherwise
     */
    private boolean hasOpposingPawn(ChessPiece[][] board, int row, int col, String color){
        if (board[row][col] != null) {
            return !(board[row][col].getColor().equals(color)) &&
                    board[row][col] instanceof Pawn;
        }
        return false;
    }
}
