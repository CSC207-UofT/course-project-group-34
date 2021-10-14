import org.junit.Before;
import org.junit.Test;
import java.util.List;

//Create a board 

//Move a pawn 

//test to check if the postion we moved the pawn into is the correct one

}

public class testValidPawnMove {

    GameState state;

    @Before
    public void setUp() {
        LoadGame init = new LoadGame();
        state = init.loadGame();
    }

    @Test(timeout = 100)
    public void testMove() {
        int[] arr = [3, 6, 3, 4];
        state.makeMove(arr);
        assertTrue(state.getBoard()[3][6] == null);
    }
}