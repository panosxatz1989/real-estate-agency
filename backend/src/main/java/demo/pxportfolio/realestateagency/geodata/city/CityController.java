package demo.pxportfolio.realestateagency.geodata.city;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> searchCity(@RequestParam String title) {
        return cityService.searchCity(title);
    }

    @GetMapping("/list")
    public List<ListDto> getAllCitiesList() {
        return cityService.getAllCitiesList();
    }
}
