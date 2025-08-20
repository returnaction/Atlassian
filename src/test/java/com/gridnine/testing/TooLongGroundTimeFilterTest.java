package com.gridnine.testing;

import com.gridnine.testing.filter.TooLongGroundTimeFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TooLongGroundTimeFilterTest {

    @Test
    void excludesFlightsWithTotalGroundTimeOverTwoHours() {
        List<Flight> flights = FlightBuilder.createFlights();

        TooLongGroundTimeFilter sut = new TooLongGroundTimeFilter();
        List<Flight> result = sut.filter(flights);

        assertEquals(4, result.size());
        assertFalse(result.contains(flights.get(4)));
        assertFalse(result.contains(flights.get(5)));
    }

    @Test
    void throwsExceptionWhenInputIsNull() {
        TooLongGroundTimeFilter sut = new TooLongGroundTimeFilter();
        assertThrows(NullPointerException.class, () -> sut.filter(null));
    }
}
