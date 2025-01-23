package service;

import model.FlightRecord;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

    private double getPassengersByCityAndYear(String city, int year) {
        return flightRecords.stream()
                .filter(flightRecord -> flightRecord.city().equalsIgnoreCase(city) && flightRecord.year() == year)
                .mapToDouble(FlightRecord::passengerCount)
                .sum();
    }

    public void passengerTrendsByCity(String city, int endYear, int startYear) {
        double passengerCountStart = getPassengersByCityAndYear(city, startYear);
        double passengerCountEnd = getPassengersByCityAndYear(city, endYear);

        double trend = ((passengerCountEnd - passengerCountStart) / passengerCountStart) * 100;

        System.out.printf("%s trend: %.4f%%%n", city, trend);
    }
}
