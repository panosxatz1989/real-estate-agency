package demo.pxportfolio.realestateagency.property.data;

import demo.pxportfolio.realestateagency.property.Property;
import demo.pxportfolio.realestateagency.property.attribute.Attribute;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "properties_attributes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "property_id",
            foreignKey = @ForeignKey(
                    name = "properties_attributes_to_properties_fk"
            )
    )
    private Property property;

    @ManyToOne
    @JoinColumn(
            name = "attribute_id",
            foreignKey = @ForeignKey(
                    name = "properties_attributes_to_attributes_fk"
            )
    )
    private Attribute attribute;

    @Column(name = "actual_value", length = 200, nullable = false)
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PropertyAttribute that = (PropertyAttribute) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
