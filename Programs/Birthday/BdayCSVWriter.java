import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BdayCSVWriter {
    //method that takes in an arraylist of Pairs "graph points" and writes it to a CSV file
    public void writeToCSV(ArrayList<BdayPair> coordinates, String filePath){
        try (FileWriter writer = new FileWriter(filePath)) {
            for (BdayPair p : coordinates) {
                writer.write(p.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
