package demo.pxportfolio.realestateagency.auth.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    String USERNAME_OR_EMAIL_QUERY =
            " SELECT u " +
            " FROM User u " +
            " WHERE u.username LIKE :credential " +
            " OR u.email LIKE :credential ";

    @Query(value = USERNAME_OR_EMAIL_QUERY)
    Optional<User> findByUsernameOrEmail(String credential);
}
