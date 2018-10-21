package support.interfaces;

import domain.Convertible;
import java.util.List;

@FunctionalInterface
public interface ConversionFunction<T extends Convertible> {
    List<Double> convert(List<T> speeds);
}
