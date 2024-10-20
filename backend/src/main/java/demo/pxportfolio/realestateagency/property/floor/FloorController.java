package demo.pxportfolio.realestateagency.property.floor;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/floors")
@RequiredArgsConstructor
public class FloorController {

    private final FloorService floorService;

    @GetMapping("/list")
    public List<ListDto> getAllFloorsList() {
        return floorService.getAllFloorsList();
    }
}
