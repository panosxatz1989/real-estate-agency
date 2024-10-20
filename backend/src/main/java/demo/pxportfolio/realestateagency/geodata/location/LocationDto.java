package demo.pxportfolio.realestateagency.geodata.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocationDto {

    private Long id;
    private String latitude;
    private String longitude;
    private Long cityId;
    private String street;
    private String number;
}
