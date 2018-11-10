import domain.Distance;
import domain.Speed;
import services.Calculator;
import services.Converter;
import support.DataManager;
import support.Reader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static support.Formatter.format;

public class Main {
    public static void main(String[] args) {

        try {
            List<String> read = new Reader(args[0]).read();

            List<Speed> speeds = new DataManager(read).getSpeeds();
            List<Double> ms = Converter.speedsToMS(speeds);
            for (int i = 0; i < speeds.size(); i++) {
                System.out.println(speeds.get(i) + " = " + format(ms.get(i)) + " ms");
            }
            DataManager dataManager = new DataManager(read);
            Distance[] distances = new Calculator().distancesInM(dataManager.getTime(), speeds);

            Arrays.stream(distances).forEach(distance -> System.out.println(distance.getValue()));

            System.out.println(Arrays.stream(distances)
                    .anyMatch(distance -> distance.getDoubleValue() >= 500
                            && distance.getDoubleValue() <= 501) ? "yes" : "no");

            dataManager.getSortedSpeeds(speeds).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
