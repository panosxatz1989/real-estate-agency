package demo.pxportfolio.realestateagency.property;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ListingType {

    SELL("Πώληση"),
    RENT("Ενοικίαση");

    private final String label;
}
