import java.util.ArrayList;

public class Tester {

    public Tester() {

    }

    //construct a CardGame object to use in the graph method
    CardGame tcg = new CardGame();
    //create an arraylist to hold our points to graph
    private ArrayList<Double> graphPoints = new ArrayList<>();
    //method to "plot" the points in an array list
    public void plot(int maxPokemon, int numRuns){

        for(int i=0; i<maxPokemon; i++){
            graphPoints.add(tcg.monteCarlo(i, numRuns));
        }
    }
}
