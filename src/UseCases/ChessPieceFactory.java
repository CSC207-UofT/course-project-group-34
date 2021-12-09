package UseCases;

import Entities.Bishop;
import Entities.ChessPiece;
import Entities.Knight;
import Entities.Queen;
import Entities.Rook;
import Entities.Pawn;
import Entities.King;

/**
 * This class uses the Simple Factory design pattern in order to return an instance
 * of chess piece. It is responsible for transforming a pawn into another chess piece
 * of the player's choosing.
 */
public class ChessPieceFactory {

    /**
     * This method takes in string value, transformType and a Pawn chess piece.
     * It creates an instance of a chess piece based upon the transformType and
     * sets its constructor values to those held by the pawn.
     *
     * @param transformType - a string value representing the chess piece instance to create
     * @param piece - a chess piece object whose attributes will be transferred to the new chess piece
     * @return - an instance of a chess piece
     */
    public ChessPiece getChessPiece(String transformType, ChessPiece piece){

        // Unpacking necessary attributes from the Chess piece
        int row = piece.getRow();
        int col = piece.getColumn();
        String color = piece.getColor();

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
        else if(transformType.equalsIgnoreCase("PAWN")){
            return new Pawn(row, col, color);
        }
        else if(transformType.equalsIgnoreCase("KING")){
            return new King(row, col, color);
        }
        else {
            System.out.println(transformType + " is an undefined chess piece for this program.");
            return null;
        }
    }

    /**
     * This method takes in a chess piece instance and returns an exact copy of that instance, with
     * a different memory adress.
     */
    public ChessPiece getCopy(ChessPiece currPiece){

        if(currPiece.getLetter() == 'p' || currPiece.getLetter() == 'P'){
            return this.getChessPiece("PAWN", currPiece);
        }
        if(currPiece.getLetter() == 'q' || currPiece.getLetter() == 'Q'){
            return this.getChessPiece("QUEEN", currPiece);
        }
        if(currPiece.getLetter() == 'k' || currPiece.getLetter() == 'K'){
            return this.getChessPiece("KNIGHT", currPiece);
        }
        if(currPiece.getLetter() == 'r' || currPiece.getLetter() == 'R'){
            return this.getChessPiece("ROOK", currPiece);
        }
        if(currPiece.getLetter() == 'b' || currPiece.getLetter() == 'B'){
            return this.getChessPiece("BISHOP", currPiece);
        }
        return this.getChessPiece("KING", currPiece);
    }

}
