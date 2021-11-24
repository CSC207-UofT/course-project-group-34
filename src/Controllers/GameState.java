package Controllers;

import Entities.ChessPiece;
import Entities.King;
import UseCases.*;
import UseCases.Checkmate.*;

/**
* This class is responsible for controlling everything about our 2D array that represents the chess board. 
* This predominantly includes keeping track of which player turn it is as well as moving chess pieces. 
*/
public class GameState implements java.io.Serializable {

    private ChessPiece[][] board;
    private int turn;
    private boolean isOver;
    private boolean isCheck;
    private int[][] kingPos;

    public GameState(){

        this.board = new ChessPiece[8][8];
        this.turn = 0;
        this.isOver = false;
        this.isCheck = false;
        this.kingPos = getInitKing();
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

    public int[][] getInitKing() {
        return new int[][]{{7, 4}, {0, 4}};
    }

    public boolean getOutcome() {
        return this.isOver;
    }

    public void setOutcome() {
        this.isOver = true;
    }

    public boolean getCheck() {
        return this.isCheck;
    }

    public void setCheck() {
        this.isCheck = true;
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
     * This method takes in a given position and removes that chess piece from that position.
     */
    public void removeChessPiece(int row, int col){
        board[row][col] = null;
    }

    public void changeKingPos(String color, int[] Pos) {
        if (color.equals("black")) {
            this.kingPos[0][0] = Pos[0];
            this.kingPos[0][1] = Pos[1];
        }
        else {
            this.kingPos[1][0] = Pos[0];
            this.kingPos[1][1] = Pos[1];
        }
    }

    public int[] getKingPos() {
        if (this.turn == 0) {
            return new int[] {this.kingPos[0][0], this.kingPos[0][1]};
        }
        return new int[] {this.kingPos[1][0], this.kingPos[1][1]};
    }

    public boolean isKing(ChessPiece piece) {
        char letter = piece.getLetter();

        return letter != 'p' && letter != 'P' && letter != 'k' && letter != 'K' && letter != 'q' &&
                letter != 'Q' && letter != 'b' && letter != 'B' && letter != 'r' && letter != 'R';


    }

    /**
     * This method takes an input and changes the gamestate according if the move is value
     */
    public boolean makeMove(int[] positions) {
        ChessPiece currPiece = board[positions[0]][positions[1]];
        ChessPiece toPiece = board[positions[2]][positions[3]];

        if ((!(this.turn == 0 & currPiece.getColor().equals("black"))) && (!(this.turn == 1 & currPiece.getColor().equals("white")))) {
            CheckerGenerator checker = new CheckerGenerator();
            CheckPlayerMove currCheck = checker.generateChecker(currPiece);
            boolean valid = currCheck.checkMove(positions[2], positions[3], currPiece, this);

            if (valid) {
                Check check = new Check();
                board[positions[0]][positions[1]] = null;
                board[positions[2]][positions[3]] = currPiece;
                currPiece.setRow(positions[2]);
                currPiece.setColumn(positions[3]);
                int[] friendlyKingPos = getKingPos();
                boolean inCheck = check.isKingInCheck((King) board[friendlyKingPos[0]][friendlyKingPos[1]], this);
                if (inCheck) {
                    board[positions[0]][positions[1]] = currPiece;
                    board[positions[2]][positions[3]] = toPiece;
                    currPiece.setRow(positions[0]);
                    currPiece.setColumn(positions[1]);
                    return false;
                } else {
                    currPiece.setHasMovedOnce();
                    changeTurn();
                    if (isKing(currPiece)) {
                        changeKingPos(currPiece.getColor(), new int[]{positions[2], positions[3]});
                    }
                    int[] opKingPos = getKingPos();
                    Checkmate checkmate = new Checkmate();
                    boolean cMate = checkmate.isCheckmate(((King) board[opKingPos[0]][opKingPos[1]]), this);
                    if (cMate) {
                        setOutcome();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer state = new StringBuffer();
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
