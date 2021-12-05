import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;


/**
 * This Class is responsible for testing the movements of our Rook chess
 * piece.
 */
public class RookMoveTest {

    GameState state;


    @Before
    public void setupMoveUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }


    // Testing that the Rook piece can move up
    @Test(timeout = 100)
    public void testMoveUp() {
        int[] arr = {6, 7, 4, 7};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 7, 5, 7};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('r', state.getChessPieceLetter(5, 7));
    }


    // Testing that the Rook piece can move down
    @Test(timeout = 100)
    public void testMoveDown() {
        int[] arr = {6, 7, 4, 7};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 7, 5, 7};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 7, 7, 7};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('r', state.getChessPieceLetter(7, 7));
    }


    // Testing that the Rook piece can move to the left
    @Test(timeout = 100)
    public void testMoveLeft() {
        int[] arr = {6, 7, 4, 7};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 7, 5, 7};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 7, 5, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('r', state.getChessPieceLetter(5, 3));
    }


    // Testing that the Rook piece can move to the right
    @Test(timeout = 100)
    public void testMoveRight() {
        int[] arr = {6, 0, 4, 0};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 0, 5, 0};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 0, 5, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('r', state.getChessPieceLetter(5, 3));
    }
}
