import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {
    //method that takes in an arraylist of Pairs "graph points" and writes it to a CSV file
    public void writeToCSV(ArrayList<Pair> coordinates, String filePath){
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Pair p : coordinates) {
                writer.write(p.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}