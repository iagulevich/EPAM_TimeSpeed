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
        for (int i = 0; i < list.size(); i++) {
            dataList.add( i == 0 ? createTime(list.get(i)) : createSpeed(list.get(i)));
        }
    }

    public Time getTime(){
        if (dataList == null) dataListCreator();
        return (Time) dataList.get(0);
    }

    /*public List<Speed> getSpeeds(){
        return (List<Speed>) list.subList(1, list.size());
    }
*/
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
