public class Time {

    private String value;
    private String unit;

    public Time(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
       /* StringBuilder sb = new StringBuilder();
        return sb.append(value).append(" ").append(unit).toString();
       */
       return value + " " + unit;
    }
}
