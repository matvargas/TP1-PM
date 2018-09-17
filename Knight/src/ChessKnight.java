import java.util.ArrayList;
import java.util.List;

public class ChessKnight {

    private ChessCoordinates startCoordinates;
    private ChessCoordinates currentCoordinates;
    private List<List<ChessCoordinates>> availablePaths = new ArrayList<List<ChessCoordinates>>();
    private boolean isFirstIteration;

    public ChessKnight(ChessCoordinates coordinates) {
        this.startCoordinates = coordinates;
        this.currentCoordinates = coordinates;
        this.isFirstIteration = true;
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

        if(isFirstIteration) {
            for(ChessCoordinates coord : possibleMoviments){
                List<ChessCoordinates> coords = new ArrayList<ChessCoordinates>();
                coords.add(coord);
                System.out.println("Creating path starting on {" +
                        coord.x +
                        "," +
                        coord.y +
                        "}");
                this.availablePaths.add(coords);
            }
            this.isFirstIteration = false;
        } else {
            List<ChessCoordinates> pathCopy = null;
            for(List<ChessCoordinates> path : this.availablePaths){
                if(path.contains(this.currentCoordinates)) {
                    System.out.println("Updating path container of {" +
                            this.currentCoordinates.x +
                            "," +
                            this.currentCoordinates.y +
                            "}");
                    pathCopy = new ArrayList<ChessCoordinates>(path);
                    for(ChessCoordinates coords : possibleMoviments){
                        if(!pathCopy.contains(coords)){
                            pathCopy.add(coords);
                        }
                    }
                    this.availablePaths.remove(path);
                }
            }
            if(pathCopy != null)
                this.availablePaths.add(pathCopy);
            showPaths();
        }

        return possibleMoviments;

    }

    public void showPossibleMovements(List<ChessCoordinates> possibleMoviments) {
        System.out.print("Possible moviments ");
        System.out.println("for the current location: "
                + "{" + this.currentCoordinates.x
                + ","
                + this.currentCoordinates.y
                + "}");
        for(ChessCoordinates coord : possibleMoviments){
            System.out.print("{" + coord.x + ", " + coord.y + "} ");
            System.out.println("");
        }
    }

    public void showPaths() {
        System.out.println("Possible Paths:");
        for(List<ChessCoordinates> path : this.availablePaths){
            System.out.print("Path: ");
            for(ChessCoordinates coord : path){
                System.out.print("{" + coord.x + ", " + coord.y + "} ");
            }
            System.out.println("");
        }
    }

    public boolean isValidMoviment(int X_COORD, int Y_COORD){
        if((X_COORD >= 0 && X_COORD <= 8) &&
                (Y_COORD >= 0 && Y_COORD <= 8) &&
                (X_COORD != this.startCoordinates.x && Y_COORD != this.startCoordinates.y) &&
                (doesMovimentBelongsToAnotherPath(X_COORD, Y_COORD))) {
            return true;
        }
        return false;
    }

    public boolean doesMovimentBelongsToAnotherPath(int X_COORD, int Y_COORD){
        ChessCoordinates coord = new ChessCoordinates(X_COORD, Y_COORD);
        for(List<ChessCoordinates> path : this.availablePaths){
            if(path.contains(coord)) {
                System.out.println("Path: " + path + "alredy contains: {" + X_COORD + ", " + Y_COORD + "}");
                return false;
            }
        }
        return true;
    }

    public void moveKnight(){

        //Creates a copy of paths list
        List<List<ChessCoordinates>> pathsCopy = new ArrayList<List<ChessCoordinates>>(this.availablePaths);

        for(List<ChessCoordinates> path : pathsCopy){
            for(ChessCoordinates coord : path){
                System.out.print("Moving knight from: {" + this.currentCoordinates.x + ", " + this.currentCoordinates.y + "} ");
                this.currentCoordinates = coord;
                System.out.println("to: {" + this.currentCoordinates.x + ", " + this.currentCoordinates.y + "}");
                calculatePossibleMovements();
            }
        }
    }

}
