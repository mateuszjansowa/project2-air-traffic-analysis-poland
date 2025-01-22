package model;

import java.util.Map;

public enum TrafficType {
    INTERNATIONAL, DOMESTIC;

    private static final Map<String, TrafficType> MAPPING = Map.of(
            "miedzynarodowy ruch regularny", INTERNATIONAL,
            "krajowy ruch regularny", DOMESTIC
    );

    public static TrafficType fromPolish(String entry) {
        TrafficType type = MAPPING.get(entry);

        if (type == null) {
            throw new IllegalArgumentException("Unknown traffic type: " + entry);
        }

        return type;
    }
}
