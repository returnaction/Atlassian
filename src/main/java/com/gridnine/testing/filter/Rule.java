package com.gridnine.testing.filter;

public enum Rule {
    PAST_DEPARTURE(1, "вылет до текущего момента времени"),
    ARRIVAL_BEFORE_TAKEOFF(2, "имеются сегменты с датой прилёта раньше даты вылета"),
    GROUND_TIME_EXCEEDS(3, "общее время, проведённое на земле, превышает два часа (время на земле —" +
            " это интервал между прилётом одного сегмента и вылетом следующего за ним)");

    private final int order;
    private final String description;

    Rule(int order, String description) {
        this.order = order;
        this.description = description;
    }

    public String label() {
        return order + ". " + description;
    }
}
