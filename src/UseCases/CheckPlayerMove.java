package UseCases;

import Entities.ChessPiece;
import Other.GameState;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class CheckPlayerMove {
    
    abstract int[][] validMoves(ChessPiece piece, GameState gameState); 
    
    public boolean checkMove(int newRow, int newColumn, ChessPiece piece, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves(piece, gameState);
        
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
}
