package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.property.inquiry.Inquiry;
import demo.pxportfolio.realestateagency.property.inquiry.InquiryRequestDto;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping
    @PreAuthorize("hasAuthority('listing_property_view')")
    public Page<Property> getAllProperties(PropertyFilterDto filter, Pageable pageable) {
        return propertyService.getAllProperties(filter, pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('listing_property_view')")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('listing_property_create')")
    public ResponseEntity<Property> createProperty(@Valid @RequestBody PropertyRequestDto dto) {
        Property property = propertyService.createProperty(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(property.getId())
                .toUri();
        return ResponseEntity.created(uri).body(property);
    }

    @PostMapping("/{propertyId}/inquiry")
    public Inquiry createInquiry(@Valid @RequestBody InquiryRequestDto dto) {
        return null;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('listing_property_update')")
    public Property updateProperty() {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('listing_property_delete')")
    public void deletePropertyById(@PathVariable Long id) {
        propertyService.deletePropertyById(id);
    }
}
