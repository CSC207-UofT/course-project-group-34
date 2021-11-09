import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;

public class KnightInitMoveTest {

    GameState state;

    @Before
    public void setUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMove() {
        int[] arr = {7, 1, 5, 2};
        state.makeMove(arr);
        assertTrue(state.getChessPieceLetter(5, 2) == 'k');
    }
}
