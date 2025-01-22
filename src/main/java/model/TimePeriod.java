package model;

import java.util.Map;

public enum TimePeriod {
    Q12, Q34;

    private static final Map<String, TimePeriod> MAPPING = Map.of(
            "pierwsza polowa roku", Q12,
            "druga polowa roku", Q34
    );

    public static TimePeriod fromPolish(String entry) {
        TimePeriod timePeriod = MAPPING.get(entry);

        if (timePeriod == null) {
            throw new IllegalArgumentException("timePeriod is null");
        }

        return timePeriod;
    }
}
