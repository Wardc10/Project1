import java.util.ArrayList;
import java.util.List;

public class Pokemon extends Card {

    private int hp;
    private int stage;
    private Type type;
    //List of energy cards attached
    private ArrayList<Energy> energyCards;
    // List of attacks this Pokemon can perform
    private ArrayList<Attack> attacks;

    public enum Type {
        NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE,
        FIGHTING, POISON, GROUND, FLYING,
        PSYCHIC, ROCK, GHOST, BUG, DRAGON
    }

    public Pokemon() {
         // Initialize energycards and attacks lists
        energyCards = new ArrayList<>();
        attacks = new ArrayList<>();
    }

    // Basic getters and setters (same as your code)

    public int getHP() {
        return hp;
    }

    public void setHP(int userInputHP) {
        hp = userInputHP;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type userInputType) {
        type = userInputType;
    }

    public void setStage(int userInputStage) {
        stage = userInputStage;
    }

    public int getStage() {
        return stage;
    }

    // Energy Management
    public void attachEnergy(Energy energy) {
        energyCards.add(energy);
    }

    public void detachEnergy(Energy energy) {
        energyCards.remove(energy);
    }

    public ArrayList<Energy> getEnergyCards() {
        // Return a copy to prevent external modification
        return new ArrayList<>(energyCards);
    }

    // Attack Management
    public void addAttack(Attack attack) {
        attacks.add(attack);
    }

    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(attacks); // Return a copy for safety
    }

    // Check if Pokemon has enough energy for an attack
    public boolean canAttack(Attack attack) {
        int requiredEnergy = attack.getEnergyCost();
        // Simple check for energy
        return energyCards.size() >= requiredEnergy;
    }

    // Apply damage to this Pokemon
    public void takeDamage(int damage) {
        hp -= damage;
        // Ensure HP doesn't go negative
        if (hp < 0) hp = 0;
    }
}
