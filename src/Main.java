import com.sun.org.apache.xpath.internal.SourceTree;
import domain.Distance;
import domain.Speed;
import services.Calculator;
import services.Converter;
import support.DataManager;
import support.Reader;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        try {
            List<String> read = new Reader(args[0]).read();
            List<Speed> speeds = new DataManager(read).getSpeeds();
            List<Double> ms = new Converter().speedsToMS(speeds);
            for (int i = 0; i < speeds.size(); i++) {
                System.out.println(speeds.get(i) + " = " + format(ms.get(i)) + " ms");
            }

            DataManager dataManager = new DataManager(read);
            Distance[] distances = new Calculator().distancesInM(dataManager.getTime(), speeds);
            System.out.println(Arrays.toString(distances));

            //Arrays.stream(distances).anyMatch(distance -> distance.getDoubleValue() >= 500 && distance.getDoubleValue() <=501);
            System.out.println(Arrays.stream(distances)
                    .anyMatch(distance -> distance.getDoubleValue() >= 500
                            && distance.getDoubleValue() <= 501) ? "yes" : "no");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String format(Double d) {
        Locale locale = new Locale("en", "UK");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        String format = d % 1 == 0 ? "##0" : "##0.00";
        DecimalFormat df = new DecimalFormat(format, dfs);
        return df.format(d);
    }
}
