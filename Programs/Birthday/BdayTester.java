import java.text.DecimalFormat;
import java.util.ArrayList;

public class BdayTester {

    //minPeople & maxPeople variables act as lower & upper bounds for the birthday checker test
    //private int minPeople = 10;
    //private int maxPeople = 50;

    //variable to adjust number of runs in the simulation
    //private int runs = 10000;

    //creates a decimal format to round to 2 decimal places
    private DecimalFormat d = new DecimalFormat("#.####");

    //initializes the birthdayChecker
    private Birthday checker = new Birthday();

    //CSV filename for the graphBirthdays method. changing will adjust the name of 
    private String fileName = "birthdayTest";

    //method to take averages of a shared birthday from 'minPeople' to 'maxPeople' and exports the results to a CSV file of 'filename'
    public void graphBirthdays(int minPeople, int maxPeople, int runs){
        
        //create an arraylist of Pairs for easy csv exporting
        ArrayList<BdayPair> coordinates = new ArrayList<BdayPair>();
        //initializes the CSVWriter
        BdayCSVWriter csvWriter = new BdayCSVWriter();

        //Calls birthday Checker passing through number of runs, and number of random people to create and test
        for(int i=minPeople; i<=maxPeople; i++){

            //run checker to calculate the sharedBirthdayAvg
            BdayPair coordinate = new BdayPair(i, checker.sharedBirthdayAvg(runs, i));
            coordinates.add(coordinate);
        }

        //CALL CSV WRITER ON GRAPHPOINTS 
        csvWriter.writeToCSV(coordinates, fileName+".csv");
    }

    //method to test and print averages of a shared birthday from 'minPeople' to 'maxPeople' over 'runs' runs to the console
    public void testBirthdays(int minPeople, int maxPeople, int runs){

        for(int i=minPeople; i<=maxPeople; i++){

            double avg = checker.sharedBirthdayAvg(runs, i);
            System.out.println("The avg probability 2 people out of " + i + " share a birthday, after " + runs + " runs: " +d.format(avg));
        }
    }
}
