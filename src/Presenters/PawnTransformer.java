package Presenters;

import Entities.ChessPiece;
import UseCases.ChessPieceFactory;
import java.util.Scanner;

/**
 * This class is a controller responsible for taking in a pawn piece, and transforming in to another using
 * User input.
 */
public class PawnTransformer {
    public PawnTransformer() { }

    /**
     * This method takes in a board and a pawn from that board, and transforms that pawn into an instance of
     * another chess piece given by the user.
     */
    public ChessPiece[][] transform(ChessPiece pawn, ChessPiece[][] board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your pawn has reached the end of the board? Would you like to transform it into a " +
                "bishop, knight, queen, or rook?");
        String choice = sc.nextLine();
        ChessPieceFactory factory = new ChessPieceFactory();
        ChessPiece newPiece = factory.getChessPiece(choice, pawn);
        while (newPiece == null || (newPiece.getLetter() != 'b' && newPiece.getLetter() != 'B'
                && newPiece.getLetter() != 'k' && newPiece.getLetter() != 'K' && newPiece.getLetter() != 'q'
                && newPiece.getLetter() != 'Q' && newPiece.getLetter() != 'r' && newPiece.getLetter() != 'R')) {
            System.out.println("Invalid choice. Please choose bishop, knight, queen, or rook.");
            choice = sc.nextLine();
            newPiece = factory.getChessPiece(choice, pawn);
        }
        board[pawn.getRow()][pawn.getColumn()] = newPiece;
        return board;
    }
}
