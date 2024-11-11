package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyIntermediateService {

    private final PropertyRepository propertyRepository;
    private static final String ENTITY_CLASS = Property.class.getSimpleName();

    public Property getPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, propertyId.toString()));
    }
}
