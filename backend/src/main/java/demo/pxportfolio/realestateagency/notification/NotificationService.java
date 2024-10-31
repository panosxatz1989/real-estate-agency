package demo.pxportfolio.realestateagency.notification;

import demo.pxportfolio.realestateagency.auth.user.UserService;
import demo.pxportfolio.realestateagency.notification.recipient.NotificationRecipient;
import demo.pxportfolio.realestateagency.notification.recipient.NotificationRecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationRecipientRepository notificationRecipientRepository;
    private final UserService userService;

    public Notification createNotification(NotificationCreationDto dto) {
        Notification notification = notificationRepository.save(
                Notification.builder()
                        .subject(dto.getNotificationSubject())
                        .body(dto.getNotificationBody())
                        .build()
        );

        for (Long userId : dto.getUserIds()) {
            NotificationRecipient recipient = notificationRecipientRepository.save(
                    NotificationRecipient.builder()
                            .notification(notification)
                            .recipient(userService.getUserById(userId))
                            .build()
            );
        }

        return notification;
    }
}
