import java.util.Random;

public class Energy extends Card {

    private Pokemon.Type type;

    // Constructor to create an energy with a specific Type
    public Energy(Pokemon.Type userInputType) {
        type = userInputType;
    }

    // Constructor for energy with int as parameter for random energy creation in decks
    public Energy(int userInputType) {
        type = fromIndex(userInputType);
    }

    // Method to convert index to Type
    private Pokemon.Type fromIndex(int index) {
        switch (index) {
            case 0: return Pokemon.Type.NORMAL;
            case 1: return Pokemon.Type.FIRE;
            case 2: return Pokemon.Type.WATER;
            case 3: return Pokemon.Type.GRASS;
            case 4: return Pokemon.Type.ELECTRIC;
            case 5: return Pokemon.Type.ICE;
            case 6: return Pokemon.Type.FIGHTING;
            case 7: return Pokemon.Type.POISON;
            case 8: return Pokemon.Type.GROUND;
            case 9: return Pokemon.Type.FLYING;
            case 10: return Pokemon.Type.PSYCHIC;
            case 11: return Pokemon.Type.ROCK;
            case 12: return Pokemon.Type.GHOST;
            case 13: return Pokemon.Type.BUG;
            case 14: return Pokemon.Type.DRAGON;
            default: throw new IllegalArgumentException("Invalid type index: " + index);
        }
    }

    // Getter for type of energy card
    public Pokemon.Type getType() {
        return type;
    }

    // Randomly generates a new Energy card with a random type
    public static Energy getRandomEnergy() {
        Random random = new Random();
        int typeIndex = random.nextInt(Pokemon.Type.values().length);
        return new Energy(typeIndex);
    }

    @Override
    public String toString() {
        return type + " Energy";
    }
}
