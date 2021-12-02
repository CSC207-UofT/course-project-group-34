package Controllers;

import Entities.ChessPiece;
import Entities.King;
import Entities.Rook;
import UseCases.*;
import UseCases.Checkmate.*;

/**
* This class is responsible for controlling everything about our 2D array that represents the chess board. 
* This predominantly includes keeping track of which player turn it is as well as moving chess pieces. 
*/
public class GameState implements java.io.Serializable {

    private ChessPiece[][] board;
    private int turn;
    private int[][] kingPos;
    private ChessPiece pawnToTransform;
    private boolean transform;

    public GameState(){

        this.board = new ChessPiece[8][8];
        this.turn = 0;
        this.kingPos = getInitKing();
        this.pawnToTransform = null;
        this.transform = false;
    }

    public ChessPiece[][] getBoard(){
        return this.board;
    }

    public void setBoard(ChessPiece[][] newBoard) { this.board = newBoard;}

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
        int[] kingPos = getKingPos();
        Checkmate checkmate = new Checkmate();
        return checkmate.isCheckmate(((King) board[kingPos[0]][kingPos[1]]), board);
    }

    public boolean getCheck() {
        int[] kingPos = getKingPos();
        Check check = new Check();
        return check.isKingInCheck((King) board[kingPos[0]][kingPos[1]], board);
    }

    public boolean getTransform() { return this.transform; }

    public void setTransform(boolean bool) { this.transform = bool;}

    public ChessPiece getPawnToTransform() { return this.pawnToTransform; }

    /**
     * This method adds the ChessPiece object from our parameter and into our
     * 2D array that represents the chess board.
     */
    public void addChessPiece(ChessPiece chessPiece) {
        board[chessPiece.getRow()][chessPiece.getColumn()] = chessPiece;
    }

    /**
     * Obtains the "letter" identifier of the chess piece at the given
     * x and y coordinate. Used in CLIBoard.
     */
    public char getChessPieceLetter(int x, int y){
        return board[x][y].getLetter();
    }

    public void changeKingPos(String color, int[] Pos) {
        if (color.equals("white")) {
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
        if (positions[0] < 0 || positions[1] > 7 || board[positions[0]][positions[1]] == null) {
            return false;
        }
        ChessPiece currPiece = board[positions[0]][positions[1]];
        ChessPiece toPiece = board[positions[2]][positions[3]];

        // Check that the player is moving a friendly piece
        if ((!(this.turn == 0 & currPiece.getColor().equals("black"))) && (!(this.turn == 1 & currPiece.getColor().equals("white")))) {
            CheckerGenerator checker = new CheckerGenerator();
            CheckPlayerMove currCheck = checker.generateChecker(currPiece);
            boolean valid = currCheck.checkMove(positions[2], positions[3], currPiece, board);

            // Verify whether the desired move is valid
            if (valid) {
                // Make the move on the board
                Check check = new Check();
                board[positions[0]][positions[1]] = null;
                board[positions[2]][positions[3]] = currPiece;
                currPiece.setRow(positions[2]);
                currPiece.setColumn(positions[3]);
                int[] friendlyKingPos;
                ChessPiece rook = new Rook(0, 0, "black"); // Dummy piece
                int castling = 0;
                // Find position of king, perform castling if needed
                if (isKing(currPiece)) {
                    friendlyKingPos = new int[] {positions[2], positions[3]};
                    // Check castling
                    if (positions[3] == positions[1] + 2) {
                        rook = board[positions[0]][positions[3] + 1];
                        rook.setColumn(positions[3] - 1);
                        board[positions[0]][positions[3] + 1] = null;
                        board[positions[0]][positions[3] - 1] = rook;
                        castling = 1;
                    } else if (positions[3] == positions[1] - 2) {
                        rook = board[positions[0]][positions[3] - 2];
                        rook.setColumn(positions[3] + 1);
                        board[positions[0]][positions[3] - 2] = null;
                        board[positions[0]][positions[3] + 1] = rook;
                        castling = 2;
                    }
                } else {
                    friendlyKingPos = getKingPos(); 
                }
                boolean inCheck = check.isKingInCheck((King) board[friendlyKingPos[0]][friendlyKingPos[1]], board);
                // Verify whether the player's move is illegal because it puts their own king in check
                if (inCheck) {
                    // Reverses the changes made before returning false
                    board[positions[0]][positions[1]] = currPiece;
                    board[positions[2]][positions[3]] = toPiece;
                    currPiece.setRow(positions[0]);
                    currPiece.setColumn(positions[1]);
                    if (castling == 1) {
                        rook.setColumn(positions[3] + 1);
                        board[positions[0]][positions[3] + 1] = rook;
                        board[positions[0]][positions[3] - 1] = null;
                    } else if (castling == 2) {
                        rook.setColumn(positions[3] - 2);
                        board[positions[0]][positions[3] - 2] = rook;
                        board[positions[0]][positions[3] + 1] = null;
                    }
                    return false;
                } else {
                    // Move is successful
                    currPiece.setHasMovedOnce();
                    changeTurn();
                    if (isKing(currPiece)) {
                        changeKingPos(currPiece.getColor(), new int[]{positions[2], positions[3]});
                    }
                    int[] opKingPos = getKingPos();
                    // Check whether pawn has reached end and can be transformed
                    if ((currPiece.getLetter() == 'p' && positions[2] == 0)
                            || (currPiece.getLetter() == 'P') && positions[2] == 8) {
                        pawnToTransform = currPiece;
                        transform = true;
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
