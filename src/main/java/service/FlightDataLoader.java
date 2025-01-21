package service;

import model.FlightRecord;
import model.TrafficType;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FlightDataLoader {
    private final static String charsetName = String.valueOf(StandardCharsets.UTF_8);
    private String filePath;

    public FlightDataLoader(String filePath) throws IllegalArgumentException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Filepath is empty or null");
        }

        this.filePath = filePath;
    }

    public List<FlightRecord> parseCsv() {
        List<FlightRecord> flightRecords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charsetName))) {
            reader.readLine(); // skip headers

            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    FlightRecord flightRecord = getFlightRecord(line);
                    flightRecords.add(flightRecord);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading filepath in bufferedReader: " + e.getMessage());
        }

        return flightRecords;
    }

    private FlightRecord getFlightRecord(String line) {
        System.out.println(line);
        String[] fields = line.split(",");

        String title = fields[0];
        TrafficType trafficType = TrafficType.fromPolish(fields[1]);

        if (fields.length != 7) {
            throw new IllegalArgumentException("Invalid data format in the line");
        }

        return new FlightRecord(title, trafficType, "", 2024, "1Q", 100, 0.0001);
    }
}
