package model;

public record FlightRecord(String title,
                           TrafficType trafficType,
                           String city,
                           int year,
                           TimePeriod timePeriod,
                           int passengerCount,
                           double marketShare) {
}
