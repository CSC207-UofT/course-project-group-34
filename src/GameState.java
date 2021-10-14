/**
* This class is responsible for controlling everything about our 2D array that represents the chess board. 
* This predominantly includes keeping track of which player turn it is as well as moving chess pieces. 
*/
public class GameState {

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
        board[chessPiece.getYPosition()][chessPiece.getXPosition()] = chessPiece;
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
        if (this.turn.equals(0)) {
            CheckWhitePawnMove checker = new CheckWhitePawnMove();
        } else {
            CheckBlackPawnMove checker = new CheckBlackPawnMove();
        }
        boolean valid = checker.checkMove(positions[2], positions[3], currPiece, board);
        if (valid) {
            board[positions[0]][positions[1]] = null;
            board[positions[2]][positions[3]] = currPiece;
            currPiece.setHasMovedOnce();
            changeTurn();
            return true;
        }
        return false;
    }
}
