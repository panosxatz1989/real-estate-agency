package demo.pxportfolio.realestateagency.property.attribute.property;

import demo.pxportfolio.realestateagency.property.Property;
import demo.pxportfolio.realestateagency.property.attribute.Attribute;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
        name = "property_attributes",
        uniqueConstraints = @UniqueConstraint(
                name = "property_attributes_uq",
                columnNames = "property_id, attribute_id"
        )
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PropertyAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "property_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "property_attributes_to_properties_fk"
            )
    )
    private Property property;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "attribute_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "property_attributes_to_attributes_fk"
            )
    )
    private Attribute attribute;

    @Column(name = "value", length = 500, nullable = false)
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyAttribute that = (PropertyAttribute) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}