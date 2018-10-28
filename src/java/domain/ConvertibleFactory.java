package domain;

import support.exception.MyException;

import static support.identifiers.DistanceUnit.isDistance;
import static support.identifiers.SpeedUnit.isSpeedUnit;
import static support.identifiers.TimeUnit.isTimeUnit;

public class ConvertibleFactory {

    public static Convertible create(String s) {

        String[] separated = s.split("[\\s]+");

        if (isSpeedUnit(separated[1])) {
            return new Speed(separated[0], separated[1]);
        } else if (isTimeUnit(separated[1])) {
            return new Time(separated[0], separated[1]);
        } else if (isDistance(separated[1])) {
            return new Distance(separated[0], separated[1]);
        }

        throw new MyException(" Unknown unit ");

       /* return (isSpeedUnit(separated[1]) ? new Speed(separated[0], separated[1]) :
                isTimeUnit(separated[1]) ? new Time(separated[0], separated[1]) :
                        new Distance(separated[0], separated[1]));*/

    }

}
