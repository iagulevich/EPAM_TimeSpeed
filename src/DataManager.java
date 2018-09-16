import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private List<String> list;
    private List<AbstractData> dataList;

    public DataManager(List<String> list) {
        this.list = list;
    }

    public DataManager() {
    }

    private void dataListCreator(){
        dataList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            dataList.add( i == 0 ? createTime(list.get(i)) : createSpeed(list.get(i)));
        }
    }

    public Time getTime(){
        return (Time) dataList.get(0);
    }

    public List<Speed> getSpeeds(){
        if(dataList == null) dataListCreator();
        ArrayList<Speed> speeds = new ArrayList<>();
        dataList.subList(1, dataList.size())
                .forEach(abstractData -> speeds.add((Speed) abstractData));
        return speeds;
    }

    private Time createTime(String s ){

        String[] split = split(s);
        return new Time(split[0],split[1]);
    }

    private Speed createSpeed(String s){

        String[] split = split(s);
        return new Speed(split[0],split[1]);
    }

    private String[] split(String s) {
        return s.split(" ");
    }
}
