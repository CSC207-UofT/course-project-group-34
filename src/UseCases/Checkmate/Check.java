package UseCases.Checkmate;

import Entities.*;
import UseCases.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is responsible for determining whether a given King chess piece is in Check or not.
 * Recall that a King is in check when it is in a viable position to be "captured" by an opposing
 * player's piece.
 */
public class Check{

    // Instance attribute that specifies the positions on the chess board that lead up to the
    // opposing chess piece that is putting the King in Check.
    private int[][] positions;

    // Instance attribute that contains the opposing piece the King is being put in
    // check by
    private ChessPiece checkedBy;

    public boolean isKingInCheck(King king, ChessPiece[][] board){

        // Error checking
        if (king == null){
            return false;
        }

        // Loop through each position in our chessboard, if there is an opposing chess
        // piece in any position, check to see if it has our given King in check.
        for(int i = 0; i < 8; i++){
            for(int y = 0; y < 8; y++) {
                if (board[i][y] != null && (!(board[i][y].getColor().equals(king.getColor())) &&
                        (!(board[i][y].getLetter() == Character.toChars(0x0198)[0]) &&
                                !(board[i][y].getLetter() == Character.toChars(0x0199)[0])))){

                    // Generate list of all valid moves, if any of those moves correspond with the King's
                    // Location, we know that the king is in check
                    ChessPiece piece = board[i][y];
                    if (hasKingInCheck(king, piece, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * A helper method that returns True if there is an opposing piece that can viably attack the
     * given King chess piece, and False otherwise.
     */
    private boolean hasKingInCheck(King king, ChessPiece piece, ChessPiece[][] board){
        int[][] validMoves = generateValidMoves(piece, board);

        // If the king's position corresponds to a position in valid moves,
        // we know that the King is in check by this piece.
        int[] pos = {king.getRow(), king.getColumn()};
        for(int[] opposingPos : validMoves){
            if(Arrays.equals(opposingPos, pos)){
                this.checkedBy = piece;
                checkedPositions(king);
                return true;
            }
        }
        return false;
    }

    /**
     * A helper method that takes in a chess piece and a chess board and returns a
     * list of valid moves corresponding to that piece.
     */
    private int[][] generateValidMoves(ChessPiece piece, ChessPiece[][] board){
        CheckMoveFactory moveFactory = new CheckMoveFactory();
        CheckerGenerator checkerGen = new CheckerGenerator();
        CheckPlayerMove check = checkerGen.generateChecker(piece);
        return moveFactory.getValidMoves(check, piece, board);
    }

    /**
     * This method is only called when the given King is in check. It creates a 2D
     * integer array that specifies the positions on the chess board that lead up to the
     * opposing chess piece that is putting the King in Check. It then sets that 2D array
     * to our instance attribute, positions.
     */
    private void checkedPositions(King king){

       // If checkedBy is a pawn or knight, the only way to escape check is by capturing that
       // opposing chess piece.
       if(this.checkedBy.getLetter() == 'p' || this.checkedBy.getLetter() == 'P' ||
               this.checkedBy.getLetter() == 'k' || this.checkedBy.getLetter() == 'K'){
           this.positions = new int[][] {{this.checkedBy.getRow(), this.checkedBy.getColumn()}};
           return;
       }
       // Otherwise, if checkedBy is a Queen, Rook or Bishop, the only way to escape check is by
       // through either capturing checkedBy, or by blocking its path of attack.
       ArrayList<int[]> arr = new ArrayList<>();
       int[] checkedByPos = new int[] {this.checkedBy.getRow(), this.checkedBy.getColumn()};
       int[] pos = {this.checkedBy.getRow() - king.getRow(), this.checkedBy.getColumn() - king.getColumn()};
       if(diagonalPositions(arr, king.getRow(), king.getColumn(), checkedByPos, pos)){
           return;
       }
       straightPositions(arr, king.getRow(), king.getColumn(), checkedByPos, pos);
    }

    /**
     * If checkedBy is a chess piece than can move diagonally, then this method is responsible
     * for returning true when all the positions of it's capturing path have been stored in instance
     * attribute, positions. Returns false otherwise.
     */
    private boolean diagonalPositions(ArrayList<int[]> arr, int row, int col, int[] checkedByPos, int[] pos){
        // Determines the direction the opposing Queen or Bishop is in
        // and determines this.positions based off of it.
        if(pos[0] < 0 && pos[1] < 0){
            return positionExp(row, col, checkedByPos, arr, -1, -1);
        }
        else if(pos[0] < 0 && pos[1] > 0){
            return positionExp(row, col, checkedByPos, arr, -1, 1);
        }
        else if(pos[0] > 0 && pos[1] < 0){
            return positionExp(row, col, checkedByPos, arr, 1, -1);
        }
        else if(pos[0] > 0 && pos[1] > 0){
            return positionExp(row, col, checkedByPos, arr, 1, 1);
        }
        else{
            return false;
        }
    }

    /**
     * If checkedBy is a chess piece than can move in straights, then this method is responsible
     * for returning true when all the positions of it's capturing path have been stored in instance
     * attribute, positions. Returns false otherwise.
     */
    private void straightPositions(ArrayList<int[]> arr, int row, int col, int[] checkedByPos, int[] pos){
        // Determines the direction the opposing Queen or Rook is in
        // and determines this.positions based off of it.
        if(pos[0] < 0 && pos[1] == 0){
            positionExp(row, col, checkedByPos, arr, -1, 0);
        }
        else if(pos[0] == 0 && pos[1] > 0){
            positionExp(row, col, checkedByPos, arr, 0,  1);
        }
        else if(pos[0] == 0 && pos[1] < 0){
            positionExp(row, col, checkedByPos, arr, 0, -1);
        }
        else if(pos[0] > 0 && pos[1] == 0){
            positionExp(row, col, checkedByPos, arr, 1, 0);
        }
    }

    /**
     * This is a helper function used to append positions within the path that the King is
     * put in check from, to an Arraylist, arr.
     * @param inc1 - increment used for the row attribute within our while loop
     * @param inc2 - increment used for the col attribute within our while loop
     */
    private boolean positionExp(int row, int col, int[] pos, ArrayList<int[]> arr, int inc1, int inc2){
        do {
            row = row + inc1;
            col = col + inc2;

            arr.add(new int[] {row, col});
        } while (row != pos[0] && col != pos[1]);
        this.positions = toArrayMoves(arr);
        return true;
    }

    /**
     * This is a helper method that takes in an array list of integer arrays and
     * transforms its items into a 2d array of the same size, and then returns that array.
     */
    private int[][] toArrayMoves(ArrayList<int[]> arr){
        int[][] newArr = new int[arr.size()][];

        for(int i = 0; i < arr.size(); i ++){
            newArr[i] = arr.get(i);
        }
        return newArr;
    }

    /**
     * Getter method that returns the positions leading to an opposing chess piece that has the King in
     * check.
     */
    public int[][] getPositions(){
        return this.positions;
    }
}