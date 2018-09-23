package domain;

public class Speed extends Convertible {

    public Speed(String value, String unit) {
        super(value,unit);
    }

    @Override
    public String toString() {
       /* StringBuilder sb = new StringBuilder();
        return sb.append(value).append(" ").append(unit).toString();
       */
        return super.toString();
    }

}
