package UseCases;

import Entities.ChessPiece;
import Controllers.GameState;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is an abstract class responsible for verifying the validity of a given
 * chess move.
 */
public abstract class CheckPlayerMove {
    
    abstract int[][] validMoves(ChessPiece piece, GameState gameState);

    /**
     * This method verifies whether a given move is valid with respect to a given piece
     * and the current state of the board.
     */
    public boolean checkMove(int newRow, int newColumn, ChessPiece piece, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = this.validMoves(piece, gameState);
        
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
    protected int[][] toArrayMoves(ArrayList arr){
        int[][] newArr = new int[arr.size()][];

        for(int i = 0; i < arr.size(); i ++){
            newArr[i] = (int[]) arr.get(i);
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
}
