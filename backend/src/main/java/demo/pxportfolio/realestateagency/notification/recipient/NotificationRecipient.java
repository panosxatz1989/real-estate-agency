package demo.pxportfolio.realestateagency.notification.recipient;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.notification.Notification;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "notification_recipients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NotificationRecipient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "receiver",
            foreignKey = @ForeignKey(
                    name = "notification_recipients_to_notifications_fk"
            )
    )
    private Notification notification;

    @ManyToOne
    @JoinColumn(
            name = "recipient_id",
            foreignKey = @ForeignKey(
                    name = "notification_recipients_to_users_fk"
            )
    )
    private User recipient;

    @Column(name = "read_date")
    private LocalDateTime readDate;

    @Column(name = "email_send_date")
    private LocalDateTime emailSendDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationRecipient that = (NotificationRecipient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}