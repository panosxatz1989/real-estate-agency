package demo.pxportfolio.realestateagency.property.type;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/property-types")
@RequiredArgsConstructor
public class PropertyTypeController {

    private final PropertyTypeService propertyTypeService;

    @GetMapping
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeService.getAllPropertyTypes();
    }

    @GetMapping("/list")
    public List<KeyValueDto> getAllPropertyTypesList() {
        return propertyTypeService.getAllPropertyTypesList();
    }

    @GetMapping("/{id}")
    public PropertyType getPropertyTypeById(@PathVariable Long id) {
        return propertyTypeService.getPropertyTypeById(id);
    }
}