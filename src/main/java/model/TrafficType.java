package model;

import java.util.Map;

public enum TrafficType {
    INTERNATIONAL, DOMESTIC;

    private static final Map<String, TrafficType> MAPPING = Map.of(
            "miedzynarodowy ruch regularny", INTERNATIONAL,
            "krajowy ruch regularny", DOMESTIC
    );

    public static TrafficType fromPolish(String entry) {
        return MAPPING.getOrDefault(entry, null);
    }
}
