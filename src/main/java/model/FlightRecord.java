package model;

public record FlightRecord(String title,
                           TrafficType trafficType,
                           String country,
                           int year,
                           String timePeriod,
                           int passengerCount,
                           double marketShare) {
}
