import Entities.King;
import Entities.Queen;
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
    public void setupWhiteKingInBasicCheckMate() {
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
    public void testWhiteKingInBasicCheckmate() {
        assertTrue(checkmate.isCheckmate(king, state.getBoard()));
    }

    // Testing to see if checkmate can recognize that the King is in Check, but not Checkmate
    @Test(timeout = 100)
    public void testWhiteKingCheckButNotCheckmate() {
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

    // Testing to see if checkmate can recognize that a fresh state of the game is
    // not in checkmate
    @Test(timeout = 100)
    public void testInitialGameIsNotInCheckmate() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[7][4];
        checkmate = new Checkmate();

        assertFalse(checkmate.isCheckmate(king, state.getBoard()));
    }

    // Check to see if the black king is not in checkmate, but it is in check
    @Test(timeout = 100)
    public void testBlackKingCheckButNotCheckmate() {
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

    // Test to determine whether the Black King can escape Checkmate when
    // the White Queen captures the enemy piece blocking it's path.
    @Test(timeout = 100)
    public void testBlackKingCanEscapeCheckmate() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        king = (King) state.getBoard()[0][4];
        Checkmate checkmate = new Checkmate();

        int[] arr = {6, 5, 4, 5};
        int[] arr2 = {1, 4, 3, 4};
        int[] arr3 = {6, 6, 5, 6};
        int[] arr4 = {0, 3, 4, 7};
        int[] arr5 = {7, 4, 6, 5};
        int[] arr6 = {4, 7, 5, 6};

        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);

        assertFalse(checkmate.isCheckmate(king, state.getBoard()));
    }
}
