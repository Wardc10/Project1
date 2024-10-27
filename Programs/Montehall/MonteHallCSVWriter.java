import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MonteHallCSVWriter {
    //method that takes in an arraylist of Pairs "graph points" and writes it to a CSV file
    public void writeToCSV(ArrayList<MHPair> coordinates, String filePath){
        String header = "plays,win%";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(header + "\n");
            for (MHPair p : coordinates) {
                writer.write(p.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
