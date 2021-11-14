import Entities.King;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;
import Other.Checkmate.Check;


/**
 * This Class is responsible for testing that the program is able to correctly identify when the King piece
 * is declared to be in check.
 */
public class CheckTest {
    GameState state;
    Check KingCheck;

    // Testing that the Check class can identify that the King is in check after the moves written below
    @Before
    public void setupKingCheck() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        KingCheck = new Check();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 3, 3, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
    }

    @Test(timeout = 100)
    public void testKingCheck() {
        int[] arr = {7, 5, 3, 1};
        state.makeMove(arr);
        assertTrue(KingCheck.isKingInCheck((King) state.getBoard()[4][0], state));
    }
}
