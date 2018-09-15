public abstract class AbstractData {
    private String value;
    private String unit;

    public AbstractData(String value, String unit) {
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
