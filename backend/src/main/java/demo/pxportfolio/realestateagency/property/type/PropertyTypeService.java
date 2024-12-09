package demo.pxportfolio.realestateagency.property.type;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyTypeService {

    private final PropertyTypeRepository propertyTypeRepository;
    private static final String ENTITY_CLASS = PropertyType.class.getSimpleName();

    @Cacheable(value = "property-types")
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeRepository.findAll();
    }

    public PropertyType getPropertyTypeById(Long id) {
        return propertyTypeRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }
}