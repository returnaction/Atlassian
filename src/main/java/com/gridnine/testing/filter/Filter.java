package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface Filter {

    Rule rule();

    List<Flight> filter(List<Flight> flights);
}
