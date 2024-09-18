package demo.pxportfolio.realestateagency.property.type;

import demo.pxportfolio.realestateagency.property.attribute.Attribute;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
import java.util.Set;

@Entity
@Table(name = "property_types")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PropertyType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "property_types_possible_attributes",
            joinColumns = @JoinColumn(
                    name = "property_type_id",
                    foreignKey = @ForeignKey(
                            name = "property_types_possible_attributes_to_property_types_fk"
                    )

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "attribute_id",
                    foreignKey = @ForeignKey(
                            name = "property_types_possible_attributes_to_attributes_fk"
                    )

            )
    )
    @ToString.Exclude
    private Set<Attribute> possibleAttributes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PropertyType that = (PropertyType) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
