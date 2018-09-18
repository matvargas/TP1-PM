public class ChessBoard {

    String board[][];
    private int CHESS_DIMENS = 8;
    private String INITIAL_VALUE = "--";

    public ChessBoard() {
        board = new String[CHESS_DIMENS][CHESS_DIMENS];

        for(int x = 0; x < CHESS_DIMENS; x++){
            for(int y = 0; y < CHESS_DIMENS; y++){
                board[x][y] = INITIAL_VALUE;
            }
        }
    }

    public void printChessBoard() {
        System.out.println("Chess Board Configuration");

        int x,y;
        System.out.println(" _________________________");
        for(x = 0; x < CHESS_DIMENS; x++){
            System.out.print("| ");
            for(y = 0; y < CHESS_DIMENS; y++){
                System.out.print(board[x][y] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(" _________________________");
    }

}
