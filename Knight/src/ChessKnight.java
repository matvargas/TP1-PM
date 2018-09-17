import java.util.ArrayList;
import java.util.List;

public class ChessKnight {

    private ChessCoordinates startCoordinates;
    private ChessCoordinates currentCoordinates;

    public ChessKnight(ChessCoordinates coordinates) {
        this.startCoordinates = coordinates;
        this.currentCoordinates = coordinates;
    }

    public void showPossibleMovements() {
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

        System.out.println("Possible Moviments:");
        for(ChessCoordinates coord : possibleMoviments){
            System.out.print("{" + coord.x + ", " + coord.y + "} ");
            System.out.println("");
        }

    }

    public boolean isValidMoviment(int X_COORD, int Y_COORD){
        if((X_COORD >= 0 && X_COORD <= 8) &&
                (Y_COORD >= 0 && Y_COORD <= 8)) {
            return true;
        }
        return false;
    }

    public void MoveKnight(int CurrentCoordinates, int count){

    }

}
