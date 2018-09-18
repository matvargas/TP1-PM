import java.util.ArrayList;
import java.util.List;

public class ChessKnight {

    private ChessCoordinates startCoordinates;
    private ChessCoordinates currentCoordinates;
    private List<ChessCoordinates> currentPath = new ArrayList<ChessCoordinates>();
    private List<ChessCoordinates> alternativePaths = new ArrayList<ChessCoordinates>();

    public ChessKnight(ChessCoordinates coordinates) {
        this.startCoordinates = coordinates;
        this.currentCoordinates = coordinates;
    }

    public List<ChessCoordinates> calculatePossibleMovements() {
        List<ChessCoordinates> possibleMoviments = new ArrayList<ChessCoordinates>();
        int X_COORD, Y_CORRD;
        ChessCoordinates possibleMoviment;

        X_COORD = this.currentCoordinates.x - 1;
        Y_CORRD = this.currentCoordinates.y - 2;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x - 1;
        Y_CORRD = this.currentCoordinates.y + 2;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 1;
        Y_CORRD = this.currentCoordinates.y - 2;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 1;
        Y_CORRD = this.currentCoordinates.y + 2;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }


        X_COORD = this.currentCoordinates.x - 2;
        Y_CORRD = this.currentCoordinates.y - 1;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x - 2;
        Y_CORRD = this.currentCoordinates.y + 1;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 2;
        Y_CORRD = this.currentCoordinates.y - 1;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 2;
        Y_CORRD = this.currentCoordinates.y + 1;
        if(isValidMoviment(X_COORD, Y_CORRD)) {
            possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        showPossibleMovements(possibleMoviments);
        return possibleMoviments;

    }

    public void showPossibleMovements(List<ChessCoordinates> possibleMoviments) {
        System.out.print("Possible moviments ");
        System.out.println("for the current location: " + new ChessCoordinates().printCoordinates(this.currentCoordinates));
        for(ChessCoordinates coord : possibleMoviments){
            System.out.print(new ChessCoordinates().printCoordinates(coord));
            System.out.println("");
        }
    }

    public boolean isValidMoviment(int X_COORD, int Y_COORD){
        if((X_COORD >= 0 && X_COORD < 8) &&
                (Y_COORD >= 0 && Y_COORD < 8) &&
                (isAlreadyInPath(X_COORD, Y_COORD))) {
            return true;
        }
        return false;
    }

    public boolean isAlreadyInPath(int X_COORD, int Y_COORD){

        for(ChessCoordinates coords : this.currentPath) {
            if(coords.x == X_COORD && coords.y == Y_COORD) {
                return false;
            }
        }
        return true;
    }

    public void showPath(){
        System.out.println("Path: ");
        for(ChessCoordinates coords : this.currentPath) {
            System.out.print(new ChessCoordinates().printCoordinates(coords) + " ");
        }
        System.out.println("");
    }

    public void showAlternativePaths(){
        System.out.println("Alternative Paths: ");
        for(ChessCoordinates coords : this.alternativePaths) {
            System.out.print(new ChessCoordinates().printCoordinates(coords) + " ");
        }
        System.out.println("");
    }

    public void moveKnight(ChessBoard chessBoard){

        System.out.println("Starting from: " + new ChessCoordinates().printCoordinates(this.startCoordinates));

        int counter = 0;
        this.currentPath.add(this.currentCoordinates);
        showPath();

        List<ChessCoordinates> possibleMovements = calculatePossibleMovements();
        this.alternativePaths = possibleMovements.subList(1, possibleMovements.size());
        while(!possibleMovements.isEmpty() || !this.alternativePaths.isEmpty()){

            if(chessBoard.board[this.currentCoordinates.x][this.currentCoordinates.y] != "--") {
                return;
            }

            chessBoard.board[this.currentCoordinates.x][this.currentCoordinates.y] = String.format("%02d", counter  );
            chessBoard.printChessBoard();

            System.out.print("[" + (counter + 1) + "]" + " Moving from: " + new ChessCoordinates().printCoordinates(this.currentCoordinates) + " ");

            ChessCoordinates chessCoordinates = new ChessCoordinates();

            if(!possibleMovements.isEmpty()) {
                chessCoordinates = possibleMovements.get(0);
                this.currentCoordinates = chessCoordinates;
                this.currentPath.add(chessCoordinates);
            } else {
                chessCoordinates = this.alternativePaths.get(0);
                this.currentCoordinates = chessCoordinates;
                this.currentPath.add(chessCoordinates);
            }

            System.out.println("to : " + new ChessCoordinates().printCoordinates(chessCoordinates));

            if(!possibleMovements.isEmpty()) {
                this.alternativePaths = possibleMovements.subList(1, possibleMovements.size());
                showAlternativePaths();
            }

            possibleMovements = calculatePossibleMovements();
            counter ++;
        }
    }

}
