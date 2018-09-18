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

            if(!shouldVerifyInPath) {
                return true;
            } else {
                if(isAlreadyInPath(chessCoordinates)){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean isAlreadyInPath(ChessCoordinates chessCoordinates){

        if(this.currentPath.contains(chessCoordinates)) {
            return true;
        }
        return false;
    }

    public void moveKnight(ChessBoard chessBoard) {

        int numberOfIterations = 1;
        int counter = 0;
        if(!this.currentPath.contains(this.currentCoordinates))
            this.currentPath.add(this.currentCoordinates);

        List<ChessCoordinates> possibleMovements = calculatePossibleMovements(true);
        addElementsToAlternativePaths(possibleMovements.subList(1, possibleMovements.size()));

        while(!possibleMovements.isEmpty() && counter <= 63){
            numberOfIterations ++;

            if(chessBoard.board[this.currentCoordinates.x][this.currentCoordinates.y] == "--") {
                chessBoard.board[this.currentCoordinates.x][this.currentCoordinates.y] = String.format("%02d", counter  );
                counter ++;
            }

            this.currentCoordinates = possibleMovements.get(0);
            if(!this.currentPath.contains(possibleMovements.get(0)))
                this.currentPath.add(possibleMovements.get(0));

            addElementsToAlternativePaths(possibleMovements.subList(1, possibleMovements.size()));

            possibleMovements = calculatePossibleMovements(true);

            if(possibleMovements.isEmpty()) {
                while(possibleMovements.isEmpty()) {
                    if(this.alternativePaths.size() > 0){
                        this.currentCoordinates = this.alternativePaths.get(this.alternativePaths.size() - 1);
                        this.alternativePaths.remove(this.alternativePaths.size() - 1);
                        possibleMovements = calculatePossibleMovements(false);
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println("Number of iterations " + numberOfIterations);
    }

    public void addElementsToAlternativePaths(List<ChessCoordinates> list) {
        for(ChessCoordinates coord : list) {
            if(!this.alternativePaths.contains(coord) && !this.alreadyTested.contains(coord)){
                this.alternativePaths.add(coord);
                this.alreadyTested.add(coord);
            }
        }
    }

}
