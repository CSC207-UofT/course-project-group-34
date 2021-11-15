import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;


/**
 * This Class is responsible for testing the movements of our Rook chess
 * piece.
 */
public class RookMoveTest {

    GameState state;


    // Testing that the Rook piece can move up
    @Before
    public void setupMoveUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

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
    @Before
    public void setupMoveDown() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 7, 4, 7};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 7, 5, 7};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    @Test(timeout = 100)
    public void testMoveDown() {
        int[] arr = {5, 7, 7, 7};
        state.makeMove(arr);
        assertEquals('r', state.getChessPieceLetter(7, 7));
    }



    // Testing that the Rook piece can move to the left
    @Before
    public void setupMoveLeft() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 7, 4, 7};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 7, 5, 7};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    @Test(timeout = 100)
    public void testMoveLeft() {
        int[] arr = {5, 7, 5, 3};
        state.makeMove(arr);
        assertEquals('r', state.getChessPieceLetter(5, 3));
    }



    // Testing that the Rook piece can move to the right
    @Before
    public void setupMoveRight() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 0, 4, 0};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 0, 5, 0};
        int[] arr4 = {1, 6, 3, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
    }

    @Test(timeout = 100)
    public void testMoveRight() {
        int[] arr = {5, 0, 5, 3};
        state.makeMove(arr);
        assertEquals('r', state.getChessPieceLetter(5, 3));
    }

}
