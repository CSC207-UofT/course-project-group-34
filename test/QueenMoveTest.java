import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;

/**
 * This Class is responsible for testing the movements of our Queen chess
 * piece.
 */

public class QueenMoveTest {
    GameState state;

    // Ensuring the Queen cannot move during the start of the game
    @Test(timeout = 100)
    public void testInvalidMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {7, 3, 5, 3};
        assertFalse(state.makeMove(arr));
    }


    // Testing that the Queen piece can make a move up
    @Test(timeout = 100)
    public void testMoveUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('q', state.getChessPieceLetter(5, 3));
    }



    // Testing that the Queen piece can make a move down
    @Test(timeout = 100)
    public void testMoveDown() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 3, 7, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('q', state.getChessPieceLetter(7, 3));
    }



    // Testing that the Queen piece can make a move to the right
    @Test(timeout = 100)
    public void testMoveRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 3, 5, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('q', state.getChessPieceLetter(5, 6));
    }



    // Testing that the Queen piece can make a move to the left
    @Test(timeout = 100)
    public void testMoveLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 3, 5, 1};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('q', state.getChessPieceLetter(5, 1));
    }



    // Testing that the Queen piece can make a diagonal move up and to the right
    @Test(timeout = 100)
    public void testMoveDiagonalRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 3, 3, 5};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('q', state.getChessPieceLetter(3, 5));
    }



    // Testing that the Queen piece can make a diagonal move up and to the left
    @Test(timeout = 100)
    public void testMoveDiagonalLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {5, 3, 3, 1};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('q', state.getChessPieceLetter(3, 1));
    }
}






