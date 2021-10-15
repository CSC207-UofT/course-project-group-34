package Other;

import Entities.ChessPiece;

/**
 *  This class is responsible for creating the String value that will represent the chess board in the command line.
 *  It interacts with an instance of GameState and creates a board based off of that instance.
 */
public class CLIBoard {

    public CLIBoard(){}

    /**
     * This method is responsible for taking in an instance of a GameState, creating
     * a properly formatted chess board based off of the current state of the instance,
     * and then returning that value.
     *
     * @param state - an instance of a GameState object
     * @return board
     */
    public String printBoard(GameState state){
        // Getting the 2D array that represents our chess board and initializing variables
        ChessPiece[][] gameBoard = state.getBoard();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        StringBuilder board = new StringBuilder();
        board.append("   1 2 3 4 5 6 7 8\n");

        // Loop through each "cell" within the chess board 2D array, if there is a
        // Chess piece at that location, print out that piece's letter. Print an empty
        // cell otherwise.
        for(int x = 0; x < 8; x++){
            board.append(nums[x]).append(" ");
            board.append("|");
            for(int y = 0; y < 8; y++){

                if(gameBoard[x][y] != null){
                    board.append(state.getChessPieceLetter(x, y)).append("|");
                }
                else { board.append(" |"); }
            }
            board.append("\n");
        }
        return board.toString();
    }
}
