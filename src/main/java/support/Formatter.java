package support;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatter {

    public static String format(Double d) {
        Locale locale = new Locale("en", "UK");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        String format = d % 1 == 0 ? "##0" : "##0.00";
        DecimalFormat df = new DecimalFormat(format, dfs);
        return df.format(d);
    }
}
