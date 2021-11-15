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
    char letter = Character.toChars(0x0199)[0];


    // Testing that the King Piece cannot make an invalid move
    @Test(timeout = 100)
    public void testInvalidMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {7, 4, 5, 4};
        assertFalse(state.makeMove(arr));
    }

    // Testing that the King piece can make a move up
    @Test(timeout = 100)
    public void testMoveUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals(letter, state.getChessPieceLetter(6, 4));
    }


    // Testing that the King piece can make a move down
    @Test(timeout = 100)
    public void testMoveDown() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 7, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals(letter, state.getChessPieceLetter(7, 4));
    }


    // Testing that the King piece can make a move to the right
    @Test(timeout = 100)
    public void testMoveRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        int[] arr7 = {5, 4, 5, 5};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
        state.makeMove(arr7);
        assertEquals(letter, state.getChessPieceLetter(5, 5));
    }


    // Testing that the King piece can make a move to the left
    @Test(timeout = 100)
    public void testMoveLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        int[] arr7 = {5, 4, 5, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
        state.makeMove(arr7);
        assertEquals(letter, state.getChessPieceLetter(5, 3));
    }



    // Testing that the King piece can make a diagonal move up and to the right
    @Test(timeout = 100)
    public void testMoveDiagonalRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        int[] arr7 = {5, 4, 4, 5};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
        state.makeMove(arr7);
        assertEquals(letter, state.getChessPieceLetter(4, 5));
    }


    // Testing that the King piece can make a diagonal move up and to the left
    @Test(timeout = 100)
    public void testMoveDiagonalLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 4, 6, 4};
        int[] arr4 = {1, 6, 3, 6};
        int[] arr5 = {6, 4, 5, 4};
        int[] arr6 = {1, 0, 3, 0};
        int[] arr7 = {5, 4, 4, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
        state.makeMove(arr7);
        assertEquals(letter, state.getChessPieceLetter(4, 3));
    }
}
