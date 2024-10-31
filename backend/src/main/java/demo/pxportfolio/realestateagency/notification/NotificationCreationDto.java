package demo.pxportfolio.realestateagency.notification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NotificationCreationDto {

    @NotNull(message = "{app.messages.validation.notification.subject.not-null}")
    private Subject notificationSubject;

    @NotBlank(message = "{app.messages.validation.notification.body.not-blank}")
    private String notificationBody;

    @NotNull(message = "{app.messages.validation.notification.users.not-null}")
    private List<Long> userIds;

    private Boolean sendEmail;
}