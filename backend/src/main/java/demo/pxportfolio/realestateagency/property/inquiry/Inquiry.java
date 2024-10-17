package demo.pxportfolio.realestateagency.property.inquiry;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.property.Property;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "inquiries")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Inquiry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(
                    name = "inquiries_to_users_fk"
            )
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "property_id",
            foreignKey = @ForeignKey(
                    name = "inquiries_to_properties_fk"
            )
    )
    private Property property;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "message", length = 1000)
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquiry inquiry = (Inquiry) o;
        return Objects.equals(id, inquiry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
