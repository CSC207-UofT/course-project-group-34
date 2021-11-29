import UI.CLIBoard;
import Controllers.GameState;
import Controllers.LoadGame;

import java.io.*;
import java.util.Scanner;
import java.lang.Math;

/**
 * This class is responsible for running our skeleton Chess Game implementation
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        //Creates our IU object and the object that loads a fresh game board
        CLIBoard x = new CLIBoard();
        LoadGame game = new LoadGame();
        GameState state = game.loadGame();
        File output = new File("output.txt");
        FileWriter writer = new FileWriter(output);
        int move_count = 0;
        // Printing out the UI
        System.out.println(x.printBoard(state));


        boolean isOver = false;
        saveGame(state);
        
        // While loop asking for user input, and will
        // continue to do so until the input in valid.
        while(!isOver) {
            System.out.println(x.printBoard(state));
            int[] arr = getPlayerMove(state);
            boolean cond = state.makeMove(arr);
            if (!cond) {
                System.out.println("\nThat is not a valid move, please try again.");
                continue;
            }
            move_count = move_count + 1;
            boolean outcome = state.getOutcome();
            if (outcome) {
                isOver = true;
                System.out.println("The game is over!");
                if (move_count % 2 == 1){
                    System.out.println("The player using the white pieces won in " + ((move_count/2) + 1) + "moves" );
                } else {
                    System.out.println("The player using the black pieces won in " + (move_count/2) + "moves");
                }
            }
        }
        // Printing out our chess board after the new move
        System.out.println(x.printBoard(state));

    }

    public static void saveGame(GameState state) throws FileNotFoundException {
        try {
            FileOutputStream f = new FileOutputStream("object.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(state);

            o.close();
            f.close();

        } catch (IOException e) {
            System.out.println("Error Saving the Game");
        }
    }

    public static void loadGame() throws FileNotFoundException {
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("object.txt"));
            GameState s = (GameState) is.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // This method retrieves user input, it asks the player what pawn
    // they would like to move and where.
    public static int[] getPlayerMove(GameState state){
        String player;
        if(state.getTurn() == 0){
            player = "White";
        }
        else{
            player = "Black";
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlayer "+ player + ", which piece will you move? (ex. row = 7, col = 1, => '71'): ");
        int moveFrom = sc.nextInt();

        System.out.println("\nPlayer " + player + ", where will you move the piece to? (ex. row = 8, col = 1, => '81'):");
        int moveTo = sc.nextInt();
        
        int rcFrom = moveFrom - 11;
        int rcTo = moveTo - 11;

        System.out.println();

        return new int[]{Math.floorDiv(rcFrom, 10), rcFrom % 10, Math.floorDiv(rcTo, 10), rcTo % 10};
    }

}
