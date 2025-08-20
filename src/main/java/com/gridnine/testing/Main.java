package com.gridnine.testing;

import com.gridnine.testing.filter.ArrivalBeforeTakeoffFilter;
import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.PastDepartureFilter;
import com.gridnine.testing.filter.TooLongGroundTimeFilter;
import com.gridnine.testing.helpers.FlightFilterService;
import com.gridnine.testing.helpers.FlightsPrinter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightsPrinter.print("Все тестовые перелёты", flights);

        Filter filter1 = new PastDepartureFilter();
        List<Flight> filter1Result = FlightFilterService.apply(filter1, flights);
        FlightsPrinter.print(filter1.rule().label(), filter1Result);

        Filter filter2 = new ArrivalBeforeTakeoffFilter();
        List<Flight> filter2Result = FlightFilterService.apply(filter2, flights);
        FlightsPrinter.print(filter2.rule().label(), filter2Result);

        Filter filter3 = new TooLongGroundTimeFilter();
        List<Flight> filter3Result = FlightFilterService.apply(filter3, flights);
        FlightsPrinter.print(filter3.rule().label(), filter3Result);
    }
}
