package services;

import domain.Speed;
import services.interfaces.Service;
import support.DataManager;
import support.sections.ConvertOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter implements Service {

    private DataManager dataManager;

    public Converter(List<String> list) {
        dataManager = new DataManager(list);
    }

    private static double toMS(Speed speed) {
        switch (speed.getUnit()) {
            case "kmh":
                return speed.getDoubleValue() * 3600 / 1000;
            case "mph":
                return speed.getDoubleValue() * 3600 / 1609;
            case "kn":
                return speed.getDoubleValue() * 3600 / 1852;
            default:
                return speed.getDoubleValue();
        }
    }

    public static List<Double> speedsToMS(List<Speed> speeds) {
        return speeds.stream()
                .map(Converter::toMS)
                .collect(Collectors.toList());
    }


    @Override
    public List<String> apply(List<String> convertibles, Enum section) {
        return speedsToMS(dataManager.getSpeeds()).stream()
                .map(aDouble -> aDouble + " ms")
                .collect(Collectors.toList());
    }
}
