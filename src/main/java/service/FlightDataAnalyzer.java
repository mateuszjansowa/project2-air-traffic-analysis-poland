package service;

import model.FlightRecord;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FlightDataAnalyzer {
    private List<FlightRecord> flightRecords;

    public FlightDataAnalyzer(List<FlightRecord> flightRecords) {
        if (flightRecords == null || flightRecords.isEmpty()) {
            throw new IllegalArgumentException("flightRecords cannot be empty");
        }

        this.flightRecords = flightRecords;
    }

    private Stream<FlightRecord> filterByYear(int year) {
        return flightRecords.stream()
                .filter(flightRecord -> flightRecord.year() == year);
    }

    public int totalPassengersByYear(int year) {
        return filterByYear(year)
                .mapToInt(FlightRecord::passengerCount) // IntStream extracts the passengerCount as an int
                .sum();
    }

    public String busiestDestination(int year) {
        return filterByYear(year)
                .max(Comparator.comparingInt(FlightRecord::passengerCount))
                .map(FlightRecord::city)
                .orElse("No data");
    }

    public void passengerTrendsByCity(String city) {
        // TODO - do not complete for me
        System.out.println("London -> " + "12%");
    }
}
