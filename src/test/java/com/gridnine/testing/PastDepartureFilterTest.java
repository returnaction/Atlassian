package com.gridnine.testing;

import com.gridnine.testing.filter.PastDepartureFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PastDepartureFilterTest {

    @Test
    void excludesFlightsDepartingInPast() {
        List<Flight> flights = FlightBuilder.createFlights();

        PastDepartureFilter sut = new PastDepartureFilter();
        List<Flight> result = sut.filter(flights);

        assertEquals(5, result.size());
        assertFalse(result.contains(flights.get(2)));
    }

    @Test
    void throwsExceptionWhenInputIsNull() {
        PastDepartureFilter sut = new PastDepartureFilter();
        assertThrows(NullPointerException.class, () -> sut.filter(null));
    }
}
