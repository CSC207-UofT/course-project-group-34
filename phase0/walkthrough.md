**CSC207 Scenario Walkthrough**

A typical scenario for our chess game would involve a user starting up the program and by extension a chess game, playing through the game, and then exiting the program (we will eventually implement a leaderboard system so that the user can try to beat their high scores, i.e winning in the fewest number of moves, winning as fast as possible, etc.). For a more detailed scenario walkthrough, see the following:

This scenario outlines the beginning of the game with the first move included. The LoadGame class initializes the board with 32 pieces before any moves are made. Following this, the player controlling the white pieces is prompted to make their first move by GameState. The only class that can currently move is the Pawn class; when the user attempts to move their pawn, GameState will call on an instance of CheckWhitePawnMove and verify that this move is indeed valid. If not, it will re-prompt the user until they make a valid move, at which point the GameState class will modify the position of the pawn in question accordingly. This information is then passed onto the CLIBoard class, which then outputs the new state of the board into the command line, following the first move.

To summarize, the scenario outlined above details the very start of a chess game, in which the board is initialized, the player inputs a valid move for the white pawn, the GameState records the move and updates the piece’s position after checking with CheckWhitePawnMove, and then the CLIBoard outputs the current state of the board.


