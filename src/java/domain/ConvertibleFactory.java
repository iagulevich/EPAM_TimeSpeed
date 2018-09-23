package domain;

import static support.identifiers.SpeedUnit.isSpeedUnit;
import static support.identifiers.TimeUnit.isTimeUnit;

public class ConvertibleFactory {

    public static Convertible create(String s) {

        String[] separated = s.split(" ");

        return (isSpeedUnit(separated[1]) ? new Speed(separated[0], separated[1]) :
                   /*isTimeUnit(separated[1]) ?*/ new Time(separated[0], separated[1]));
    }

}
