import model.FlightRecord;
import service.FlightDataLoader;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = Paths.get("src", "main", "resources", "input", "flight_data_2022_2023.csv").toString();
    private static final String OUTPUT_FILE = Paths.get("src", "main", "resources", "output", "output.txt").toString();

    public static void main(String[] args) {
        try {
            FlightDataLoader flightDataLoader = new FlightDataLoader(INPUT_FILE);
            List<FlightRecord> flightRecords = flightDataLoader.parseCsv();

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE), StandardCharsets.UTF_8))) {
                writer.write("TEst: ą, ć, ę ł ó ń");
            }

            System.out.println(flightRecords);
        } catch (Exception e) {
            System.out.println("Error while executing main class: " + e.getMessage());
        }
    }
}
