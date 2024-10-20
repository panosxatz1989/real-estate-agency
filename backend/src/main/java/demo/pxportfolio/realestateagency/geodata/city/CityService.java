package demo.pxportfolio.realestateagency.geodata.city;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> searchCity(String title) {
        return cityRepository.findAllByTitleIncludes(title.toUpperCase());
    }

    public List<ListDto> getAllCitiesList() {
        return cityRepository.findAll()
                .stream()
                .map(ListDto::new)
                .collect(Collectors.toList());
    }
}