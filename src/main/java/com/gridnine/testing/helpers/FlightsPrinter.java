package com.gridnine.testing.helpers;

import com.gridnine.testing.model.Flight;

import java.util.List;

public final class FlightsPrinter {

    private FlightsPrinter() {
    }

    public static void print(String title, List<Flight> flights) {
        System.out.println("\n" + title);
        if (flights == null || flights.isEmpty()) {
            System.out.println("нет перелётов");
            return;
        }
        flights.forEach(System.out::println);
    }
}
