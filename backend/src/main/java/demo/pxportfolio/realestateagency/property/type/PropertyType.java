package demo.pxportfolio.realestateagency.property.type;

import demo.pxportfolio.realestateagency.misc.base.ListEntity;
import demo.pxportfolio.realestateagency.property.attribute.Attribute;
import jakarta.persistence.*;
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
        name = "property_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "property_type_uq",
                        columnNames = "type"
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyType implements Serializable, ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", length = 200, nullable = false)
    private String type;

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
    public Long getKey() {
        return this.id;
    }

    @Override
    public String getValue() {
        return this.type;
    }

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
