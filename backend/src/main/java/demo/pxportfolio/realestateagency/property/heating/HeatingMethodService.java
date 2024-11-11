package demo.pxportfolio.realestateagency.property.heating;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeatingMethodService {

    private final HeatingMethodRepository heatingMethodRepository;

    public List<KeyValueDto> getAllHeatingMethodsList() {
        return heatingMethodRepository.findAll()
                .stream()
                .map(KeyValueDto::new)
                .toList();
    }
}
