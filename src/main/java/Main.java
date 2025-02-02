import model.FlightRecord;
import service.FlightDataAnalyzer;
import service.FlightDataLoader;

import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final String INPUT_FILE = Paths.get("src", "main", "resources", "input", "flight_data_2022_2023.csv").toString();
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            FlightDataLoader flightDataLoader = new FlightDataLoader(INPUT_FILE);
            List<FlightRecord> flightRecords = flightDataLoader.parseCsv();
            FlightDataAnalyzer flightDataAnalyzer = new FlightDataAnalyzer(flightRecords);

            System.out.println("Passengers by year 2022: " + flightDataAnalyzer.totalPassengersByYear(2022));
            System.out.println("Passengers by year 2023: " + flightDataAnalyzer.totalPassengersByYear(2023));
            System.out.println("Passengers by year 2024: " + flightDataAnalyzer.totalPassengersByYear(2024));

            System.out.println("Busiest destination in year 2022: " + flightDataAnalyzer.busiestDestination(2022));
            System.out.println("Busiest destination in year 2023: " + flightDataAnalyzer.busiestDestination(2023));

            flightDataAnalyzer.passengerTrendsByCity("Oslo", 2023, 2022);
            flightDataAnalyzer.passengerTrendsByCity("Londyn", 2023, 2022);
            flightDataAnalyzer.passengerTrendsByCity("Frankfurt", 2023, 2022);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error executing main class", e);
        }
    }
}
