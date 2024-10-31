package demo.pxportfolio.realestateagency.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NotificationDto {

    private Long id;
    private Subject subject;
    private String body;
    private LocalDateTime createdAt;
}
