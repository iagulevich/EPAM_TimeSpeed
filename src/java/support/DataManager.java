package support;

import domain.Convertible;
import domain.Speed;
import domain.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataManager {

    private List<String> list;
    private List<Convertible> dataList;

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
        /*ArrayList<domain.Speed> speeds = new ArrayList<>();
        dataList.subList(1, dataList.size())
                .forEach(abstractData -> speeds.add((domain.Speed) abstractData));
        return speeds;*/
        return dataList.subList(1, dataList.size()).stream()
                .map(abstractData -> (Speed) abstractData)
                .collect(Collectors.toList());
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
