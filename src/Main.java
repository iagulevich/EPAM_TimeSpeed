import domain.Distance;
import domain.Speed;
import services.Calculator;
import services.Converter;
import support.DataManager;
import support.Reader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static support.Formatter.format;

public class Main {
    public static void main(String[] args) {

        try {
            List<String> read = new Reader(args[0]).read();
            // =============   Чтение файла   ============
            /* Экземпляру интерфейса ЛИСТ присваиваем реализацию ArrayList
            *  полученную из метода getSpeeds() класса DataManager;
            *  -------------   getSpeeds()   -------------
            *  В этом методе происх.преобразование List <Convertible>
            *  в List<Speed> через кастование объектов, полученных из метода dataListCreator()
            *  в рамках stream API;
            *  -------------   dataListCreator()   -------------
            *  Полю класса List<Convertible> dataList присваивается реализация
            *  ArrayList содержащая экземпляры класса Convertible полученных путем преобразования
            *  коллекции строк (поле list) ч/з вызов метода create класса ConvertibleFactory
            *  в рамках stream API;
            *  -------------   create()   -------------
            *  Переменной separated типа String[] присваиваем значение массива строк
            *  полученного путем разделения входящей строки s по пробелу методом split класса String.
            *  Определяется(в тернарном операторе) ТИП РЕАЛИЗАЦИИ для абстр.класса Convertible по второму
            *  элементу массива separated ч/з вызов методов isSpeedUnit и isTimeUnit
            *  соответствующих классов-перечислений(enum). Реализация возвращается из метода оператором return;
            *  -------------   isSpeedUnit()   -------------
            *  Осуществляется проверка соответствия получаемой строки полю symbol
            *  какого-либо экземпляра перечисления(kmh,mph...)через вызов метода getUnit()
            *  -------------   getUnit()   -------------
            *  Поле symbol экземпляров перечисления(kmh,mph...) полученных в виде массива
            *  через вызов стандартного метода values() класса-ENUM проверяется на соответствие
            *  строке(String symbol), переданной в метод.В случае соответствия возвращается ЭКЗЕМПЛЯР ПЕРЕЧИСЛЕНИЯ,
            *  иначе - NULL.
            *  DataManager создает сущности Time & Speed.
            *
            */
            List<Speed> speeds = new DataManager(read).getSpeeds();
            List<Double> ms = Converter.speedsToMS(speeds);
            for (int i = 0; i < speeds.size(); i++) {
                System.out.println(speeds.get(i) + " = " + format(ms.get(i)) + " ms");
            }
            DataManager dataManager = new DataManager(read);
            Distance[] distances = new Calculator().distancesInM(dataManager.getTime(), speeds);

            Arrays.stream(distances).forEach(distance -> System.out.println(distance.getValue()));

            System.out.println(Arrays.stream(distances)
                    .anyMatch(distance -> distance.getDoubleValue() >= 500
                            && distance.getDoubleValue() <= 501) ? "yes" : "no");

            dataManager.getSortedSpeeds(speeds).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
