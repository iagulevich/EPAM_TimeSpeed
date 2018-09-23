package support.identifiers;

import java.util.Arrays;

public enum SpeedUnit {
    KMH("kmh"),
    MPH("mph"),
    KN("kn"),
    MS("ms");

    private String symbol;

    SpeedUnit(String symbol) {
        this.symbol = symbol;
    }

    /*public static void get(Function<Double, Double> f, double i) {
        System.out.println(f.apply(i));
    }*/
    public static SpeedUnit getUnit(String symbol) {
        return Arrays.stream(values())
                .filter(speedUnit -> speedUnit.symbol.equals(symbol))
                .findFirst()
                .orElse(null);
    }

    public static boolean isSpeedUnit(String symbol) {
        return getUnit(symbol) != null;
    }

    public String getSymbol() {
        return symbol;
    }

}
