package demo.pxportfolio.realestateagency.property.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyViewService {

    private final PropertyViewRepository propertyViewRepository;

    public Integer countPropertyViews(Long propertyId) {
        return propertyViewRepository.countByPropertyId(propertyId);
    }

}
