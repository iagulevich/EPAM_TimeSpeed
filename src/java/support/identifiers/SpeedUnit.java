package support.identifiers;

import domain.Convertible;
import services.Converter;
import support.constants.Constants;

import java.util.Arrays;
import java.util.function.Function;

public enum SpeedUnit {
    KMH(Constants.KMH, Converter::toKMH),
    MPH(Constants.MPH, Converter::toMPH),
    KN(Constants.KN, Converter::toKN),
    MS(Constants.MS, Converter::toMS);

    private final String symbol;
    private Function<Convertible, Double> function;

    SpeedUnit(String symbol, Function<Convertible, Double> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public Function<Convertible, Double> getFunction() {
        return function;
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
