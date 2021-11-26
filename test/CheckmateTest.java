import Entities.King;
import UseCases.Checkmate.Checkmate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;

/**
 * This Class is responsible for testing that the program is able to correctly identify when the King piece
 * is declared to be in check.
 */
public class CheckmateTest {
    GameState state;
    Checkmate checkmate;
    King king;

    // Testing that the Check class can identify that the King is in checkmate after the moves written below
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
        assertTrue(checkmate.isCheckmate(king, state.getBoard()));
    }

    // Testing to see if checkmate can recognize that the game is not in checkmate
    @Test(timeout = 100)
    public void testKingCheckmate2() {
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

        assertFalse(checkmate.isCheckmate(king, state.getBoard()));
    }

    // Testing to see if checkmate can recognize that the game is not in checkmate
    @Test(timeout = 100)
    public void testKingCheckmate3() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[7][4];
        checkmate = new Checkmate();

        assertFalse(checkmate.isCheckmate(king, state.getBoard()));
    }

    // Check to see if the black king is not in checkmate, but it is in check
    @Test(timeout = 100)
    public void testKingCheckmate4() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[0][4];
        Checkmate checkmate = new Checkmate();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 3, 3, 3};
        int[] arr3 = {7, 5, 3, 1};

        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);

        assertFalse(checkmate.isCheckmate(king, state.getBoard()));
    }
}
