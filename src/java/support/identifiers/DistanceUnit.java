package support.identifiers;

import domain.Convertible;

import java.util.function.Function;

public enum DistanceUnit {
    KM("km"),
    ML("ml"),
    KT("kt"),
    M("m");

    private String unit;

    DistanceUnit(String unit) {
        this.unit = unit;
    }

    public static boolean isDistance(String string) {
        return true;
    }

}
