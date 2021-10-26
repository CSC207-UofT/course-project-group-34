package UseCases; 

import Entities.Bishop;
import Entities.ChessPiece; 
import Other.GameState; 

import java.util.ArrayList; 

public class CheckBishopMove extends CheckPlayerMove {

    public CheckBishopMove() { } 
    
    public int[][] validMoves(Bishop bishop, GameState gameState) { 
        ArrayList result = new ArrayList(); 
        int row = bishop.getRow(); 
        int column = bishop.getColumn(); 
        ChessPiece[][] board = gameState.getBoard(); 

        // Moving up & right 
        int currentRow = row - 1;
        int currentColumn = column + 1;
        while (currentRow > -1 && currentColumn < 8 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow--;
            currentColumn++;
        } 

        if (currentRow > -1 && currentColumn < 8) { 
            result.add({currentRow, currentColumn}); 
        }

        // Moving down & right
        int currentRow = row + 1;
        int currentColumn = column + 1;
        while (currentRow < 8 && currentColumn < 8 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow++;
            currentColumn++;
        } 

        if (currentRow < 8 && currentColumn < 8) { 
            result.add({currentRow, currentColumn}); 
        }

        // Moving down & left 
        int currentRow = row + 1;
        int currentColumn = column - 1;
        while (currentRow < 8 && currentColumn > -1 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow++;
            currentColumn--;
        } 

        if (currentRow < 8 && currentColumn > -1) { 
            result.add({currentRow, currentColumn}); 
        }

        // Moving up & left 
        int currentRow = row - 1;
        int currentColumn = column - 1;
        while (currentRow > -1 && currentColumn > -1 && board[currentRow][currentColumn] == null) { 
            result.add({currentRow, currentColumn});
            currentRow--;
            currentColumn--;
        } 

        if (currentRow > -1 && currentColumn > -1) { 
            result.add({currentRow, currentColumn}); 
        }

        return result;
    }

    public boolean checkMove(int newRow, int newColumn, ChessPiece bishop, GameState gameState) {
        int[] desiredMove = {newRow, newColumn};
        int[][] possibleMoves = validMoves((Bishop) bishop, gameState);
        
        for (int[] move : possibleMoves) {
            if (Arrays.equals(desiredMove, move)) {
                return true;
            }
        }

        return false;
    }
  
}
