package Other;

import Entities.Bishop;
import Entities.ChessPiece;
import Entities.King;
import Entities.Knight;
import Entities.Pawn;
import Entities.Queen;
import Entities.Rook;

/**
* This class is responsible for initializing a new chess game, and returning
* the gameState that represents that game to the user. 
*/
public class LoadGame {

    /**
     * This method initializes a new chess game by creating a GameState
     * and then setting up all 32 chess pieces in their correct locations.
     *
     * Black pieces are represented by uppercase letters and are situated at the
     * top of the board(starting at [0][0]) and white chess pieces are represented
     * by lowercase letters(starting at [0][6]).
     *
     * @return state
     */
    public GameState loadGame() {

        GameState state = new GameState();
        loadChessPieces(state, "black", 0, 1);
        loadChessPieces(state, "white", 7, 6);

        return state;
    }

    /**
     * This is a mutating method that takes in a new GameState object
     * and places 16 chess pieces of one team into its 2D array,
     * which represents the chessboard.
     *
     * @param state - an instance of a GameState object
     * @param color - color of the chess pieces being added
     * @return state
     */
    public void loadChessPieces(GameState state, String color, int row1, int row2){
        ChessPiece[] pieces = new ChessPiece[16];
        pieces[0] = new King(row1, 4, color);
        pieces[1] = new Queen(row1, 3, color);
        pieces[2] = new Rook(row1, 0, color);
        pieces[3] = new Rook(row1, 7, color);
        pieces[4] = new Bishop(row1, 2, color);
        pieces[5] = new Bishop(row1, 5,color);
        pieces[6] = new Knight(row1, 1, color);
        pieces[7] = new Knight(row1, 6, color);

        for(int i = 0; i < 8; i++){
            pieces[i + 8] = new Pawn(row2, i, color);
        }

        for (ChessPiece piece : pieces) {
            state.addChessPiece(piece);
        }
    }
}
