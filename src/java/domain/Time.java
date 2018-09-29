package domain;

public class Time extends Convertible {

    public Time(String value, String unit) {
        super(value,unit);
    }

    public Integer getIntValue() {
        return Integer.parseInt(getValue());
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
