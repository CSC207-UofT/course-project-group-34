import java.util.Scanner;
/**
 * This class is responsible for running out skeleton Chess Game implementation
 */
public class Main {

    public static void main(String[] args) {
        
        //Creates our IU object and the object that loads a fresh game board
        CLIboard x = new CLIboard();
        LoadGame game = new LoadGame();
        GameState state = game.loadGame();
        
        // Printing out the UI
        System.out.println(x.printBoard(state));
        
        // Asking for user input
        int[] arr = getPlayerMove();
        state.makeMove(arr);
        
        // Printing out our chess board after the new move
        System.out.println(x.printBoard(state));

    }

    // This method retrieves user input, it asks the player what pawn
    // they would like to move and where.
    public static int[] getPlayerMove(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlayer White, what pawn will you move: ");
        int moveFrom = sc.nextInt();

        System.out.println("\nPlayer White, where will you move the pawn: ");
        int moveTo = sc.nextInt();

        return new int[]{moveFrom, moveTo};
    }
}
