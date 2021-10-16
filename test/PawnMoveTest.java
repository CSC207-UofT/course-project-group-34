import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Other.GameState;
import Other.LoadGame;

/**
 * This Class is responsible for testing the movements of our Pawn chess
 * pieces.
 */
public class PawnMoveTest {

    GameState state;

    @Before
    public void setUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMove() {
        int[] arr = {6, 3, 4, 3};
        state.makeMove(arr);
        assertTrue(state.getBoard()[3][6] == null);
    }
}
