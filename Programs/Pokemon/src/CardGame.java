import java.util.ArrayList;
import java.util.Random;

public class CardGame {

   private ArrayList<Card> deck;
   private ArrayList<Card> hand = new ArrayList<>();
   private int count;


   public CardGame(){
        deck = new ArrayList<>();
   }

    public void fillDeck(int numPokemon){
        if(numPokemon < 1){
            System.out.println("Must have at least 1 Pokemon in the deck!");
        }
        else{
            for(int i=0; i<60-numPokemon; i++){
                deck.add(new Energy());
    
            }
            for(int j=0; j<numPokemon; j++){
                deck.add(new Charmander());
            }
        }
    }
    public void fillWaterDeck(){
        //method to fill our set water based deck
        //5 pokemon, 15 energies, 
    }

    public void drawHand(){
        Random rng = new Random();
        for(int i=0; i<7; i++){
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    public boolean isPokemoninHand(){
        for(Card singleCard : hand){
            if(singleCard instanceof Pokemon){
                return true;
            }
        }
        return false;
    }

    public double monteCarlo(int pokemon, int numRuns){

        //actual montecarlo loop that runs the simulation "numruns" times
        for(int i=0; i<numRuns; i++){
                fillDeck(pokemon);
                drawHand();

                if(isPokemoninHand()){
                    count++;

                }
                deck.clear();
                hand.clear();

        }
        //System.out.println("Avg number of shuffles before you can take your turn: " + avg);
        double avg = (double)count/(double)numRuns;
        return avg;

    }

}
