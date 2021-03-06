import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;

/**
 * This Class is responsible for testing the movements of our Pawn chess
 * pieces.
 */
public class PawnMoveTest {

    GameState state;

    // Testing that the pawn can move two spaces up at the beginning of the game
    @Test(timeout = 100)
    public void testMoveDouble() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        state.makeMove(arr);
        assertEquals('p', state.getChessPieceLetter(4, 3));
    }


    // Testing that the pawn can correctly attack another piece
    @Test(timeout = 100)
    public void testAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 4, 3, 4};
        int[] arr3 = {4, 3, 3, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('p', state.getChessPieceLetter(3, 4));
    }


    //Testing that the pawn cannot make an invalid move - in this case moving 2 spaces up when it is not in its
    // initial position
    @Test(timeout = 100)
    public void testInvalidMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 4, 3, 4};
        int[] arr3 = {4, 3, 2, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        assertFalse(state.makeMove(arr3));
    }
}
