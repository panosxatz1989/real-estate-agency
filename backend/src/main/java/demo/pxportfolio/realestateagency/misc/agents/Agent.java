package demo.pxportfolio.realestateagency.misc.agents;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.misc.attachment.Attachment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "agents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastname", length = 200, nullable = false)
    private String lastname;

    @Column(name = "firstname", length = 200, nullable = false)
    private String firstname;

    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    @Column(name = "cellular_phone", length = 10, nullable = false)
    private String cellularPhone;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(
                    name = "agents_to_users_fk"
            )
    )
    private User user;

    @OneToOne
    @JoinColumn(
            name = "profile_pic",
            foreignKey = @ForeignKey(
                    name = "agents_to_attachments_fk"
            )
    )
    private Attachment profilePic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Agent agent = (Agent) o;
        return id != null && Objects.equals(id, agent.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
