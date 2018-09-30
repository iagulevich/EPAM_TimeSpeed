package services;

import domain.Speed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public double toMS(Speed speed) {
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

    public List<Double> speedsToMS(List<Speed> speeds) {
        return speeds.stream()
                .map(this::toMS)
                .collect(Collectors.toList());
    }


}
