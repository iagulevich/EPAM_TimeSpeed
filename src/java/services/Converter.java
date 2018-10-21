package services;

import domain.Convertible;
import domain.ConvertibleFactory;
import domain.Speed;
import services.interfaces.Service;
import support.DataManager;
import support.exception.MyExeption;
import support.identifiers.SpeedUnit;

import java.util.List;
import java.util.stream.Collectors;

public class Converter implements Service {

    private DataManager dataManager;

    public Converter() {
    }

    public Converter(List<String> list) {
        dataManager = new DataManager(list);
    }

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
        throw new MyExeption("Incorrect input: units are not agreed.");
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
            return toMS(convertible) + speedUnit.getSymbol();
        } catch (Exception e) {
            return convertibles + " - " + e.getMessage();
        }
    }
}
