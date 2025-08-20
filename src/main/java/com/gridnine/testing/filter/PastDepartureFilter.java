package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PastDepartureFilter implements Filter {

    @Override
    public Rule rule() {
        return Rule.PAST_DEPARTURE;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> !flight.getSegments().isEmpty() &&
                        flight.getSegments().get(0).getDepartureDate().isAfter(now))
                .collect(Collectors.toList());
    }
}
