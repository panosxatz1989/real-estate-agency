package demo.pxportfolio.realestateagency.property.view;

import demo.pxportfolio.realestateagency.auth.user.UserService;
import demo.pxportfolio.realestateagency.property.PropertyIntermediateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyViewService {

    private final UserService userService;
    private final PropertyIntermediateService propertyIntermediateService;
    private final PropertyViewRepository propertyViewRepository;

    public PropertyView createPropertyView(PropertyViewCreationDto dto) {
        return propertyViewRepository.save(PropertyView.builder()
                .user(userService.getUserById(dto.getUserId()))
                .property(propertyIntermediateService.getPropertyById(dto.getPropertyId()))
                .build());
    }

    public Integer countPropertyViews(Long propertyId) {
        return propertyViewRepository.countByPropertyId(propertyId);
    }

}
