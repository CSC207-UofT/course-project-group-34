import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;


/**
 * This Class is responsible for testing the movements of our Knight chess
 * piece.
 */
public class KnightInitMoveTest {

    GameState state;


    // Testing that the Knight piece can move at the beginning of the game, specifically 2 units up and 1
    //to the right
    @Before
    public void setupRightMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testRightMove() {
        int[] arr = {7, 1, 5, 2};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(5, 2));
    }

    // Testing that the Knight piece can move at the beginning of the game, specifically 2 units up and 1
    //to the left
    @Before
    public void setupLeftMove() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testLeftMove() {
        int[] arr = {7, 1, 5, 0};
        state.makeMove(arr);
        assertEquals('k', state.getChessPieceLetter(5, 0));
    }


    // Testing that the Knight piece can move 2 units to the right and 1 unit up
    @Test(timeout = 100)
    public void testMoveTwo() {
        int[] arr = {7, 1, 5, 2};
        int[] arr2 = {1, 0, 3, 0};
        int[] arr3 = {5, 2, 4, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('k', state.getChessPieceLetter(4, 4));
    }


    // Testing that the Knight piece can move 2 units to the left and 1 unit down
    @Test(timeout = 100)
    public void testMoveThree() {
        int[] arr = {7, 1, 5, 2};
        int[] arr2 = {1, 0, 3, 0};
        int[] arr3 = {5, 2, 4, 4};
        int[] arr4 = {1, 1, 3, 1};
        int[] arr5 = {4, 4, 5, 2};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        assertEquals('k', state.getChessPieceLetter(5, 2));
    }
}
