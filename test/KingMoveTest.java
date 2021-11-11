import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;

/**
 * This Class is responsible for testing the movements of our King chess
 * piece.
 */

public class KingMoveTest {
    GameState state;

    // Ensuring the King piece cannot move during the start of the game
    @Before
    public void setUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMove() {
        int[] arr = {7, 4, 5, 4};
        assertFalse(state.makeMove(arr));
    }



    // Testing that the King piece can make a move up
    @Before
    public void setUpMoveUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        state.makeMove(arr);
        state.makeMove(arr2);

    }

    @Test(timeout = 100)
    public void testMoveUp() {
        int[] arr = {7, 4, 6, 4};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(6, 4));
    }



    // Testing that the King piece can make a move down
    @Before
    public void setUpMoveDown() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);

    }

    @Test(timeout = 100)
    public void testMoveDown() {
        int[] arr = {6, 4, 7, 4};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(7, 4));
    }



    // Testing that the King piece can make a move to the right
    @Before
    public void setUpMoveRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
    }

    @Test(timeout = 100)
    public void testMoveRight() {
        int[] arr = {5, 4, 5, 5};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(5, 5));
    }



    // Testing that the King piece can make a move to the left
    @Before
    public void setUpMoveLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
    }

    @Test(timeout = 100)
    public void testMoveLeft() {
        int[] arr = {5, 4, 5, 3};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(5, 3));
    }



    // Testing that the King piece can make a diagonal move up and to the right
    @Before
    public void setUpMoveDiagonalRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
    }

    @Test(timeout = 100)
    public void testMoveDiagonalRight() {
        int[] arr = {5, 4, 4, 5};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(4, 5));
    }



    // Testing that the King piece can make a diagonal move up and to the left
    @Before
    public void setUpMoveDiagonalLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
    }

    @Test(timeout = 100)
    public void testMoveDiagonalLeft() {
        int[] arr = {5, 4, 4, 3};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(4, 3));
    }
}
