package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TooLongGroundTimeFilter implements Filter {

    private static final Duration MAX_GROUND_TIME = Duration.ofHours(2);

    @Override
    public Rule rule() {
        return Rule.GROUND_TIME_EXCEEDS;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(TooLongGroundTimeFilter::isGroundTimeGood)
                .collect(Collectors.toList());
    }

    private static boolean isGroundTimeGood(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long totalMinutes = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
            long gap = Duration.between(arrival, nextDeparture).toMinutes();
            if (gap > 0) {
                totalMinutes += gap;
            }
        }
        return totalMinutes <= MAX_GROUND_TIME.toMinutes();
    }
}
