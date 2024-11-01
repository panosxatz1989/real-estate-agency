package demo.pxportfolio.realestateagency.misc.agents;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.misc.attachment.Attachment;
import demo.pxportfolio.realestateagency.misc.base.ListEntity;
import demo.pxportfolio.realestateagency.property.Property;
import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "agents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Agent implements Serializable, ListEntity {

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

    @OneToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
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

    @OneToMany(mappedBy = "agent", fetch = FetchType.EAGER)
    private Set<Property> properties;

    @Override
    public Long getKey() {
        return this.id;
    }

    @Override
    public String getValue() {
        return this.lastname + " " + this.firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return Objects.equals(id, agent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}