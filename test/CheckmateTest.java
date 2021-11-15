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
public class CheckmateTest {
    GameState state;
    Checkmate checkmate;
    King king;

    // Testing that the Check class can identify that the King is in check after the moves written below
    @Before
    public void setupKingCheckMate() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[7][4];
        checkmate = new Checkmate();

        int[] arr = {6, 5, 4, 5};
        int[] arr2 = {1, 4, 2, 4};
        int[] arr3 = {6, 6, 4, 6};
        int[] arr4 = {0, 3, 4, 7};

        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    // Test to determine if Checkmate can identify when the gamestate is in checkmate
    @Test(timeout = 100)
    public void testKingCheckmate() {
        assertTrue(checkmate.isCheckmate(king, state));
    }

    // Loading a game where the gamestate is in check, but not checkmate
    @Before
    public void setupKingCheckMate2() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[7][4];
        checkmate = new Checkmate();

        int[] arr1 = {6, 5, 4, 5};
        int[] arr2 = {1, 4, 2, 4};
        int[] arr3 = {6, 7, 5, 7};
        int[] arr4 = {0, 3, 4, 7};

        state.makeMove(arr1);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    // Testing to see if checkmate can recognize that the game is not in checkmate
    @Test(timeout = 100)
    public void testKingCheckmate2() {
        assertFalse(checkmate.isCheckmate(king, state));
    }

}
