import java.util.ArrayList;

public class PokeTester {

    private int numPokemon = 1;
    private int numRuns = 10000;

    public PokeTester() {

    }

    //construct a CardGame object to use in the graph method
    CardGame tcg = new CardGame();

    //run tests

    public void testAvgShuffles(){
        //Calculate average shuffles until you have a pokemon in hand.
        Double avgShuffles = tcg.shufflesMonteCarlo(numPokemon, numRuns);
        System.out.println("Avg deck shuffles until a Pokemon is in hand, with "+numPokemon+ " in the deck: "+avgShuffles);

    }

    public void testStartingHandOdds(){
        //Calculate average percentage a pokemon is in your starting hand.
        Double avgOdds = tcg.oddsMonteCarlo(numPokemon, numRuns);
        System.out.println("Avg percentage a Pokemon is in your starting hand, with " +numPokemon+ " in the deck: "+avgOdds);

    }

    public void graphStartingHandOdds(){
        //Does the starting hand percentage MonteCarlo, but with 1,2,...,30 pokemon. 
        //I hard capped at 30 pokemon so other cards can populate deck as well
        int maxPokemon = 30;
        //arraylist to store all the odds of a pokemon in starting hand from 1-30
        ArrayList<Double> odds = new ArrayList<>();
        for(int i=1; i<maxPokemon+1; i++){
            Double currentOdds = tcg.oddsMonteCarlo(i, numRuns);
            odds.add(currentOdds);
        }
       // writeToCSV(odds, "PlayableStartingHandOdds.csv");

    }

    public void testPokemonTCG(){
        testAvgShuffles();
        testStartingHandOdds();
        graphStartingHandOdds();
        //Double avgRareCandies = tcg.rarecandyMonteCarlo()
    }
}
