package support;

import domain.Convertible;
import domain.ConvertibleFactory;
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

    private void dataListCreator(){
        dataList = new ArrayList<>();
        /*for (String s: list) {
            dataList.add(ConvertibleFactory.create(s));
        }*/
        list.forEach(s -> dataList.add(ConvertibleFactory.create(s)));
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

}
