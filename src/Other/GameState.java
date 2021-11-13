package Other;

import Entities.ChessPiece;
import Entities.Pawn;
import UseCases.CheckPawnMove;
import UseCases.CheckPlayerMove;
import UseCases.CheckerGenerator;

/**
* This class is responsible for controlling everything about our 2D array that represents the chess board. 
* This predominantly includes keeping track of which player turn it is as well as moving chess pieces. 
*/
public class GameState implements java.io.Serializable {

    private ChessPiece[][] board;
    private int turn;

    public GameState(){

        this.board = new ChessPiece[8][8];
        this.turn = 0;
    }

    public ChessPiece[][] getBoard(){
        return this.board;
    }

    public void changeTurn(){
        this.turn ^= 1;
    }

    public int getTurn(){
        return this.turn;
    }

    /**
     * This method adds the ChessPiece object from our parameter and into our
     * 2D array that represents the chess board.
     */
    public void addChessPiece(ChessPiece chessPiece){
        board[chessPiece.getRow()][chessPiece.getColumn()] = chessPiece;
    }

    /**
     * Obtains the "letter" identifier of the chess piece at the given
     * x and y coordinate. Used in CLIBoard.
     */
    public char getChessPieceLetter(int x, int y){
        return board[x][y].getLetter();
    }

    /**
     * This method takes an input and changes the gamestate according if the move is value
     */
    public boolean makeMove(int[] positions) {
        ChessPiece currPiece = board[positions[0]][positions[1]];
        if ((!(this.turn == 0 & currPiece.getColor().equals("black"))) && (!(this.turn == 1 & currPiece.getColor().equals("white")))) {
            CheckerGenerator checker = new CheckerGenerator();
            CheckPlayerMove currCheck = checker.generateChecker(currPiece);
            boolean valid = currCheck.checkMove(positions[2], positions[3], currPiece, this);
            if (valid) {
                board[positions[0]][positions[1]] = null;
                board[positions[2]][positions[3]] = currPiece;
                ((Pawn) currPiece).setHasMovedOnce();
                changeTurn();
                return true;
            }
        }
        return false;

    }

    public String toString() {
        StringBuffer state = new StringBuffer("");
        for (int r = 0; r < 8; r++) {
            state.append("[");
            for (int c = 0; c < 8; c++) {
                if (this.board[r][c] == null) {
                    state.append("null");
                }
                else {
                    state.append(this.board[r][c].toString());
                }
            }
            state.append("], ");
        }
        return state.toString();
    }
}
