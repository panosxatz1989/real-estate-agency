package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserService;
import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.geodata.location.LocationService;
import demo.pxportfolio.realestateagency.misc.agents.AgentService;
import demo.pxportfolio.realestateagency.misc.attachment.AttachmentService;
import demo.pxportfolio.realestateagency.property.type.PropertyTypeService;
import demo.pxportfolio.realestateagency.property.view.PropertyViewCreationDto;
import demo.pxportfolio.realestateagency.property.view.PropertyViewService;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final AgentService agentService;
    private final UserService userService;
    private final PropertyTypeService propertyTypeService;
    private final PropertyViewService propertyViewService;
    private final AttachmentService attachmentService;
    private final LocationService locationService;
    private final PropertySpecification propertySpecification;
    private static final String ENTITY_CLASS = Property.class.getSimpleName();

    public Page<Property> getAllProperties(PropertyFilterDto filter, Pageable pageable) {
        return propertyRepository.findAll(propertySpecification.getProperties(filter), pageable);
    }

    public Property getPropertyById(User user, Long id) {
        Property property = this.getPropertyById(id);

        if (user.getRole().getMachineName().equals("user")) {
            propertyViewService.createPropertyView(
                    PropertyViewCreationDto.builder()
                            .userId(user.getId())
                            .propertyId(id)
                            .build()
            );
        }

        return property;
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }


    public Property createProperty(PropertyRequestDto dto) {

        return Property.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .isNegotiable(dto.getIsNegotiable())
                .originalPrice(dto.getOriginalPrice())
                .price(dto.getPrice())
                .author(userService.getUserById(dto.getAuthorId()))
                .propertyType(propertyTypeService.getPropertyTypeById(dto.getPropertyTypeId()))
                .agent(agentService.getAgentById(dto.getAgentId()))
                .location(locationService.createLocation(dto.getLocation()))
                .photos(
                        dto.getAttachmentIds()
                                .stream()
                                .map(attachmentService::getAttachmentById)
                                .collect(Collectors.toSet())
                )
                .status(dto.getStatus())
                .build();
    }

    public void deletePropertyById(Long id, User user) {
        Property existingProperty = this.getPropertyById(id);

        // Only the author and admin can delete a property
        if (user.getId().equals(existingProperty.getAuthor().getId()) || userService.isAdmin(user)) {
            existingProperty.setStatus(Status.DELETED);
            propertyRepository.save(existingProperty);
        }
    }
}