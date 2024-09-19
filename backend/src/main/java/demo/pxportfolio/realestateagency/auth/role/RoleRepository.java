package demo.pxportfolio.realestateagency.auth.role;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Set<Role> findByIdIn(Set<Long> roleIds);
}
