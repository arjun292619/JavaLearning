package dev.lpa.EnumExercise;

public enum Direction {
    EAST('E'), WEST('W'), NORTH('N'), SOUTH('S');
    private char sign;

    Direction(char sign) {
        this.sign = sign;
    }

    public char getDirectionSign() {
        return this.sign;
    }
}
