package demo.pxportfolio.realestateagency.auth.permission;

import demo.pxportfolio.realestateagency.auth.role.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(
        name = "permissions",
        uniqueConstraints = @UniqueConstraint(
                name = "permission_uq",
                columnNames = {
                        "group",
                        "sub_group",
                        "title"
                }
        )
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Permission implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`group`", length = 100, nullable = false)
    private String group;

    @Column(name = "sub_group", length = 100, nullable = false)
    private String subGroup;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Override
    public String getAuthority() {
        return String.join("_", this.group, this.subGroup, this.title).toLowerCase();
    }

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Permission permission = (Permission) o;
        return id != null && Objects.equals(id, permission.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}