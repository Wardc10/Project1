import java.util.ArrayList;

public class MHTester {

    public MHTester(){

    }

    //initialize the monteCarlo game
    Game monteCarlo = new Game();

    MonteHallCSVWriter csvWriter = new MonteHallCSVWriter();

    //initialize arraylist for our coordinate for each test
    ArrayList<MHPair> keepDoorCoordinates = new ArrayList<>();
    ArrayList<MHPair> changeDoorCoordinates = new ArrayList<>();


    //checkPow10 takes in an integer and runs the simulation for that many powers of 10 and output the results in a CSV
    public void checkPow10(int powersOf10, int doors){
        for(int i=0; i<powersOf10; i++){

            //perform montecarlo on the 2 senarios
            double keep = monteCarlo.keepDoor((int)(Math.pow(10,i)), doors);
            double change = monteCarlo.changeDoor((int)(Math.pow(10,i)), doors);

            //Create Pairs of results in current loop to help with easy CSV exporting
            MHPair pairKeep = new MHPair((int)Math.pow(10,i), keep);
            MHPair pairChange = new MHPair((int)Math.pow(10,i), change);
            

            //add pairs to the ArrayLists
            keepDoorCoordinates.add(pairKeep);
            changeDoorCoordinates.add(pairChange);
        }
        //write the 2 lists to separate CSV files so you can compare results
        csvWriter.writeToCSV(keepDoorCoordinates, "keepDoorTest.csv");
        csvWriter.writeToCSV(changeDoorCoordinates, "changeDoorTest.csv");
        
    }
    
}
