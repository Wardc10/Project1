import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class PokeCSVWriter {

    public void writeToCSV(ArrayList<Double> data, String fileName) {

        try(FileWriter writer = new FileWriter(fileName)) {
            for(Double i : data) {
                writer.write(i.toString());
                writer.write(",");
            }
            writer.write("\n");
        }
        catch(IOException e) {
            System.out.println("Error while printing to CSV");
            e.printStackTrace();
        }
    }
}
