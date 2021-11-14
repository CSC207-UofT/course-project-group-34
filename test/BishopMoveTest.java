import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;


/**
 * This Class is responsible for testing the movements of our Bishop chess
 * piece.
 */
public class BishopMoveTest {

    GameState state;


    // Testing that the Bishop piece can move diagonally up and to the right
    @Before
    public void setupMoveDiagonalUpRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMoveDiagonalUpRight() {
        int[] arr = {6, 6, 4, 6};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 5, 5, 7};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('b', state.getChessPieceLetter(5, 7));
    }



    // Testing that the Bishop piece can move diagonally up and to the left
    @Before
    public void setupMoveDiagonalUpLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

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
    @Before
    public void setupMoveDiagonalDownRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMoveDiagonalDownRight() {
        int[] arr = {1, 3, 3, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {0, 2, 2, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('B', state.getChessPieceLetter(2, 4));
    }



    // Testing that the Bishop piece can move diagonally down and to the left
    @Before
    public void setupMoveDiagonalDownLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMoveDiagonalDownLeft() {
        int[] arr = {1, 1, 3, 1};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {0, 2, 2, 0};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('B', state.getChessPieceLetter(2, 0));
    }
}
