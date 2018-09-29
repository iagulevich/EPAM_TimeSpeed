package services;

import domain.Speed;
import domain.Time;

public class Calculator {

    private double distance(Double speed, Double time) {
        return speed * time;
    }
}
