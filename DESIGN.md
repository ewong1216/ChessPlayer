# Design
We used a standard Model-View-Controller structure.
* Model: the backend which contains the classes that manage the game of chess.
    * Pieces: Contains the classes for the types of pieces in Chess
        * ChessPiece: The parent abstract class from which all specialized pieces inherit from. 
        This makes it so we can have a collection of pieces, regardless of type. It contains common 
        fields that all pieces would have. It also has methods for checking for moves or
        captures for the 3 long moving pieces (`Queen`, `Rook`, `Bishop`) to factor out code.
        Having abstract methods `possibleMoves` and `possibleCaptures` makes it so the pieces
        can have their own implementations of how they move and capture.
        * `Pawn`: Pawns are unique in that the squares they move to are not the squares they can
        capture on. Furthermore, the special rule of en passant must be taken into account. 
        * `Knight`: Knights are unique in that they can 'jump' over other pieces. The squares they 
        can move/capture to are not affected by pieces in the way.
        * `Queen`, `Rook`, `Bishop`: All similar in their behavior. They move as many squares
        as they wish in their given allowed directions.
        * `King`: Can move or capture 1 square in any direction. Does not actually check if it moves
        or captures into check, this is taken care of by `Chessboard.makeMove` which is the heart 
        of the backend.
    * `ChessCoordinate`, `Move`, `Square`: These classes are all classes that are used to 
    increase readability and decrease complexity of code. They do not partake in any major actions themselves.
    * `ChessBoard`: Stores where each piece is located. Having a central backend class 
    made connecting the fron to the backend simpler. `makeMove` is the heart of the backend. It takes 
    care of all types of moves and captures, including special rules like castling, promotion (you can
    only promote to a `Queen` in this program due to time constraints), and en passant. 
    * `ChessGame`: Connects `ChessBoard` with the frontend. Takes care of information that is more 
    broad than `ChessBoard`, such as the player's turn and the list of moves taken. 
    * `ChessBoardFactory`: Used to make different `ChessBoard` instances. 
    * `Testing`: As the name suggest, used for testing after coding up major features.

* View: Displays the `ChessBoard` with dragable pieces. Uses the java.swing and java.awt packages.
    * `ChessView`: extends `JFrame` and is the main display on which the other Views are contained.
    * `ChessBoardView`: Displays the 8x8 standard board and maintains a field to 
    display the pieces on top of the squares. 
    * `ChessPieceView`: Takes care of displaying the correct piece. Handles cases including promotion,
    where the `Pawn` promotes to a `Queen`.
    * `ChessTurnView`: Displays which player's turn it is at the bottom of the View.
    
* Controller: solely contains the ChessController which connects the View and Model. 
    * `ChessController`: Initializes both the `ChessGame` and `ChessView`. When pieces are dragged,
    sends that information to the Model to be processed, then updates the View if the move was valid.
    
    