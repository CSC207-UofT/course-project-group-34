**CSC207 Progress Report**

Summary of Project Specification

The project specification describes the project domain, which is to implement a fully functioning chess game with a clean command-line GUI. It then outlined the rules of chess, and also contains various CRC models that detail the responsibilities of each entity and which classes each entity collaborates with. Each CRC model is also labelled with what layer of Clean Architecture it adheres to.

The project scenario walk-through describes an early game scenario where a game board is initialized and the player is allowed to make a first move involving only a white pawn. The move is then recorded by an instance of the GameState class (after being checked by an instance of the CheckWhitePawnMove class) and then the entire board is outputted by the CLIBoard class with the updated positions of every piece.

The skeleton program seeks to implement the scenario described above. In particular, it will implement a working chess board where only the pawns are allowed to move. Moreover, there are classes that record and update the positions of pawns and there are classes that verify whether a given move is valid with respect to the current state of the board. The program will take in a single input (the position of the piece to be moved, i.e ‘15’, and where the piece should be moved to, i.e ‘25’), check the validity of that move, and then either prompt the player to make a valid move or update and output the board accordingly.

Successful Design Features/Implementations Some successful design features include:

- Creating an abstract class called ChessPiece to model the behaviour and common functionalities of a chess piece
- Breaking down a large class into smaller classes to avoid overcomplication and excessive responsibilities or functionality (Adheres to the SOLID principles)
- Creating a string value that represents our chess game, and all 32 chess pieces. This was then printed out successfully into the command line as a UI

Open Questions

Some open questions our group struggled with include:

- Choosing the most consistent implementation to handle the way pieces are moved such that it abides by the principles of Clean Architecture
- Modifying the game state
- Had trouble deciding on the design of handling check and checkmate conditions (Ensuring no possible moves can be made to declare checkmate, preventing invalid moves when in check, etc.)
- Had trouble deciding on potential extensions of the application like elo score, history tracking and how that data can be efficiently stored and manipulated
- Determining the most efficient way to verify whether a given move is valid

Summary of Group Member Roles and Next Steps

*Ritik* - Worked on the scenario walkthrough, CRC models, specification, and progress report. Will work on implementing the Piece movement methods and checkPieceMove methods.

*Parth* - Worked on the skeleton code and contributed to the CRC model, specification and progress report. Will work on the gameState class.

*Meet* - Worked on the CRC model, project specification and progress report. Will work on implementing classes and methods pertaining to the other chess pieces.

*Petar* - Worked on the CRC model, the skeleton code, and the specification. Will work on implementing classes and methods--namely, those pertaining to the checkers--in the future.

*Azka* - Worked on Skeleton code implementations for all entities, CLIBoard and LoadGame as well as the CRC models. Will continue to work on implementing the program.
PAGE2
