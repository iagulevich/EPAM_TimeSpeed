package domain;

public class Distance extends Convertible {

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
}
