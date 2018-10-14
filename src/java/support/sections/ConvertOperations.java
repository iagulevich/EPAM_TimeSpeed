package support.sections;

import domain.Convertible;
import domain.Speed;
import services.Converter;
import services.interfaces.Service;
import support.interfaces.ConversionFunction;

public enum ConvertOperations {

    SPEED_TO_KMH(),
    SPEED_TO_MPH(),
    SPEED_TO_KN(),
    SPEED_TO_MS(Converter::speedsToMS),
    DEFAULT();

    private ConversionFunction<? extends Convertible> function;
    private Service service;

    ConvertOperations() {
    }

    ConvertOperations(ConversionFunction<Speed> function) {
        this.function = function;
    }

    public ConversionFunction<? extends Convertible> getFunction() {
        return function;
    }
}
