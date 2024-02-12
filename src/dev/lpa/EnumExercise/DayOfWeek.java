package dev.lpa.EnumExercise;

public enum DayOfWeek {
    SUN, MON, TUES, WED, THURS, FRI, SAT;

    public DayOfWeek switchDayOfWeek() {
        int ordinalVal = this.ordinal();
        return ordinalVal < 6 ? DayOfWeek.values()[ordinalVal + 1] : DayOfWeek.values()[0];
    }

}
