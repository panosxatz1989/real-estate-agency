package demo.pxportfolio.realestateagency.property.heating;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/heating-methods")
@RequiredArgsConstructor
public class HeatingMethodController {

    private final HeatingMethodService heatingMethodService;

    @GetMapping("/list")
    public List<KeyValueDto> getAllHeatingMethodsList() {
        return heatingMethodService.getAllHeatingMethodsList();
    }
}
