package demo.pxportfolio.realestateagency.property.heating;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeatingMethodService {

    private final HeatingMethodRepository heatingMethodRepository;

    public List<ListDto> getAllHeatingMethodsList() {
        return heatingMethodRepository.findAll()
                .stream()
                .map(ListDto::new)
                .toList();
    }
}
