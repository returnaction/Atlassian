package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeTakeoffFilter implements Filter {

    @Override
    public Rule rule() {
        return Rule.ARRIVAL_BEFORE_TAKEOFF;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
