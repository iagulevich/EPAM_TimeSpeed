package support.comparators;

import domain.Speed;

import java.util.Collections;
import java.util.Comparator;

public class SpeedSortByValue implements Comparator<Speed> {
    @Override
    public int compare(Speed o1, Speed o2) {
        return Double.compare(o1.getDoubleValue(), o2.getDoubleValue());
    }

    @Override
    public Comparator<Speed> reversed() {
        return Collections.reverseOrder(this);
    }
}
