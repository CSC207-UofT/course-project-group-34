package UseCases;

import Entities.Bishop;
import Entities.ChessPiece;
import Entities.Knight;
import Entities.Queen;
import Entities.Rook;

/**
 * This class uses the Simple Factory design pattern in order to return an instance
 * of chess piece. It is responsible for transforming a pawn into another chess piece
 * of the player's choosing.
 */
public class PawnFactory {

    /**
     * This method takes in string value, transformType and a Pawn chess piece.
     * It creates an instance of a chess piece based upon the transformType and
     * sets its constructor values to those held by the pawn.
     *
     * @param transformType - a string value representing the chess piece instance to create
     * @param pawn - a pawn value whose attributes will be transferred to the new chess piece
     * @return - an instance of a chess piece
     */
    public ChessPiece getChessPiece(String transformType, ChessPiece pawn){

        // Unpacking necessary attributes from the pawn piece
        int row = pawn.getRow();
        int col = pawn.getColumn();
        String color = pawn.getColor();

        // Returns the chess piece instance with said values
        if(transformType.equalsIgnoreCase("QUEEN")){
            return new Queen(row, col, color);
        }
        else if(transformType.equalsIgnoreCase("ROOK")){
            return new Rook(row, col, color);
        }
        else if(transformType.equalsIgnoreCase("BISHOP")){
            return new Bishop(row, col, color);
        }
        else if(transformType.equalsIgnoreCase("KNIGHT")){
            return new Knight(row, col, color);
        }
        else {
            return null;
        }
    }
}
