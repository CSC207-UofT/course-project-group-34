package Controllers;

import Controllers.GameState;
import Entities.ChessPiece;
import UseCases.ChessPieceFactory;

/**
 * This class creates a CopyState object which takes in a gamestate object and returns a duplicate of it.
 * Intended use for when designing an undo-feature.
 */
public class CopyState {

    /**
     * This method takes in a GameState and iterates through every position in its chessboard
     * and adds a duplicate of each chess piece within the same position in a new GameState object.
     *
     * Returns a duplicate of the GameState object given as a parameter.
     */
    public GameState copyState(GameState state){
        ChessPiece[][] currBoard = state.getBoard();
        GameState newState = new GameState();
        ChessPieceFactory factory = new ChessPieceFactory();

        // Iterating through each position
        for(int i = 0; i < 8; i++){
             for(int y = 0; y < 8; y++){

                 // Uses the ChessPieceFactory's .getCopy() method to create and
                 // store duplicate chess pieces
                 if(currBoard[i][y] != null){
                     ChessPiece piece = factory.getCopy(currBoard[i][y]);
                     newState.addChessPiece(piece);
                 }
             }
        }
        return newState;
    }
}
