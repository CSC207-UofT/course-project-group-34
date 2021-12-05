package Gateways;

import Entities.ChessPiece;
import UseCases.PawnFactory;
import java.util.Scanner;

public class PawnTransformer {
    public PawnTransformer() { }

    public ChessPiece[][] transform(ChessPiece pawn, ChessPiece[][] board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your pawn has reached the end of the board? Would you like to transform it into a " +
                "bishop, knight, queen, or rook?");
        String choice = sc.nextLine();
        PawnFactory pawnFactory = new PawnFactory();
        ChessPiece newPiece = pawnFactory.getChessPiece(choice, pawn);
        while (newPiece == null) {
            System.out.println("Invalid choice. Please choose bishop, knight, queen, or rook.");
            choice = sc.nextLine();
            newPiece = pawnFactory.getChessPiece(choice, pawn);
        }
        board[pawn.getRow()][pawn.getColumn()] = newPiece;
        return board;

    }
}
