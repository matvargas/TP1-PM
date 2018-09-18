public class ChessCoordinates {

    //X cordinate
    int x;
    // Y cordinate
    int y;

    public ChessCoordinates(){

    }

    public ChessCoordinates(int x, int y){
        this.x = x; this.y = y;
    }

    public String printCoordinates(int x, int y) {
        return ("{" + x + ", " + y + "}");
    }

    public String printCoordinates(ChessCoordinates chessCoordinates) {
        return ("{" + chessCoordinates.x + ", " + chessCoordinates.y + "}");
    }

}
