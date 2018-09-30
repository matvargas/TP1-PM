import java.util.Random;
public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 6; i ++){

            Random rand = new Random();

            //Initial coordinates
            int INITIAL_X = rand.nextInt(7) + 0;
            int INITIAL_Y = rand.nextInt(7) + 0;

            System.out.println("Starting Tour from " + new ChessCoordinates().printCoordinates(INITIAL_X,INITIAL_Y));

            //Initializes the coordinates
            ChessCoordinates initialChessCoordinates = new ChessCoordinates(INITIAL_X,INITIAL_Y);

            //Iniztializes the board
            ChessBoard board = new ChessBoard();
            //Initializes the Knight
            ChessKnight chessKnight = new ChessKnight(initialChessCoordinates);
            long start = System.currentTimeMillis();
            chessKnight.moveKnight(board);
            long end = System.currentTimeMillis();
            System.out.println("It took " + (end - start) + " ms" + "\n");
        }

    }
}
