package model;

public record FlightRecord(String title,
                           TrafficType trafficType,
                           String country,
                           int year,
                           TimePeriod timePeriod,
                           int passengerCount,
                           double marketShare) {
}
