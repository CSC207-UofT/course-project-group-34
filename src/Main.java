import Controllers.GameState;
import Controllers.LoadGame;
import Entities.ChessPiece;
import Presenters.PawnTransformer;
import UI.CLIBoard;
import Utils.SizedStack;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

/**
 * This class is responsible for running our skeleton Chess Game implementation
 */
public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to PPAARM Chess World!. To undo a move, enter 99 followed by 91. To Redo a move, enter 99 followed by 92 and to start a new game, enter 00 followed by 00 ");
        
        //Creates our IU object and the object that loads a fresh game board
        CLIBoard x = new CLIBoard();
        GameState state = newGame();
        GameState deepCopy = deepClone(state);
        SizedStack<GameState> history = new SizedStack<>(5);
        SizedStack<GameState> future = new SizedStack<>(5);

        
        // Printing out the UI
        assert deepCopy != null;

        int move_count = 0;


        boolean isOver = false;
        saveGame(state);
        
        // While loop asking for user input, and will
        // continue to do so until the input in valid.
        while(!isOver) {

            System.out.println(x.printBoard(state));
            getCheck(state);
            if (state.getCheck()) {
                System.out.println("Your king is in check!");
            }
            int[] arr = getPlayerMove(state);

            if (Arrays.toString(arr).equals(Arrays.toString(new int[]{8, 8, 8, 0}))) {
                if (history.size() == 0) {
                    System.out.println("cannot undo, there is no history");
                    continue;
                }
                future.push(deepClone(state));
                state = (GameState) history.pop();
                continue;
            }
            if (Arrays.toString(arr).equals(Arrays.toString(new int[]{8, 8, 8, 1}))) {
                if (future.size() == 0) {
                    System.out.println("cannot redo, there is no future");
                    continue;
                }
                history.push(deepClone(state));
                state = (GameState) future.pop();
                continue;
            }
            if (Arrays.toString(arr).equals(Arrays.toString(new int[]{-2, -1, -2, -1}))) {
                state = new LoadGame().loadGame();
                saveGame(state);
                history = new SizedStack<>(5);
                future = new SizedStack<>(5);
                continue;
            }

            if (arr[0] < 0 || arr[0] > 7 || arr[1] < 0 || arr[1] > 7 || arr[2] < 0 || arr[2] > 7 || arr[3] < 0 || arr[3] > 7) {
                System.out.println("Out of index move, try again");
                continue;
            }


            GameState copy = deepClone(state);
            boolean cond = state.makeMove(arr);
            if (!cond) {
                System.out.println("\nThat is not a valid move, please try again.");
                continue;
            }
            // Check if pawn is to be transformed
            if (state.getTransform()) {
                PawnTransformer transformer = new PawnTransformer();
                ChessPiece[][] newBoard = transformer.transform(state.getPawnToTransform(), state.getBoard());
                state.setBoard(newBoard);
                state.setTransform(false);
            }
            move_count = move_count + 1;
            saveGame((state));
            history.push(copy);


            // Check if game is over
            boolean outcome = state.getOutcome();
            if (outcome) {
                isOver = true;
                System.out.println("The game is over!");
                if (move_count % 2 == 1){
                    System.out.println("The player using the white pieces won in " + ((move_count/2) + 1) + " moves." );
                } else {
                    System.out.println("The player using the black pieces won in " + (move_count/2) + " moves.");
                }
            }
        }
        // Printing out our chess board after the new move


    }

    //Method to save the input state to the txt file

    public static void saveGame(GameState state) {
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

    //Method to retrieve the latest state saved in the txt file

    public static GameState newGame() {
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("object.txt"));
            return (GameState) is.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new LoadGame().loadGame();
        }
    }

    //Method to generate a deep copy of the input state

    public static GameState deepClone(GameState state) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(state);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (GameState) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return null;
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

        return new int[]{Math.floorDiv(rcFrom, 10), rcFrom % 10, Math.floorDiv(rcTo, 10), rcTo % 10};
    }

    //Method to let users know who is in check

    public static void getCheck(GameState state){
        if (state.getTurn() == 0){
            if(state.getCheck()){
                System.out.println("Player White, Your king is in check.");
            } else{
                System.out.println("It is the White player's turn.");
            }
        }
        else {
            if(state.getCheck()){
                System.out.println("Player Black, Your king is in check.");
            } else{
                System.out.println("It is the Black player's turn.");
            }
        }

    }

}
