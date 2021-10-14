public class GameState {

    private ChessPiece[][] board;
    private int turn;

    public GameState(){
        this.board = new ChessPiece[8][8];
    }

    public ChessPiece[][] getBoard(){
        return this.board;
    }

    public void setTurn(int turn){
        this.turn = turn;
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
}
