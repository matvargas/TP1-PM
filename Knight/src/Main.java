public class Main {

    public static void main(String[] args) {

        //Initial coordinates
        int INITIAL_X;
        int INITIAL_Y;
        int count = 0;


        for(INITIAL_Y = 0; INITIAL_Y < 8; INITIAL_Y++){
            for(INITIAL_X = 0; INITIAL_X < 8; INITIAL_X ++){
                //Initializes the coordinates
                ChessCoordinates initialChessCoordinates = new ChessCoordinates(INITIAL_X,INITIAL_Y);

                //Iniztializes the board
                ChessBoard board = new ChessBoard();
                //Initializes the Knight
                ChessKnight chessKnight = new ChessKnight(initialChessCoordinates);
                chessKnight.moveKnight(board);
                board.printChessBoard();
            }
        }

    }
}
