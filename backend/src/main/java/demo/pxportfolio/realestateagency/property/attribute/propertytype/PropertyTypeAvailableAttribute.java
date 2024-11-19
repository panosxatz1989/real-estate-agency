package demo.pxportfolio.realestateagency.property.attribute.propertytype;

import demo.pxportfolio.realestateagency.property.attribute.Attribute;
import demo.pxportfolio.realestateagency.property.type.PropertyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
        name = "property_type_available_attributes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "property_type_attribute_uq",
                        columnNames = "property_id, attribute_id"
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyTypeAvailableAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "attribute_id",
            foreignKey = @ForeignKey(
                    name = "property_type_available_attributes_to_attributes_fk"
            )
    )
    private Attribute attribute;

    @ManyToOne
    @JoinColumn(
            name = "property_type_id",
            foreignKey = @ForeignKey(
                    name = "property_types_available_attributes_to_property_types_fk"
            )
    )
    private PropertyType propertyType;

    @Column(name = "show_in_preview", nullable = false)
    private Boolean showInPreview;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyTypeAvailableAttribute that = (PropertyTypeAvailableAttribute) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}