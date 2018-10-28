package services;

import domain.Convertible;
import domain.ConvertibleFactory;
import domain.Speed;
import services.interfaces.Service;
import support.Formatter;
import support.exception.MyException;
import support.identifiers.SpeedUnit;

import java.util.List;
import java.util.stream.Collectors;

import static support.constants.Constants.SPACE;

public class Converter implements Service {

    public static double toMS(Convertible convertible) {
        if (convertible instanceof Speed) {
            Speed speed = (Speed) convertible;
            switch (speed.getUnit()) {
                case "kmh":
                    return speed.getDoubleValue() * 1000 / 3600;
                case "mph":
                    return speed.getDoubleValue() * 1609 / 3600;
                case "kn":
                    return speed.getDoubleValue() * 1852 / 3600;
                default:
                    return speed.getDoubleValue();
            }
        }
        throw new MyException("Incorrect input: can't converts toMS.");
    }

    public static double toKMH(Convertible convertible) {
        if (convertible instanceof Speed) {
            Speed speed = (Speed) convertible;
            switch (speed.getUnit()) {
                case "mph":
                    return speed.getDoubleValue() * 1.609;
                case "kn":
                    return speed.getDoubleValue() * 1.852;
                case "ms":
                    return speed.getDoubleValue() * 3600 / 1000;
                default:
                    return speed.getDoubleValue();
            }
        }
        throw new MyException("Incorrect input: can't converts toKMH.");
    }

    public static double toMPH(Convertible convertible) {
        if (convertible instanceof Speed) {
            Speed speed = (Speed) convertible;
            switch (speed.getUnit()) {
                case "kmh":
                    return speed.getDoubleValue() / 1.609;
                case "kn":
                    return speed.getDoubleValue() / 0.869;
                case "ms":
                    return speed.getDoubleValue() * 1609 / 3600;
                default:
                    return speed.getDoubleValue();
            }
        }
        throw new MyException("Incorrect input: can't converts toMPH.");
    }

    public static double toKN(Convertible convertible) {
        if (convertible instanceof Speed) {
            Speed speed = (Speed) convertible;
            switch (speed.getUnit()) {
                case "kmh":
                    return speed.getDoubleValue() / 1.852;
                case "mph":
                    return speed.getDoubleValue() * 0.869;
                case "ms":
                    return speed.getDoubleValue() * 3600 / 1852;
                default:
                    return speed.getDoubleValue();
            }
        }
        throw new MyException("Incorrect input: can't converts toKN.");
    }

    public static List<Double> speedsToMS(List<Speed> speeds) {
        return speeds.stream()
                .map(Converter::toMS)
                .collect(Collectors.toList());
    }

    @Override
    public String apply(String convertibles, SpeedUnit speedUnit) {
        Convertible convertible;
        try {
            convertible = ConvertibleFactory.create(convertibles);
            return Formatter.format(speedUnit.getFunction().apply(convertible)) + SPACE + speedUnit.getSymbol();
        } catch (Exception e) {
            return convertibles + " - " + e.getMessage();
        }
    }
}
