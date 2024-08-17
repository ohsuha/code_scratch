package test.enumtest;

public enum Direction {
    EAST(1, ">"),
    WEST(2, "<"),
    NORTH(3, "^"),
    SOUTH(4, "v");

    private static final Direction[] DIR_ARR = Direction.values();
    private int value;
    private String symbol;
    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction of(int value) {
        if (value < 1 || value > 4) {
            throw new IllegalArgumentException();
        }
        return DIR_ARR[value - 1];
    }

    public Direction rotate(int num) {
        num = num % 4;
        if (num < 0) { num += 4; }
        return DIR_ARR[(value-1+num)%4];
    }
    public String toString() {
        return name() + " " + getSymbol();
    }
}
