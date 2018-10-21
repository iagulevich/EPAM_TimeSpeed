package support.identifiers;

import support.constants.Constants;

import java.util.Arrays;

public enum SpeedUnit {
    KMH(Constants.KMH),
    MPH(Constants.MPH),
    KN(Constants.KN),
    MS(Constants.MS);

    private final String symbol;

    SpeedUnit(String symbol) {
        this.symbol = symbol;
    }

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
