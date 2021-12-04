import Entities.ChessPiece;
import Controllers.CopyState;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Controllers.GameState;
import Controllers.LoadGame;

public class CopyStateTest {

    GameState state;

    @Before
    public void setUpCopyTest() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    // Testing to determine if the chessboard of the copy state and the chess board of the GameState
    // have different memory adresses.
    @Test(timeout = 100)
    public void testCopyGameStateHasSeparateMemoryAddress() {
        int[] arr = {6, 6, 4, 6};
        int[] arr2 = {1, 7, 3, 7};
        state.makeMove(arr);
        state.makeMove(arr2);

        CopyState copy = new CopyState();
        GameState copiedState = copy.copyState(state);

        assertNotSame(copiedState.getBoard(), state.getBoard());
    }

    // Test to determine if the copied state and the game state are not equal to one another
    // when a fresh state has been copied.
    @Test(timeout = 100)
    public void testCopyGameStateInital() {

        CopyState copy = new CopyState();
        GameState copiedState = copy.copyState(state);

        assertNotSame(copiedState.getBoard(), state.getBoard());
    }

    // Testing to ensure that the copied state has the same chess piece object within each position in its
    // chessboard, and that each object does not share the same memory address.
    @Test(timeout = 100)
    public void testCopyGameStateAndChessPieces() {
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

        CopyState copy = new CopyState();
        GameState copiedState = copy.copyState(state);
        ChessPiece[][] copyBoard = copiedState.getBoard();
        ChessPiece[][] board = state.getBoard();

        boolean cond = true;
        for(int i = 0; i < 8; i++){
            for(int y = 0; y < 8; y++ ){
                if(board[i][y] != null ){
                    if(!(board[i][y].getLetter() == copyBoard[i][y].getLetter()) ||
                            (board[i][y] == copyBoard[i][y])){
                        cond = false;
                    }
                }
            }
        }
        assertTrue(cond);
    }
}
