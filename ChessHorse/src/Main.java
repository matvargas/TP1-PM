public class Main {

    public static void main(String[] args) {

        //Initial coordinates
        INITIAL_X = 0;
        INITIAL_Y = 0;

        //Initializes the coordinates
        ChessCoordinates initialChessCoordinates = new ChessCordinates(INITIAL_X,INITIAL_Y);

        //Iniztializes the board
        ChessBoard chessBoard = new ChessBoard();
        //Initializes the Knight
        ChessKnight chessKnight = new ChessKnight();

    }
}
