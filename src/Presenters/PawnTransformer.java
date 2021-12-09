package Presenters;

import Entities.ChessPiece;
import UseCases.ChessPieceFactory;
import java.util.Scanner;

public class PawnTransformer {
    public PawnTransformer() { }

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
