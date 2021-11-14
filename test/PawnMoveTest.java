import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;

/**
 * This Class is responsible for testing the movements of our Pawn chess
 * pieces.
 */
public class PawnMoveTest {

    GameState state;


    // Testing that the pawn can move two spaces up at the beginning of the game
    @Before
    public void setupMoveDouble() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMoveDouble() {
        int[] arr = {6, 3, 4, 3};
        state.makeMove(arr);
        assertNull(state.getBoard()[3][6]);
    }



    // Testing that the pawn can correctly attack another piece
    @Before
    public void setupAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 4, 3, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
    }

    @Test(timeout = 100)
    public void testAttack() {
        int[] arr = {4, 3, 3, 4};
        state.makeMove(arr);
        assertEquals('p', state.getChessPieceLetter(3, 4));
    }



    //Testing that the pawn cannot make an invalid move - in this case moving 2 spaces up when it is not in its
    // initial position
    @Before
    public void setupInvalidMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 4, 3, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
    }

    @Test(timeout = 100)
    public void testInvalidMove() {
        int[] arr = {4, 3, 2, 3};
        state.makeMove(arr);
        assertFalse(state.makeMove(arr));
    }
}
