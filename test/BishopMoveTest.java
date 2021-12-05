import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;

public class BishopMoveTest {

    GameState state;

    @Before
    public void setUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    // Ensuring the leftmost Bishop cannot move during the start of the game
    @Test(timeout = 100)
    public void testLeftInvalidMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {7, 2, 5, 2};
        assertFalse(state.makeMove(arr));
    }

    // Ensuring the rightmost Bishop cannot move during the start of the game
    @Test(timeout = 100)
    public void testRightInvalidMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {7, 5, 5, 5};
        assertFalse(state.makeMove(arr));
    }

    // Testing that the Bishop piece can move diagonally up and to the right
    @Test(timeout = 100)
    public void testMoveDiagonalUpRight() {
        int[] arr = {6, 6, 4, 6};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 5, 5, 7};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertTrue(state.getChessPieceLetter(5, 7) == 'b');
    }


    // Testing that the Bishop piece can move diagonally up and to the left
    @Test(timeout = 100)
    public void testMoveDiagonalUpLeft() {
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 5, 3, 1};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('b', state.getChessPieceLetter(3, 1));
    }


    // Testing that the Bishop piece can move diagonally down and to the right
    @Test(timeout = 100)
    public void testMoveDiagonalDownRight() {
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 5, 3, 1};
        int[] arr4 = {1, 0, 3, 0};
        int[] arr5 = {3, 1, 7, 5};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('b', state.getChessPieceLetter(7, 5));
    }


    // Testing that the Bishop piece can move diagonally down and to the left
    @Test(timeout = 100)
    public void testMoveDiagonalDownLeft() {
        int[] arr = {6, 6, 4, 6};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 5, 5, 7};
        int[] arr4 = {1, 0, 3, 0};
        int[] arr5 = {5, 7, 7, 5};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('b', state.getChessPieceLetter(7, 5));
    }
}
