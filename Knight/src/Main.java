public class Main {

    public static void main(String[] args) {

        //Initial coordinates
        int INITIAL_X = 4;
        int INITIAL_Y = 4;
        int count = 0;

        //Initializes the coordinates
        ChessCoordinates initialChessCoordinates = new ChessCoordinates(INITIAL_X,INITIAL_Y);

        //Iniztializes the board
        ChessBoard chessBoard = new ChessBoard();
        //Initializes the Knight
        ChessKnight chessKnight = new ChessKnight(initialChessCoordinates);
        chessKnight.showPossibleMovements();

    }
}