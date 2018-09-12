public class ChessBoard {

    private char chessBoard[][] = new char[8][8];

    public void ChessBoard(){
        System.out.println("Building chess board");
    }

    public void init() {
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                chessBoard[x][y] = 0;
                System.out.print(this.chessBoard[x][y] + " ");
            }
            System.out.println();
        }

    }

    public void printChessBoard() {
        System.out.println("Printing Chess board");

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                System.out.print(this.chessBoard[x][y] + " ");
            }
            System.out.println();
        }
    }


    public char[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(char[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

}
