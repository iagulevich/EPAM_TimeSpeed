package support;

import domain.Convertible;
import domain.ConvertibleFactory;
import domain.Speed;
import domain.Time;
import support.comparators.SpeedGroupByUnit;
import support.comparators.SpeedSortByValue;

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
        dataList = list.stream().map(ConvertibleFactory::create).collect(Collectors.toList());
    }

    public Time getTime(){
        if (dataList == null) dataListCreator();
        return (Time) dataList.get(0);
    }

    public List<Speed> getSpeeds(){
        if(dataList == null) dataListCreator();
        return dataList.subList(1, dataList.size()).stream()
                .map(abstractData -> (Speed) abstractData)
                .collect(Collectors.toList());
    }

    public List<Speed> getSortedSpeeds(List<Speed> speeds) {
        return speeds.stream()
                .sorted(new SpeedSortByValue())
                .sorted(new SpeedGroupByUnit())
                .collect(Collectors.toList());
    }



}
