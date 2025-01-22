package service;

import model.FlightRecord;

import java.util.List;

public class FlightDataAnalyzer {
    private List<FlightRecord> flightRecords;

    public FlightDataAnalyzer(List<FlightRecord> flightRecords) {
        if (flightRecords == null || flightRecords.isEmpty()) {
            throw new IllegalArgumentException("flightRecords cannot be empty");
        }

        this.flightRecords = flightRecords;
    }

    public int totalPassengersByYear(int year) {
        return -1;
    }

    public String busiestDestination(int year) {
        return "London??";
    }

    public void passengerTrendsByCity(String city) {
        System.out.println("London -> " + "12%");
    }
}
