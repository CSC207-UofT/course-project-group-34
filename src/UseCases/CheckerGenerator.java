package UseCases; 

import Entities.ChessPiece; 
import UseCases.CheckPlayerMove;
import UseCases.CheckPawnMove; 
import UseCases.CheckKnightMove; 
import UseCases.CheckQueenMove; 
import UseCases.CheckBishopMove; 
import UseCases.CheckRookMove; 
import UseCases.CheckKingMove; 

public class CheckerGenerator {

    public CheckerGenerator() { }

    public CheckPlayerMove generateChecker(ChessPiece piece) {
        char letter = piece.getLetter(); 

        if (letter == 'p' || letter == 'P') { 
            CheckPlayerMove checker = new CheckPawnMove(); 
        }

        elif (letter == 'k' || letter == 'K') {
            CheckPlayerMove checker = new CheckKnightMove(); 
        }

        elif (letter == 'q' || letter = 'Q') {
            CheckPlayerMove checker = new CheckQueenMove();
        }

        elif (letter == 'b' || letter == 'B') {
            CheckPlayerMove checker = new CheckBishopMove(); 
        }

        elif (letter == 'r' || letter == 'R') {
            CheckPlayerMove checker = new CheckRookMove();
        }

        else {
            CheckPlayerMove checker = new CheckKingMove();
        }

        return checker; 

    }
}