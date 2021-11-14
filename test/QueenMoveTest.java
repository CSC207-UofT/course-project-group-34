import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Entities.*;
import Entities.ChessPiece;
import Other.GameState;
import Other.LoadGame;

/**
 * This Class is responsible for testing the movements of our Queen chess
 * piece.
 */

public class QueenMoveTest {
    GameState state;

    // Ensuring the Queen cannot move during the start of the game
    @Before
    public void setUpInvalidMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testInvalidMove() {
        int[] arr = {7, 3, 5, 3};
        assertFalse(state.makeMove(arr));
    }



    // Testing that the Queen piece can make a move up
    @Before
    public void setUpMoveUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        state.makeMove(arr);
        state.makeMove(arr2);

    }

    @Test(timeout = 100)
    public void testMoveUp() {
        int[] arr = {7, 3, 5, 3};
        state.makeMove(arr);
        assertEquals('q', state.getChessPieceLetter(5, 3));
    }



    // Testing that the Queen piece can make a move down
    @Before
    public void setUpMoveDown() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);

    }

    @Test(timeout = 100)
    public void testMoveDown() {
        int[] arr = {5, 3, 7, 3};
        state.makeMove(arr);
        assertEquals('q', state.getChessPieceLetter(7, 3));
    }



    // Testing that the Queen piece can make a move to the right
    @Before
    public void setUpMoveRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    @Test(timeout = 100)
    public void testMoveRight() {
        int[] arr = {5, 3, 5, 6};
        state.makeMove(arr);
        assertEquals('q', state.getChessPieceLetter(5, 6));
    }



    // Testing that the Queen piece can make a move to the left
    @Before
    public void setUpMoveLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    @Test(timeout = 100)
    public void testMoveLeft() {
        int[] arr = {5, 3, 5, 1};
        state.makeMove(arr);
        assertEquals('q', state.getChessPieceLetter(5, 1));
    }



    // Testing that the Queen piece can make a diagonal move up and to the right
    @Before
    public void setUpMoveDiagonalRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    @Test(timeout = 100)
    public void testMoveDiagonalRight() {
        int[] arr = {5, 3, 3, 5};
        state.makeMove(arr);
        assertEquals('q', state.getChessPieceLetter(3, 5));
    }



    // Testing that the Queen piece can make a diagonal move up and to the left
    @Before
    public void setUpMoveDiagonalLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 3, 4, 3};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 5, 3};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    @Test(timeout = 100)
    public void testMoveDiagonalLeft() {
        int[] arr = {5, 3, 3, 1};
        state.makeMove(arr);
        assertEquals('q', state.getChessPieceLetter(3, 1));
    }

}






