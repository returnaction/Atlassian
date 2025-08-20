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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightsPrinter.print("Все тестовые перелёты", flights);

        Filter filter1 = new PastDepartureFilter();
        Filter filter2 = new ArrivalBeforeTakeoffFilter();
        Filter filter3 = new TooLongGroundTimeFilter();
        CompletableFuture<Void> f1 = CompletableFuture.supplyAsync(() ->
                        FlightFilterService.apply(filter1, flights))
                .thenAccept(result -> FlightsPrinter.print(filter1.rule().label(), result));

        CompletableFuture<Void> f2 = CompletableFuture.supplyAsync(() ->
                        FlightFilterService.apply(filter2, flights))
                .thenAccept(result -> FlightsPrinter.print(filter2.rule().label(), result));

        CompletableFuture<Void> f3 = CompletableFuture.supplyAsync(() ->
                        FlightFilterService.apply(filter3, flights))
                .thenAccept(result -> FlightsPrinter.print(filter3.rule().label(), result));

        CompletableFuture.allOf(f1, f2, f3).get();

    }
}
