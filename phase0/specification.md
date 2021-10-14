**CSC207 Project Specification**

**Project Domain:**

Implement a fully functioning chess game (with additional features such as a leaderboard) with the correct logic and game rules. This game will be presented to the user using a clean and organized command-line GUI to facilitate an efficient user experience.

**Rules of our Project domain**

Chess is a two-player strategy game that takes place over an 8 x 8 board with one player controlling 16 black pieces and the other controlling 16 white pieces. Beginning with the player controlling the white pieces, each player makes one move per turn with the goal of capturing the opponent’s king. The rules for each piece are as follows:

- **Pawns:** can move forward once (but may move forward twice on their first move of the game) and attack diagonally.
- **Kings**: can move & attack one block in any direction.
- **Queens:** can travel any number of blocks in any direction, attacking the block on which they land on.
- **Bishops**: can only move any number of blocks diagonally, attacking the block on which they land on.
- **Rook:** can move any number of blocks vertically and horizontally, attacking the block on which they land on.
- **Knights**: can travel two blocks horizontally and one block vertically (or vice versa), attacking the block on which they land.

If a player’s king is in a position to be attacked, then they are in check. If there are no possible moves the player in check can make to break the check, then they lose and therefore, the other player wins.

1
