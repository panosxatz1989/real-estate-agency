package demo.pxportfolio.realestateagency.auth.role;

import demo.pxportfolio.realestateagency.auth.permission.Permission;
import demo.pxportfolio.realestateagency.auth.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "role_title_uq",
                        columnNames = {
                                "title"
                        }
                ),
                @UniqueConstraint(
                        name = "role_machine_name_uq",
                        columnNames = {
                                "machine_name"
                        }
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "machine_name", length = 50, nullable = false)
    private String machineName;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(
                    name = "role_id",
                    foreignKey = @ForeignKey(
                            name = "roles_permissions_to_roles_fk"
                    )

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id",
                    foreignKey = @ForeignKey(
                            name = "roles_permissions_to_permissions_fk"
                    )

            )
    )
    private Set<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}