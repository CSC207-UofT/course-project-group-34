package UseCases; 

import Entities.Knight;
import Entities.ChessPiece; 
import Other.GameState; 

import java.util.ArrayList; 
import java.util.Arrays;

public class CheckKnightMove extends CheckPlayerMove {

    public CheckKnightMove() { } 
    
    public int[][] validMoves(Knight knight, GameState gameState) { 
        ArrayList result = new ArrayList(); 
        int row = knight.getRow(); 
        int column = knight.getColumn(); 
        ChessPiece[][] board = gameState.getBoard(); 

        if (row - 2 > -1 && column -1 > -1) {
            result.add(new int[] {row - 2, column + 1});
        }

        if (row - 2 > -1 && column + 1 < 8) {
            result.add(new int[] {row - 2, column - 1});
        }

        if (row - 1 > -1 && column + 2 < 8) {
            result.add(new int[] {row - 1, column + 2});
        }

        if (row + 1 < 8 && column + 2 < 8) {
            result.add(new int[] {row + 1, column + 2});
        }

        if (row + 2 < 8 && column + 1 < 8) {
            result.add(new int[] {row + 2, column + 1}); 
        }

        if (row + 2 < 8 && column - 1 > -1) {
            result.add(new int[] {row + 2, column - 1}); 
        }

        if (row + 1 < 8 && column - 2 > -1) {
            result.add(new int[] {row + 1, column - 2});
        }

        if (row - 1 > -1 && column - 2 > -1) {
            result.add(new int[] {row - 1, column - 2});
        }

        int[][] array = result.toArray();
        return array;

    }

    public boolean checkMove(int newRow, int newColumn, ChessPiece knight, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves((Knight) knight, gameState);
        
        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }

        return false;
    }
  
}