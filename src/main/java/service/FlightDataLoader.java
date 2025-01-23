package service;

import model.FlightRecord;
import model.TimePeriod;
import model.TrafficType;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class FlightDataLoader {
    private final static Charset charset= StandardCharsets.UTF_8;
    private String filePath;

    public FlightDataLoader(String filePath) throws IllegalArgumentException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Filepath is empty or null");
        }

        this.filePath = filePath;
    }

    public List<FlightRecord> parseCsv() {
        List<FlightRecord> flightRecords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset))) {
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
        String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        if (fields.length != 7) {
            throw new IllegalArgumentException("Invalid data format in the line: " + line);
        }

        String title = fields[0];
        TrafficType trafficType = TrafficType.fromPolish(fields[1]);
        String country = fields[2];
        int year = Integer.parseInt(fields[3]);
        TimePeriod timePeriod = TimePeriod.fromPolish(fields[4]);
        int passengerCount = Integer.parseInt(fields[5]);
        double marketShare = Double.parseDouble(fields[6]);

        return new FlightRecord(title, trafficType, country, year, timePeriod, passengerCount, marketShare);
    }
}
