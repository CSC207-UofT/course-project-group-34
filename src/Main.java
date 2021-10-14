public class Main {

    public static void main(String[] args) {

        CLIboard x = new CLIboard();
        LoadGame game = new LoadGame();
        GameState state = game.loadGame();

        System.out.println(x.printBoard(state));

    }
}
