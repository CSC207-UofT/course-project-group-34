import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;

/**
 * This Class is responsible for testing that the pieces are able to correctly attack and
 * capture other pieces, while also ensuring that the board is updated appropriately as well.
 *
 *
 * Note: These tests also help identify if a known bug that was initially present in which pieces would randomly
 * disappear during attacking is still present within the code or not.
 */
public class AttackCaptureTest {

    GameState state;
    char letter = Character.toChars(0x0199)[0];


    // Testing that the Pawn piece can attack correctly and that the board updates accordingly.
    @Test(timeout = 100)
    public void testPawnAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 1, 4, 1};
        int[] arr2 = {1, 2, 3, 2};
        int[] arr3 = {4, 1, 3, 2};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('p', state.getChessPieceLetter(3, 2));
    }



    // Testing that the Bishop piece can attack correctly and that the board updates accordingly.
    @Test(timeout = 100)
    public void testBishopAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 0, 2, 0};
        int[] arr3 = {7, 5, 2, 0};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('b', state.getChessPieceLetter(2, 0));
    }



    // Testing that the Knight piece can attack correctly and that the board updates accordingly.
    @Test(timeout = 100)
    public void testKnightAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {7, 6, 5, 5};
        int[] arr2 = {1, 4, 3, 4};
        int[] arr3 = {5, 5, 3, 4};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('k', state.getChessPieceLetter(3, 4));
    }



    // Testing that the Rook piece can attack correctly and that the board updates accordingly.
    @Test(timeout = 100)
    public void testRookAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 1, 4, 1};
        int[] arr2 = {1, 0, 3, 0};
        int[] arr3 = {4, 1, 3, 0};
        int[] arr4 = {0, 0, 3, 0};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        assertEquals('R', state.getChessPieceLetter(3, 0));
    }



    // Testing that the Queen piece can attack correctly and that the board updates accordingly.
    @Test(timeout = 100)
    public void testQueenAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 4, 4, 4};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 3, 3, 7};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertEquals('q', state.getChessPieceLetter(3, 7));
    }



    // Testing that the King piece can attack correctly and that the board updates accordingly.
    @Test(timeout = 100)
    public void testKingAttack() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
        int[] arr = {6, 0, 4, 0};
        int[] arr2 = {1, 6, 2, 6};
        int[] arr3 = {6, 1, 4, 1};
        int[] arr4 = {0, 5, 2, 7};
        int[] arr5 = {4, 1, 3, 1};
        int[] arr6 = {2, 7, 6, 3};
        int[] arr7 = {7, 4, 6, 3};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        state.makeMove(arr4);
        state.makeMove(arr5);
        state.makeMove(arr6);
        state.makeMove(arr7);
        assertEquals(letter, state.getChessPieceLetter(6, 3));
    }
}
