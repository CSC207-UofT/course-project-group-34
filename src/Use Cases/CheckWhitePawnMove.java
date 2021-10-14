public class CheckWhitePawnMove extends CheckPlayerMove {
    
    public int[][] validMoves(Pawn pawn, GameState gameState) {
        int[][] result = new int[4][2];
        int xPosition = pawn.getXPosition();
        int yPosition = pawn.getYPosition();
        ChessPiece[][] board = gameState.getBoard();
  
        // Check non-attack moves
        if (yPosition - 1 > -1 && board[xPosition][yPosition - 1] == null) {
            result[0] = {xPosition, yPosition - 1}; 
        }
        
        if (pawn.getHasMovedOnce() == false && yPosition - 2 > -1 && board[xPosition][yPosition - 1] == null && board[xPosition][yPosition - 2] == null) {
            result[1] = {xPosition, yPosition - 2};
        }
        
        // Check attack moves
        if (xPosition - 1 > -1 && yPosition - 1 > -1 && board[xPosition - 1][yPosition - 1] != null) {
            result[2] = {xPosition - 1, yPosition - 1};    
        }
        
        if (xPosition + 1 < 8 && yPosition - 1 > -1 && board[xPosition + 1][yPosition - 1] != null) {
            result[3] = {xPosition + 1, yPosition - 1};   
        }
        
        return result;
    }
    
    public boolean checkMove(int newXPosition, int newYPosition, Pawn pawn, GameState gameState) {
        int[] desiredMove = {newXPosition, newYPosition}; 
        int[][] possibleMoves = validMoves(pawn, gameState); 
        for (int[] move : possibleMoves) {
            if (desiredMove.equals(move)) {
                return true;   
            }
        }
        
        return false;
        
    } 
}
