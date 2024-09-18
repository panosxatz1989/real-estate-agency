package demo.pxportfolio.realestateagency.property.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyViewRepository extends JpaRepository<PropertyView, Long> {

    Long countByUserId(Long userId);

    Long countByPropertyId(Long propertyId);
}
