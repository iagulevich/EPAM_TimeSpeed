package services;

import domain.Distance;
import domain.Speed;
import domain.Time;

import java.util.Collections;
import java.util.List;

public class Calculator {

    public Distance[] distancesInM(Time time, List<Speed> speeds) {
        return speeds.stream()
                .map(speed -> new Distance(String.valueOf(distance(speed.getDoubleValue(), time.getIntValue())), "m"))
                .sorted(Collections.reverseOrder()).toArray(Distance[]::new);
    }

    private double distance(Double speed, Integer time) {
        return speed * time;
    }
}
