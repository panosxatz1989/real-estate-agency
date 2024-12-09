package demo.pxportfolio.realestateagency.geodata.city;

import demo.pxportfolio.realestateagency.geodata.region.RegionDto;
import lombok.Data;

@Data
public class CityDto {

    private Long id;
    private String title;
    private RegionDto region;
}
