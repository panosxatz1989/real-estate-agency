package demo.pxportfolio.realestateagency.geodata.city;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> searchCity(String title) {
        return cityRepository.findAllByTitleIncludes(title.toUpperCase());
    }

    public List<KeyValueDto> getAllCitiesList() {
        return cityRepository.findAll()
                .stream()
                .map(KeyValueDto::new)
                .toList();
    }
}