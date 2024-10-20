package demo.pxportfolio.realestateagency.geodata.location;

import demo.pxportfolio.realestateagency.geodata.city.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public Location createLocation(LocationDto dto) {
        Location location = Location.builder()
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .city(City.builder().id(dto.getCityId()).build())
                .street(dto.getStreet())
                .number(dto.getNumber())
                .build();
        return locationRepository.save(location);
    }
}
