package demo.pxportfolio.realestateagency.property.floor;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepository floorRepository;

    public List<KeyValueDto> getAllFloorsList() {
        return floorRepository.findAll()
                .stream()
                .map(KeyValueDto::new)
                .toList();
    }
}
