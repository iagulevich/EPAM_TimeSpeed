package domain;

public class Distance extends Convertible implements Comparable<Distance> {

    public Distance(String value, String unit) {
        super(value, unit);
    }

    public Double getDoubleValue() {
        return Double.parseDouble(getValue());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Distance o) {
        return Double.compare(getDoubleValue(), o.getDoubleValue());
    }
}
