package domain;

public class Speed extends Convertible {

    public Speed(String value, String unit) {
        super(value,unit);
    }

    public Double getDoubleValue() {
        return Double.parseDouble(getValue());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
