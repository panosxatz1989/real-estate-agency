package demo.pxportfolio.realestateagency.property.attribute.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyAttributeRepository extends JpaRepository<PropertyAttribute, Long> {
}
