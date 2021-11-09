import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;

public class BishopMoveTest {

    GameState state;

    @Before
    public void setUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMove() {
        int[] arr = {6, 6, 4, 6};
        int[] arr2 = {1, 7, 3, 7};
        int[] arr3 = {7, 5, 5, 7};
        state.makeMove(arr);
        state.makeMove(arr2);
        state.makeMove(arr3);
        assertTrue(state.getChessPieceLetter(5, 7) == 'b');
    }
}
