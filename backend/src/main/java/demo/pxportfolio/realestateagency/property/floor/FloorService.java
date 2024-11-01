package demo.pxportfolio.realestateagency.property.floor;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepository floorRepository;

    public List<ListDto> getAllFloorsList() {
        return floorRepository.findAll()
                .stream()
                .map(ListDto::new)
                .toList();
    }
}
