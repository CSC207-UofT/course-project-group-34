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
}
