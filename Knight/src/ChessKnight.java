import java.util.ArrayList;
import java.util.List;

public class ChessKnight {

    private ChessCoordinates startCoordinates;
    private ChessCoordinates currentCoordinates;
    private List<ChessCoordinates> currentPath = new ArrayList<ChessCoordinates>();
    private List<ChessCoordinates> alternativePaths = new ArrayList<ChessCoordinates>();
    private List<ChessCoordinates> alreadyTested = new ArrayList<ChessCoordinates>();

    public ChessKnight(ChessCoordinates coordinates) {
        this.startCoordinates = coordinates;
        this.currentCoordinates = coordinates;
    }

    public List<ChessCoordinates> calculatePossibleMovements(boolean shouldVerifyInPath) {
        List<ChessCoordinates> possibleMoviments = new ArrayList<ChessCoordinates>();
        int X_COORD, Y_CORRD;
        ChessCoordinates possibleMoviment;

        X_COORD = this.currentCoordinates.x - 1;
        Y_CORRD = this.currentCoordinates.y - 2;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x - 1;
        Y_CORRD = this.currentCoordinates.y + 2;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 1;
        Y_CORRD = this.currentCoordinates.y - 2;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 1;
        Y_CORRD = this.currentCoordinates.y + 2;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }


        X_COORD = this.currentCoordinates.x - 2;
        Y_CORRD = this.currentCoordinates.y - 1;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x - 2;
        Y_CORRD = this.currentCoordinates.y + 1;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 2;
        Y_CORRD = this.currentCoordinates.y - 1;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
            if(!possibleMoviments.contains(possibleMoviment))
                possibleMoviments.add(possibleMoviment);
        }

        X_COORD = this.currentCoordinates.x + 2;
        Y_CORRD = this.currentCoordinates.y + 1;
        possibleMoviment = new ChessCoordinates(X_COORD, Y_CORRD);
        if(isValidMoviment(possibleMoviment, shouldVerifyInPath)) {
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

    public boolean isValidMoviment(ChessCoordinates chessCoordinates, boolean shouldVerifyInPath){
        if((chessCoordinates.x >= 0 && chessCoordinates.x < 8) &&
                (chessCoordinates.y >= 0 && chessCoordinates.y < 8) ) {

            System.out.println("Verifying : " + new ChessCoordinates().printCoordinates(chessCoordinates));
            if(!shouldVerifyInPath) {
                System.out.println("True without verifying path");
                return true;
            } else {
                if(isAlreadyInPath(chessCoordinates)){
                    System.out.println("False, already in path");
                    return false;
                }
                System.out.println("True is not in path");
                return true;
            }
        }
        System.out.println("Coordinate not valid");
        return false;
    }

    public boolean isAlreadyInPath(ChessCoordinates chessCoordinates){

        if(this.currentPath.contains(chessCoordinates)) {
            System.out.println("Already contains " +  new ChessCoordinates().printCoordinates(chessCoordinates));
            return true;
        }
        return false;
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
        if(!this.currentPath.contains(this.currentCoordinates))
            this.currentPath.add(this.currentCoordinates);

        List<ChessCoordinates> possibleMovements = calculatePossibleMovements(true);
        System.out.println(possibleMovements);
        addElementsToAlternativePaths(possibleMovements.subList(1, possibleMovements.size()));

        while(!possibleMovements.isEmpty()){

            if(chessBoard.board[this.currentCoordinates.x][this.currentCoordinates.y] == "--") {
                System.out.println("Setting " + (counter) + " on " + new ChessCoordinates().printCoordinates(this.currentCoordinates));
                chessBoard.board[this.currentCoordinates.x][this.currentCoordinates.y] = String.format("%02d", counter  );
                counter ++;
            }

            chessBoard.printChessBoard();

            System.out.print("[" + counter + "]" + " Moving from: " + new ChessCoordinates().printCoordinates(this.currentCoordinates) + " ");

            this.currentCoordinates = possibleMovements.get(0);
            if(!this.currentPath.contains(possibleMovements.get(0)))
                this.currentPath.add(possibleMovements.get(0));

            System.out.println("to : " + new ChessCoordinates().printCoordinates(possibleMovements.get(0)));

            addElementsToAlternativePaths(possibleMovements.subList(1, possibleMovements.size()));

            possibleMovements = calculatePossibleMovements(true);

            if(possibleMovements.isEmpty()) {
                while(possibleMovements.isEmpty()) {
                    System.out.println("Using alternative paths");

                    if(this.alternativePaths.size() > 0){
                        this.currentCoordinates = this.alternativePaths.get(this.alternativePaths.size() - 1);
                        this.alternativePaths.remove(this.alternativePaths.size() - 1);
                        possibleMovements = calculatePossibleMovements(false);
                    }else{
                        break;
                    }
                    System.out.println(possibleMovements);
                }
            }
        }
    }

    public void addElementsToAlternativePaths(List<ChessCoordinates> list) {
        for(ChessCoordinates coord : list) {
            if(!this.alternativePaths.contains(coord) && !this.alreadyTested.contains(coord)){
                this.alternativePaths.add(coord);
                this.alreadyTested.add(coord);
            }
        }
        showAlternativePaths();
    }

}
