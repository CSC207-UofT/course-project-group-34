package UseCases;

import Entities.ChessPiece;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is an abstract class responsible for verifying the validity of a given
 * chess move.
 */
public abstract class CheckPlayerMove {
    
    abstract int[][] validMoves(ChessPiece piece, ChessPiece[][] board);

    /**
     * This method verifies whether a given move is valid with respect to a given piece
     * and the current state of the board.
     */
    public boolean checkMove(int newRow, int newColumn, ChessPiece piece, ChessPiece[][] board) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = this.validMoves(piece, board);

        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is a helper method that takes in an array list if integer arrays and
     * transforms its items into a 2d array of the same size.
     */
    protected int[][] toArrayMoves(ArrayList<int[]> arr){
        int[][] newArr = new int[arr.size()][];

        for(int i = 0; i < arr.size(); i ++){
            newArr[i] = arr.get(i);
        }
        return newArr;
    }

    /**
     * This is a helper method that verifies whether two chess pieces are enemies.
     */
    protected boolean isEnemy(ChessPiece piece1, ChessPiece piece2) {
        String color1 = piece1.getColor();
        String color2 = piece2.getColor();
        return !color1.equals(color2);
    }

    /**
     * Returns a list of valid moves in the vertical or horizontal direction for a Rook or Queen
     * given the current state of the board.
     */
    protected ArrayList<int[]> verticalHorizontalMoves(ChessPiece piece, ChessPiece[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        int row = piece.getRow();
        int column = piece.getColumn();

        // Moving up
        int currentRow = row - 1;
        while (currentRow > -1 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column});
            currentRow--;
        }

        if (currentRow > -1 && isEnemy(piece, board[currentRow][column])) {
            result.add(new int[] {currentRow, column});
        }

        // Moving down
        currentRow = row + 1;
        while (currentRow < 8 && board[currentRow][column] == null) {
            result.add(new int[] {currentRow, column});
            currentRow++;
        }

        if (currentRow < 8 && isEnemy(piece, board[currentRow][column])) {
            result.add(new int[] {currentRow, column});
        }

        // Moving left
        int currentColumn = column - 1;
        while (currentColumn > -1 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn--;
        }

        if (currentColumn > -1 && isEnemy(piece, board[row][currentColumn])) {
            result.add(new int[] {row, currentColumn});
        }

        // Moving right
        currentColumn = column + 1;
        while (currentColumn < 8 && board[row][currentColumn] == null) {
            result.add(new int[] {row, currentColumn});
            currentColumn++;
        }

        if (currentColumn < 8 && isEnemy(piece, board[row][currentColumn])) {
            result.add(new int[] {row, currentColumn});
        }

        return result;
    }

    /**
     * Returns a list of valid diagonal moves for a Queen or Bishop given the current
     * state of the board.
     */
    protected ArrayList<int[]> diagonalMoves(ChessPiece piece, ChessPiece[][] board) {
        ArrayList<int[]> result = new ArrayList<>();
        int row = piece.getRow();
        int column = piece.getColumn();

        // Moving up & right
        int currentRow = row - 1;
        int currentColumn = column + 1;
        while (currentRow > -1 && currentColumn < 8 && board[currentRow][currentColumn] == null) {
            result.add(new int[] {currentRow, currentColumn});
            currentRow--;
            currentColumn++;
        }

        if (currentRow > -1 && currentColumn < 8 && isEnemy(piece, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn});
        }

        // Moving up & left
        currentRow = row - 1;
        currentColumn = column - 1;
        while (currentRow > -1 && currentColumn > -1 && board[currentRow][currentColumn] == null) {
            result.add(new int[] {currentRow, currentColumn});
            currentRow--;
            currentColumn--;
        }

        if (currentRow > -1 && currentColumn > -1 && isEnemy(piece, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn});
        }

        // Moving down & right
        currentRow = row + 1;
        currentColumn = column + 1;
        while (currentRow < 8 && currentColumn < 8 && board[currentRow][currentColumn] == null) {
            result.add(new int[] {currentRow, currentColumn});
            currentRow++;
            currentColumn++;
        }

        if (currentRow < 8 && currentColumn < 8 && isEnemy(piece, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn});
        }

        // Moving down & left
        currentRow = row + 1;
        currentColumn = column - 1;
        while (currentRow < 8 && currentColumn > -1 && board[currentRow][currentColumn] == null) {
            result.add(new int[] {currentRow, currentColumn});
            currentRow++;
            currentColumn--;
        }

        if (currentRow < 8 && currentColumn > -1 && isEnemy(piece, board[currentRow][currentColumn])) {
            result.add(new int[] {currentRow, currentColumn});
        }

        return result;
    }

}
