package demo.pxportfolio.realestateagency.property;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    ACTIVE("Ενεργή"),
    PENDING("Σε κράτηση"),
    SOLD("Πωλήθηκε"),
    DELETED("Διαγράφηκε");

    private final String label;
}