package demo.pxportfolio.realestateagency.auth.user;

import demo.pxportfolio.realestateagency.auth.role.Role;
import demo.pxportfolio.realestateagency.property.Property;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "user_name_uq",
                        columnNames = "username"
                ),
                @UniqueConstraint(
                        name = "user_email_uq",
                        columnNames = "email"
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "password", length = 500, nullable = false)
    private String password;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    @Column(name = "active")
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(
            name = "role_id",
            foreignKey = @ForeignKey(
                    name = "users_to_roles_fk"
            )
    )
    @ToString.Exclude
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "users_favourite_properties",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    foreignKey = @ForeignKey(
                            name = "users_favourite_properties_to_users_fk"
                    )

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "property_id",
                    foreignKey = @ForeignKey(
                            name = "users_favourite_properties_to_properties_fk"
                    )

            )
    )
    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Property> favourites;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissions();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}