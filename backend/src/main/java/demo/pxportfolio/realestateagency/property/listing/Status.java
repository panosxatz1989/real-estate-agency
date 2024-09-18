package demo.pxportfolio.realestateagency.property.listing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    ACTIVE("Ενεργή"),
    PENDING("Σε κράτηση"),
    SOLD("Πωλήθηκε");

    private final String label;
}
