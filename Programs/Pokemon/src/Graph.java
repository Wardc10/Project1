import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;

public class Graph {

    //construct a CardGame object to use in the graph method
    CardGame tcg = new CardGame();
    //create an arraylist to hold our points to graph
    private ArrayList<Double> graphPoints = new ArrayList<>();

    public void graph(int maxPokemon, int numRuns){

        for(int i=0; i<maxPokemon; i++){
            graphPoints.add(tcg.monteCarlo(i, numRuns));
        }
    }

    public void writeData(String filePath){
        File CSVfile = new File(filePath);
        try{
            //create the fileWriter
            FileWriter outputfile = new FileWriter(CSVfile);
            //create the CSVWriter
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"Pkm in Deck", "Avg # of hands to play a pkm"};
            for(int i=0; i<graphPoints.size(); i++){
                if(i==0){
                    writer.writeNext(header);
                }
                else{

                    String[] nextValue = {String.valueOf(i+1), String.valueOf(graphPoints.get(i))};
                    writer.writeNext(nextValue);
                }

            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    
}
