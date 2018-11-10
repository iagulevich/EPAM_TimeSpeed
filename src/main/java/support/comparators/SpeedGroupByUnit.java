package support.comparators;

import domain.Speed;
import support.identifiers.SpeedUnit;

import java.util.Collections;
import java.util.Comparator;

public class SpeedGroupByUnit implements Comparator<Speed> {
    @Override
    public int compare(Speed o1, Speed o2) {
        return Integer.compare(SpeedUnit.getUnit(o1.getUnit()).ordinal()
                , SpeedUnit.getUnit(o2.getUnit()).ordinal());
    }

    @Override
    public Comparator<Speed> reversed() {
        return Collections.reverseOrder(this);
    }
}
