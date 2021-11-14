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
        CheckPlayerMove checker;

        if (letter == 'p' || letter == 'P') { 
            checker = new CheckPawnMove(); 
        }

        else if (letter == 'k' || letter == 'K') {
            checker = new CheckKnightMove(); 
        }

        else if (letter == 'q' || letter = 'Q') {
            checker = new CheckQueenMove();
        }

        else if (letter == 'b' || letter == 'B') {
            checker = new CheckBishopMove(); 
        }

        else if (letter == 'r' || letter == 'R') {
            checker = new CheckRookMove();
        }

        else {
            checker = new CheckKingMove();
        }

        return checker; 

    }
}
