package demo.pxportfolio.realestateagency.property.type;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('listing_type_view')")
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeService.getAllPropertyTypes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('listing_type_view')")
    public PropertyType getPropertyTypeById(@PathVariable Long id) {
        return propertyTypeService.getPropertyTypeById(id);
    }

    @GetMapping("/list")
    public List<ListDto> getAllPropertyTypesList() {
        return propertyTypeService.getAllPropertyTypesList();
    }
}