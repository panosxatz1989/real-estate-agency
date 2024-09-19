package demo.pxportfolio.realestateagency.misc.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Subject {

    SOLD("Πώληση Ιδιοκτησίας"),
    PRICE_DROP("Πτώση Τιμής");

    private final String label;
}
