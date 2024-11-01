package demo.pxportfolio.realestateagency.auth.permission;

import demo.pxportfolio.realestateagency.auth.role.Role;
import demo.pxportfolio.realestateagency.misc.base.ListEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
public class Permission implements Serializable, GrantedAuthority, ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource", length = 100, nullable = false)
    private String resource;

    @Column(name = "action", length = 100, nullable = false)
    private String action;

    @Column(name = "role", length = 50, nullable = false)
    private String role;

    @Override
    public String getAuthority() {
        return String.join(":", this.role, this.resource, this.action).toLowerCase();
    }

    @ManyToMany(mappedBy = "permissions")
    @ToString.Exclude
    private Set<Role> roles;

    @Override
    public Long getKey() {
        return this.id;
    }

    @Override
    public String getValue() {
        return this.getAuthority();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}