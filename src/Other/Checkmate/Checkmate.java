package Other.Checkmate;

import Entities.King;
import Other.GameState;
import UseCases.CheckKingMove;

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
        Check check = new Check();
        if(!(check.isKingInCheck(king, state))){
            return false;
        }
        CheckKingMove checkMoves = new CheckKingMove();
        int[][] validMoves = checkMoves.validMoves(king, state);
        int row = king.getRow();
        int col = king.getColumn();

        // Go through each move within valid moves, move the King piece to that spot,
        // Determine whether the King is still in check after it moves to that spot,
        // if the King is still in Check, move on to the next move and repeat.
        // if the king is no longer in check for a certain valid move, move the king back
        // to its original position and return false,
        // otherwise, if there are no valid moves where the king can escape check, return True.

        for(int[] move : validMoves) {
            // Gamestate function that moves the king to the valid move
            if(!(check.isKingInCheck(king, state))){
                return false;
            }
            
        }
        
        // Gamestate function that returns the King checker to it's original position
        
        return true;
    }
}
