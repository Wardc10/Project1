import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CardGame {

   private ArrayList<Card> deck;
   private ArrayList<Card> opponentDeck;
   private ArrayList<Card> hand = new ArrayList<>();
   private ArrayList<Card> opponentHand = new ArrayList<>();
   private ArrayList<Card> prizeCards = new ArrayList<>();

   private Card activePokemon;
   private Card opponentActivePokemon;
   private boolean hasAttachedEnergy;
   private boolean hasPlayedTrainer;

   public CardGame(){
        deck = new ArrayList<>();
        opponentDeck = new ArrayList<>();
   }

    public void fillDeck(int numPokemon, int rareCandies){
        if(numPokemon < 1){
            System.out.println("Must have at least 1 Pokemon in the deck!");
            return;
        }
        //This is just a stop cap on number of pokemon so that 6 rare candies, 15 energies, and the rest trainers can be filled in.
        else if(numPokemon > 30){
            System.out.println("Too many Pokemon!");
            return;
        }

        //rand for what pokemon to add to the deck
        Random rngPoke = new Random();
        // Add Pokemon cards
        for(int i = 0; i < numPokemon; i++){
            int randomPokemon = rngPoke.nextInt(5);
            switch(randomPokemon){
                case 0:
                deck.add(new Charmander());
                break;
                case 1:
                deck.add(new Charmeleon());
                break;
                case 2:
                deck.add(new Charizard());
                break;
                case 3:
                deck.add(new Minun());
                break;
                case 4:
                deck.add(new Plusle());
                break;
            }
    
        }

        // Add basic energy cards (15)
        for(int i = 0; i < 15; i++){
            deck.add(Energy.getRandomEnergy());
        }
        
        // Fill the rest of the deck with Trainer cards up to 60 cards total
        int remainingCards = 60 - numPokemon - 15;
        //rand for what pokemon to add to the deck
        Random rngTrainer = new Random();
        // Add Pokemon cards
        for(int i = 0; i < remainingCards; i++){
            int randomTrainer = rngTrainer.nextInt(3);
            switch(randomTrainer){
                case 0:
                deck.add(new RareCandy());
                break;
                case 1:
                deck.add(new ProfessorsResearch());
                break;
                case 2:
                deck.add(new BraveryCharm());
                break;
            }
    
        }
    }

    public void drawHand(){
        Random rng = new Random();
        for(int i = 0; i < 7; i++){
            if(deck.size() == 0){
                System.out.println("Deck Empty!");
                
            }
            else{
                int cardToTakeIndex = rng.nextInt(deck.size());
                hand.add(deck.get(cardToTakeIndex));
                deck.remove(cardToTakeIndex);
            }
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

    public void initializeOpponent() {
        fillDeck(10, 6);
        while (!isPokemoninHand()) {
            drawHand();
            hand.clear();
        }

        for (Card card : deck) {
            opponentDeck.add(card);
        }
    }

    public void selectStartingPokemon(Scanner scanner) {
        boolean validChoice = false;
        Card chosenPokemon = null;
    
        while (!validChoice) {
            System.out.println("Your hand contains the following cards:");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println(i + ": " + hand.get(i).getClass().getSimpleName());
            }
    
            System.out.print("Select a starting Pokemon by entering its index (must be a Basic Pokemon, Stage 0): ");
            int chosenIndex = scanner.nextInt();
    
            // Ensure the selected card is a Pokemon and has Stage 0
            Card selectedCard = hand.get(chosenIndex);
            if (selectedCard instanceof Pokemon && ((Pokemon) selectedCard).getStage() == 0) {
                chosenPokemon = selectedCard;
                validChoice = true;
            } else {
                System.out.println("Invalid choice. You must select a Basic Pokemon (Stage 0). Please try again.");
            }
        }
    
        // Set chosen Pokemon as active and remove it from the hand
        activePokemon = chosenPokemon;
        hand.remove(chosenPokemon);
    
        //add remaining cards to prize cards
        prizeCards.addAll(hand);
    
        // Clear the hand and draw a new one
        hand.clear();
        drawHand();
    }
    

    public void playTurn(Scanner scanner) {
        hasAttachedEnergy = false;
        hasPlayedTrainer = false;

        while (true) {
            System.out.println("Your hand contains the following cards:");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println(i + ": " + hand.get(i).getClass().getSimpleName());
            }

            System.out.println("Choose an action: (1) Attach Energy, (2) Play Trainer, (3) Switch Pokemon, (4) Attack, (5) End Turn");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (hasAttachedEnergy) {
                        System.out.println("You've already attached an Energy card this turn.");
                    } else {
                        attachEnergy(scanner);
                        hasAttachedEnergy = true;
                    }
                    break;
                case 2:
                    if (hasPlayedTrainer) {
                        System.out.println("You've already played a Trainer card this turn.");
                    } else {
                        playTrainer(scanner);
                        hasPlayedTrainer = true;
                    }
                    break;
                case 3:
                    switchPokemon(scanner);
                    return; // End turn after switching
                case 4:
                    attack(scanner);
                    return; // End turn after attacking
                case 5:
                    System.out.println("Ending turn.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void attachEnergy(Scanner scanner) {
        System.out.println("Select an Energy card to attach:");
        int energyIndex = scanner.nextInt();
        Card energyCard = hand.get(energyIndex);
        if (energyCard instanceof Energy) {
            ((Pokemon) activePokemon).attachEnergy((Energy) energyCard);
            hand.remove(energyIndex);
            System.out.println("Energy attached to " + activePokemon.getClass().getSimpleName());
        } else {
            System.out.println("Selected card is not an Energy card.");
        }
    }

    private void playTrainer(Scanner scanner) {
        System.out.println("Select a Trainer card to play:");
        int trainerIndex = scanner.nextInt();
        Card trainerCard = hand.get(trainerIndex);
        if (trainerCard instanceof Trainer) {
            System.out.println("Played " + trainerCard.getClass().getSimpleName());
            hand.remove(trainerIndex);
        } else {
            System.out.println("Selected card is not a Trainer card.");
        }
    }

    private void switchPokemon(Scanner scanner) {
        System.out.println("Select a Pokemon to switch:");
        int pokemonIndex = scanner.nextInt();
        Card newActivePokemon = hand.get(pokemonIndex);
        if (newActivePokemon instanceof Pokemon) {
            hand.add(activePokemon);
            activePokemon = newActivePokemon;
            hand.remove(pokemonIndex);
            System.out.println("Switched active Pokemon to " + activePokemon.getClass().getSimpleName());
        } else {
            System.out.println("Selected card is not a Pokemon.");
        }
    }

    private void attack(Scanner scanner) {
        if (activePokemon instanceof Pokemon) {
            // Here, implement attack logic based on Pokemon's attacks and energy availability
            System.out.println(activePokemon.getClass().getSimpleName() + " attacks!");
        } else {
            System.out.println("No active Pokemon to attack.");
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        fillDeck(10, 6);
        drawHand();
        selectStartingPokemon(scanner);
        initializeOpponent();

        while (true) {
            System.out.println("Player's turn:");
            playTurn(scanner);

            System.out.println("Opponent's turn:");
            // Here, implement simple opponent logic for a turn if desired

            // Add a win condition check here if needed
        }
    }


    //monteCarlo simulation that will create a deck with 'int pokemon' Pokemon and 'int numRuns' Trials outputting avg 
    public double shufflesMonteCarlo(int pokemon, int numRuns) {
        int totalShuffles = 0;
    
        for (int i = 0; i < numRuns; i++) {
            int shuffleCount = 0;
    
            // Repeat until a hand with at least one Pokémon is drawn
            do {
                //add to the shuffleCount
                shuffleCount++;
                //clear deck and hand
                deck.clear();
                hand.clear();
                //refill the deck, num rarecandies doesn't matter
                fillDeck(pokemon, 6);
                // Draw a new hand from the refilled deck
                drawHand();
            } while (!isPokemoninHand());
    
            // Add shuffle count for this trial to total shuffles
            totalShuffles += shuffleCount;
        }
        
        // Calculate the average number of shuffles
        return (double)totalShuffles / (double)numRuns;
    }

    public double oddsMonteCarlo(int pokemon, int numRuns) {
        // Count of hands containing at least one Pokémon
        int successfulHands = 0;
    
        for (int i = 0; i < numRuns; i++) {
            // Reset deck and hand for each trial
            deck.clear();
            hand.clear();
            // Refill deck with given number of Pokémon
            fillDeck(pokemon, 6);
            // Draw a new hand from the refilled deck
            drawHand();
    
            // Check if the drawn hand contains a Pokémon
            if (isPokemoninHand()) {
                successfulHands++;
            }
        }
    
        // Calculate the probability as the ratio of successful hands to total runs
        return (double)successfulHands / (double)numRuns;
    }

}