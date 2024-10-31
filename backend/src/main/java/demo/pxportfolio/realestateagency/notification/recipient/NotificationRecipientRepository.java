package demo.pxportfolio.realestateagency.notification.recipient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRecipientRepository extends JpaRepository<NotificationRecipient, Long> {
}
