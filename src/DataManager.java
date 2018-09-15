import java.util.List;

public class DataManager {

    private List<String> list;

    public DataManager(List<String> list) {
        this.list = list;
    }

    public DataManager() {
    }

    public Time getTime(String s){

        String[] split = s.split(" ");

        return new Time(split[0],split[1]);
    }
}
