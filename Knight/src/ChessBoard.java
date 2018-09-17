public class ChessBoard {

    private char chessBoard[][];
    private int CHESS_DIMENS = 8;
    private char INITIAL_VALUE = '0';

    public ChessBoard() {
        this.chessBoard = new char[CHESS_DIMENS][CHESS_DIMENS];

        for(int x = 0; x < CHESS_DIMENS; x++){
            for(int y = 0; y < CHESS_DIMENS; y++){
                this.chessBoard[x][y] = INITIAL_VALUE;
            }
        }
    }

    public void printChessBoard() {
        System.out.println("Chess Board Configuration");

        int x,y;
        System.out.println(" _________________");
        for(x = 0; x < CHESS_DIMENS; x++){
            System.out.print("| ");
            for(y = 0; y < CHESS_DIMENS; y++){
                System.out.print(this.chessBoard[x][y] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(" _________________");
    }


    public char[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(char[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

}
