import java.util.ArrayList;

public class MCTester {

    public MCTester(){

    }

    //initialize the monteCarlo game
    Game monteCarlo = new Game();

    MonteCarloCSVWriter csvWriter = new MonteCarloCSVWriter();

    //initialize arraylist for our coordinate for each test
    ArrayList<MCPair> keepDoorCoordinates = new ArrayList<>();
    ArrayList<MCPair> changeDoorCoordinates = new ArrayList<>();


    //checkPow10 takes in an integer and runs the simulation for that many powers of 10 and output the results in a CSV
    public void checkPow10(int powersOf10, int doors){
        for(int i=0; i<powersOf10; i++){

            //perform montecarlo on the 2 senarios
            double keep = monteCarlo.keepDoor((int)(Math.pow(10,i)), doors);
            double change = monteCarlo.changeDoor((int)(Math.pow(10,i)), doors);

            //Create Pairs of results in current loop to help with easy CSV exporting
            MCPair pairKeep = new MCPair((int)Math.pow(10,i), keep);
            MCPair pairChange = new MCPair((int)Math.pow(10,i), change);
            

            //add pairs to the ArrayLists
            keepDoorCoordinates.add(pairKeep);
            changeDoorCoordinates.add(pairChange);
        }
        //write the 2 lists to separate CSV files so you can compare results
        csvWriter.writeToCSV(keepDoorCoordinates, "keepDoorTest.csv");
        csvWriter.writeToCSV(changeDoorCoordinates, "changeDoorTest.csv");
        
    }
    
}
