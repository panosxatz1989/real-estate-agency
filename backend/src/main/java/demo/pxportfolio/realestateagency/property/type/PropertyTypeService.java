package demo.pxportfolio.realestateagency.property.type;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyTypeService {

    private final PropertyTypeRepository propertyTypeRepository;
    private static final String ENTITY_CLASS = PropertyType.class.getSimpleName();

    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeRepository.findAll();
    }

    public List<ListDto> getAllPropertyTypesList() {
        return propertyTypeRepository.findAll()
                .stream()
                .map(ListDto::new)
                .collect(Collectors.toList());
    }

    public PropertyType getPropertyTypeById(Long id) {
        return propertyTypeRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }
}
