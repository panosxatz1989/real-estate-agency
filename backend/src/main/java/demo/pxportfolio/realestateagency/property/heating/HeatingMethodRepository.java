package demo.pxportfolio.realestateagency.property.heating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatingMethodRepository extends JpaRepository<HeatingMethod, Long> {
}
