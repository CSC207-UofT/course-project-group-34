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

        // If the King is not in check initially, return false early on
        Check check = new Check();
        if(!(check.isKingInCheck(king, state))){
            return false;
        }

        // Generate list of valid moves for the King piece and keeping track of its original position
        CheckKingMove checkMoves = new CheckKingMove();
        int[][] validMoves = checkMoves.validMoves(king, state);
        int row = king.getRow();
        int col = king.getColumn();

        for(int[] move : validMoves) {
            // Loops through each valid move, and determining whether the king is still in check or not.
            state.makeMove(new int[]{row, col, move[0], move[1]});
            if(!(check.isKingInCheck(king, state))){
                state.makeMove(new int[]{move[0], move[1], row, col});
                return false;
            }
            state.makeMove(new int[]{move[0], move[1], row, col});
        }
        return true;
    }
}
