package com.example.android.weather_report_for_practise.DataModel;

public class DayWrapper {
    private final Day day;
    private boolean expanded;

    public DayWrapper(Day day, boolean expanded) {
        this.day = day;
        this.expanded = expanded;
    }

    public Day getDay() {
        return day;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
