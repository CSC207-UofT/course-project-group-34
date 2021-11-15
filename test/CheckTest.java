import Entities.King;
import Other.Checkmate.Checkmate;
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
    King king;

    // Testing that the Check class can identify that the King is in check after the moves written below
    @Before
    public void setupKingCheck() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[0][4];
        KingCheck = new Check();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 3, 3, 3};
        int[] arr3 = {7, 5, 3, 1};

        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
    }

    @Test(timeout = 100)
    public void testKingCheck() {
        assertTrue(KingCheck.isKingInCheck(king, state));
    }

    // Test that the King is in check during an empty game
    @Test(timeout = 100)
    public void testKingCheck2() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[0][4];
        KingCheck = new Check();

        assertFalse(KingCheck.isKingInCheck(king, state));
    }

    // Check to see if the king is in check after these moves
    @Test(timeout = 100)
    public void testKingCheckmate3() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[7][4];
        KingCheck = new Check();

        int[] arr1 = {6, 5, 4, 5};
        int[] arr2 = {1, 4, 2, 4};
        int[] arr3 = {6, 7, 5, 7};
        int[] arr4 = {0, 3, 4, 7};

        state.makeMove(arr1);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);

        assertTrue(KingCheck.isKingInCheck(king, state));
    }


}
