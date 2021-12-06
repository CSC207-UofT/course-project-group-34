import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;

/**
 * This Class is responsible for testing if a special move between the King and
 * Rook piece known as castling works as intended
 */

public class CastlingTest {
    GameState state;
    char letter = Character.toChars(0x0199)[0];


    // Testing Kingside castling
    @Test(timeout = 100)
    public void testCastlingKingside() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 0, 3, 0};
        int[] arr3 = {7, 5, 5, 3};
        int[] arr4 = {1, 1, 3, 1};
        int[] arr5 = {7, 6, 5, 7};
        int[] arr6 = {1, 2, 3, 2};
        int[] arr7 = {7, 4, 7, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
        state.makeMove(arr7);
        assertTrue((letter == state.getChessPieceLetter(7, 6)) & ('r' == state.getChessPieceLetter(7, 5)));
    }


    // Testing Queenside castling
    @Test(timeout = 100)
    public void testCastlingQueenside() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {7, 1, 5, 0};
        int[] arr2 = {1, 0, 3, 0};
        int[] arr3 = {6, 3, 4, 3};
        int[] arr4 = {1, 1, 3, 1};
        int[] arr5 = {7, 2, 5, 4};
        int[] arr6 = {1, 2, 3, 2};
        int[] arr7 = {7, 3, 6, 3};
        int[] arr8 = {1, 3, 3, 3};
        int[] arr9 = {7, 4, 7, 2};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
        state.makeMove(arr7);
        state.makeMove(arr8);
        state.makeMove(arr9);
        assertTrue((letter == state.getChessPieceLetter(7, 2)) & ('r' == state.getChessPieceLetter(7, 3)));
    }


    // Testing that an invalid castling move cannot be made
    @Test(timeout = 100)
    public void testInvalidCastling() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 0, 3, 0};
        int[] arr3 = {7, 5, 5, 3};
        int[] arr4 = {1, 1, 3, 1};
        int[] arr5 = {7, 4, 7, 6};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        assertFalse(state.makeMove(arr5));
    }
}
