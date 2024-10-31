package demo.pxportfolio.realestateagency.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Subject {

    SOLD("Πώληση Ιδιοκτησίας"),
    DELETED("Διαγραφή Ιδιοκτησίας"),
    PRICE_DROP("Πτώση Τιμής");

    private final String label;
}
