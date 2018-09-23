package support.identifiers;
import java.util.Arrays;

public enum TimeUnit {

    HOURS("h"),
    MINUTES("m"),
    SECONDS("s");

    private String symbol;

    TimeUnit(String name) {
        this.symbol = name;
    }

    public static TimeUnit getUnit(String symbol) {
        return Arrays.stream(values())
                .filter(timeUnit -> timeUnit.symbol.equals(symbol))
                .findFirst()
                .orElse(null);
    }

    public static boolean isTimeUnit(String s) {
        return getUnit(s) != null;
    }
}
