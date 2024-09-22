package demo.pxportfolio.realestateagency.property.attribute;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttributeService {

    private final AttributeRepository attributeRepository;
    private static final String ENTITY_CLASS = Attribute.class.getSimpleName();

    public Attribute getAttributeById(Long id) {
        return attributeRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }
}
