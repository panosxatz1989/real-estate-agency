package demo.pxportfolio.realestateagency.auth.role;

import demo.pxportfolio.realestateagency.auth.permission.Permission;
import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.misc.base.ListEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@Builder
public class Role implements Serializable, ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "machine_name", length = 50, nullable = false)
    private String machineName;

    @ManyToMany(fetch = FetchType.EAGER)
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
    @ToString.Exclude
    private Set<Permission> permissions;

    @OneToMany(mappedBy = "role")
    @ToString.Exclude
    private Set<User> users;

    @Override
    public Long getKey() {
        return this.id;
    }

    @Override
    public String getValue() {
        return this.title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}