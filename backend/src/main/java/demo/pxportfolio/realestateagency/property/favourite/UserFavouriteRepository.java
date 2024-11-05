package demo.pxportfolio.realestateagency.property.favourite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavouriteRepository extends JpaRepository<UserFavourite, Long> {
}
