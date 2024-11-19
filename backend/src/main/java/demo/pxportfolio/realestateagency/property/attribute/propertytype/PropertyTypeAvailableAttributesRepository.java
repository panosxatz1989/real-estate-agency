package demo.pxportfolio.realestateagency.property.attribute.propertytype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeAvailableAttributesRepository extends JpaRepository<PropertyTypeAvailableAttribute, Long> {
}
