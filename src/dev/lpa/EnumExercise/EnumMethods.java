package dev.lpa.EnumExercise;

import java.util.Arrays;
import java.util.Random;

public class EnumMethods {
    public static void main(String[] args) {
        String lineSeparator = "-".repeat(90);
        DayOfWeek tues = DayOfWeek.TUES;
        System.out.printf("Name is %s, ordinal value = %d%n", tues.name(), tues.ordinal());
        System.out.println(lineSeparator);
        for (int i = 0; i < 12; i++) {
            DayOfWeek day = getRandomDay();
            System.out.printf("Name is %s, ordinal value = %d%n", day.name(), day.ordinal());

            if (day == DayOfWeek.SUN) {
                System.out.println("Yay Sunday is a holiday");
            }
        }
        System.out.println(lineSeparator);
        Direction direction1 = getRandomDirection();
        System.out.println(Arrays.toString(Direction.values()));
        System.out.println(direction1);
        System.out.println(lineSeparator);
        for (int i = 0; i < 6; i++) {
            Direction direction = getRandomDirection();
            System.out.printf("Name is %s, ordinal value = %d Sign is: %c%n", direction.name(), direction.ordinal(),direction.getDirectionSign());
        }
    }

    private static DayOfWeek getRandomDay() {
        DayOfWeek[] days = DayOfWeek.values();
        int randomDay = new Random().nextInt(0, 7);
        return days[randomDay];
    }

    private static Direction getRandomDirection() {
        int random = new Random().nextInt(0,4);
        Direction[] directions = Direction.values();
        return directions[random];
    }
}
