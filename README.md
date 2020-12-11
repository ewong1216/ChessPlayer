# ChessPlayer

### Running the program
This project is capable of creating a chessboard that can will be displayed as a Window on your 
screen. To run this program, follow the following steps:

* Clone project from GitHub.
* Open Project
* Mark `chess_player/src/main/java` as sources root
* Compile and run `chess_player/src/main/java/controller/ChessController.java` to run project

After completing these steps, a chess window will appear on your screen. You can then play chess 
beginning with white to move. Note, this project was developed using java 11, earlier versions may 
not be supported.

### Using the program
Using the program should be fairly straightforward. To make a move, drag and drop any piece. 
For convenience, the players turn is shown at the bottom of the screen. If the move is determined as 
a legal move, then the move will be made and updated on the board. A move will be determined illegal 
if:

* It is not the pieces' turn to move.
* The piece cannot move to the ending square by following traditional chess piece movements.
* The move would cause the King of the moving piece's color to be in check at the end of the move.

When the game is over, either by checkmate or stalemate, no more moves will be possible. To close 
the program, close the window or terminate the program.