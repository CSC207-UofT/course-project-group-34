/**
 *  This class is responsible for creating the String value that will represent the chess board in the command line.
 *  It interacts with an instance of GameState and creates a board based off of that instance.
 */
public class CLIboard {

    public CLIboard(){}

    /**
     * This class is responsible for taking in an instance of a GameState, creating
     * a properly formatted chess board based off of the currennt state of the instance,
     * and then returning that value
     *
     * @param state - an instance of a GameState object
     * @return board
     */
    public String printBoard(GameState state){
        // Getting the 2D array that represents our chess board and initilzing variables
        ChessPiece[][] gameBoard = state.getBoard();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        StringBuilder board = new StringBuilder();
        board.append("   1 2 3 4 5 6 7 8\n");

        for(int i = 0; i < 8; i++){
            board.append(nums[i]).append(" ");
            board.append("|");
            for(int x = 0; x < 8; x++){

                if(gameBoard[i][i] != null){
                    //print piece
                }
                else
                {
                    board.append(" |");
                }
            }
            board.append("\n");

        }
        return board.toString();
    }

    /**
     * This method takes in a GameState and ChessPiece object, checks which subclass the
     * piece corresponds to, and then returns a string based on the piece and which
     * player's turn it is in the GameState.
     *
     * @param
     * @return
     */
    public String getType(GameState gameState, ChessPiece piece){
        String type  = "";

        //A billiion if statements to see what piece it is



        // If the turn == 1, we know that is Black's turn, and we must
        // uppercase the letter as all of Black's letter are uppercase
        // on the board.
        if(gameState.getTurn() == 1){
            return type.toUpperCase();
        }

        return type;
    }
}
