package demo.pxportfolio.realestateagency.auth.user;

import demo.pxportfolio.realestateagency.auth.role.Role;
import demo.pxportfolio.realestateagency.property.Property;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

    @Column(name = "active")
    private Boolean active = true;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    foreignKey = @ForeignKey(
                            name = "users_roles_to_users_fk"
                    )

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    foreignKey = @ForeignKey(
                            name = "users_roles_to_roles_fk"
                    )

            )
    )
    @ToString.Exclude
    private Set<Role> roles;

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
    private Set<Property> favourites;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roles.stream()
                .flatMap(role -> role.getPermissions().stream())
                .collect(Collectors.toSet());

//        Set<Permission> permissions = new HashSet<>();
//
//        for (Role role : roles) {
//            permissions.addAll(role.getPermissions());
//        }
//        return permissions;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}