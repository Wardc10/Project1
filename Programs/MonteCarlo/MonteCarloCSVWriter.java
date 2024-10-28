import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MonteCarloCSVWriter {
    //method that takes in an arraylist of Pairs "graph points" and writes it to a CSV file
    public void writeToCSV(ArrayList<MCPair> coordinates, String filePath){
        String header = "plays,win%";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(header + "\n");
            for (MCPair p : coordinates) {
                writer.write(p.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
