package demo.pxportfolio.realestateagency.property.attribute;

import demo.pxportfolio.realestateagency.property.type.PropertyType;
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
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "attributes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "attribute_title_uq",
                        columnNames = "title"
                )
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Attribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "measurement_unit", length = 50, nullable = false)
    private String unit;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToMany(mappedBy = "possibleAttributes")
    @ToString.Exclude
    private Set<PropertyType> propertyTypes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attribute attribute = (Attribute) o;
        return id != null && Objects.equals(id, attribute.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
