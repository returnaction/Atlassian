package com.gridnine.testing.helpers;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.List;

public final class FlightFilterService {
    private FlightFilterService() {
    }

    public static List<Flight> apply(Filter filter, List<Flight> flights) {
        return filter.filter(flights);
    }
}
