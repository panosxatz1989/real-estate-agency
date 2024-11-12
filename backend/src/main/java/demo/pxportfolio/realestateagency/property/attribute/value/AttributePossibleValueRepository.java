package demo.pxportfolio.realestateagency.property.attribute.value;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributePossibleValueRepository extends JpaRepository<AttributePossibleValue, Long> {
}
