package demo.pxportfolio.realestateagency.geodata.city;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT c FROM City WHERE UPPER(c.title) LIKE CONCAT('%', UPPER(:title), '%')")
    List<City> findAllByTitleIncludes(String title);
}
