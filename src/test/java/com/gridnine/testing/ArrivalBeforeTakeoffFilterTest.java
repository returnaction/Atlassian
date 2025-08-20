package com.gridnine.testing;

import com.gridnine.testing.filter.ArrivalBeforeTakeoffFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrivalBeforeTakeoffFilterTest {
    @Test
    void excludesFlightsWithArrivalBeforeTakeoff() {
        List<Flight> flights = FlightBuilder.createFlights();

        ArrivalBeforeTakeoffFilter sut = new ArrivalBeforeTakeoffFilter();
        List<Flight> result = sut.filter(flights);

        assertEquals(5, result.size());
        assertFalse(result.contains(flights.get(3)));
    }

    @Test
    void throwsExceptionWhenInputIsNull() {
        ArrivalBeforeTakeoffFilter sut = new ArrivalBeforeTakeoffFilter();
        assertThrows(NullPointerException.class, () -> sut.filter(null));
    }
}
