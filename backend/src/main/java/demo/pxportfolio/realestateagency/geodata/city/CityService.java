package demo.pxportfolio.realestateagency.geodata.city;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final ModelMapper modelMapper;
    private final CityRepository cityRepository;

    public List<CityDto> searchCity(String title) {
        return cityRepository.findAllByTitleIncludes(title.toUpperCase())
                .stream()
                .map(c -> modelMapper.map(c, CityDto.class))
                .toList();
    }

    @Cacheable(value = "cities")
    public List<KeyValueDto> getAllCitiesList() {
        return cityRepository.findAll()
                .stream()
                .map(KeyValueDto::new)
                .toList();
    }
}