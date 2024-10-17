package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserRepository;
import demo.pxportfolio.realestateagency.auth.user.UserService;
import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.agents.Agent;
import demo.pxportfolio.realestateagency.misc.agents.AgentService;
import demo.pxportfolio.realestateagency.misc.attachment.Attachment;
import demo.pxportfolio.realestateagency.misc.attachment.AttachmentService;
import demo.pxportfolio.realestateagency.property.type.PropertyType;
import demo.pxportfolio.realestateagency.property.type.PropertyTypeService;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final ModelMapper modelMapper;
    private final PropertyRepository propertyRepository;
    private final AgentService agentService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final PropertyTypeService propertyTypeService;
    private final AttachmentService attachmentService;
    private final PropertySpecification propertySpecification;
    private static final String ENTITY_CLASS = Property.class.getSimpleName();

    public Page<Property> getAllProperties(PropertyFilterDto filter, Pageable pageable) {
        return propertyRepository.findAll(propertySpecification.getProperties(filter), pageable);
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }

    // TODO - Fix this shit
    public Property createProperty(PropertyRequestDto dto) {
        Property newProperty = Property.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .isNegotiable(dto.getIsNegotiable())
                .originalPrice(dto.getOriginalPrice())
                .price(dto.getPrice())
                .status(dto.getStatus())
                .build();

        Agent agent = modelMapper.map(agentService.getAgentById(dto.getAgentId()), Agent.class);
        newProperty.setAgent(agent);

        User author = modelMapper.map(userService.getUserDtoById(dto.getAuthorId()), User.class);
        newProperty.setAuthor(author);

        PropertyType propertyType = modelMapper.map(propertyTypeService.getPropertyTypeById(dto.getPropertyTypeId()), PropertyType.class);
        newProperty.setPropertyType(propertyType);

        Set<Attachment> attachments = dto.getAttachmentIds()
                .stream()
                .map(attachmentService::getAttachmentById)
                .collect(Collectors.toSet());
        newProperty.setPhotos(attachments);

        return propertyRepository.save(newProperty);
    }

    public void deletePropertyById(Long id) {
        Property existingProperty = this.getPropertyById(id);

        Set<User> usersThatAddedToFavourites = existingProperty.getFavourites();
        usersThatAddedToFavourites.stream()
                .forEach(
                        u -> {
                            u.getFavourites().remove(existingProperty);
                            userRepository.save(u);
                        }
                );


        existingProperty.setStatus(Status.DELETED);
        propertyRepository.save(existingProperty);


    }
}