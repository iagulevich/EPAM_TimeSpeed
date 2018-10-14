package services;

import domain.Distance;
import domain.Speed;
import domain.Time;
import services.interfaces.Service;
import sun.applet.Main;
import support.Formatter;
import support.sections.CalcOperations;
import support.sections.ConvertOperations;

import java.util.Collections;
import java.util.List;

public class Calculator implements Service {

    public Distance[] distancesInM(Time time, List<Speed> speeds) {
        return speeds.stream()
                .map(speed -> new Distance(Formatter.format(distance(speed.getDoubleValue(), time.getIntValue())), "m"))
                .sorted(Collections.reverseOrder()).toArray(Distance[]::new);
    }

    private double distance(Double speed, Integer time) {
        return speed * time;
    }


    @Override
    public List<String> apply(List<String> convertibles, Enum section) {
        return null;
    }
}
