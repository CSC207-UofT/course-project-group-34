package UseCases.Checkmate;

import Controllers.GameState;
import Entities.ChessPiece;
import UseCases.ChessPieceFactory;

/**
 * This class creates a CopyState object which takes in a gamestate object and returns a duplicate of it.
 * Intended use for when designing an undo-feature.
 */
public class CopyState {

    public GameState copyState(GameState state){
        ChessPiece[][] currBoard = state.getBoard();
        GameState newState = new GameState();
        ChessPieceFactory factory = new ChessPieceFactory();

        for(int i = 0; i < 8; i++){
             for(int y = 0; y < 8; y++){

                 if(currBoard[i][y] != null){
                     ChessPiece piece = factory.getCopy(currBoard[i][y]);
                     newState.addChessPiece(piece);
                 }
             }
        }
        return newState;
    }
}
