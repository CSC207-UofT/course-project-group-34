package UseCases.Checkmate;

import Entities.Bishop;
import Entities.ChessPiece;
import Entities.Knight;
import Entities.Pawn;
import Entities.Queen;
import Entities.Rook;
import Entities.King;
import Other.GameState;

import java.util.List;

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
    public boolean isCheckmate(){
        // TO-DO: implement this method



        return false;
    }
}
