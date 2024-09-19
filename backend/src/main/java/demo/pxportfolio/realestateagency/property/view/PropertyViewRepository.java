package demo.pxportfolio.realestateagency.property.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyViewRepository extends JpaRepository<PropertyView, Long> {

    Page<PropertyView> findAllByUserId(Long userId, Pageable pageable);

    Long countByUserId(Long userId);

    Long countByPropertyId(Long propertyId);
}
