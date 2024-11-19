package demo.pxportfolio.realestateagency.property.attribute;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
import org.hibernate.annotations.Comment;

@Entity
@Table(
        name = "attributes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "attribute_title_uq",
                        columnNames = "title"
                ),
                @UniqueConstraint(
                        name = "attribute_machine_name_uq",
                        columnNames = "machine_name"
                )
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Attribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "machine_name", length = 50, nullable = false)
    @Comment("A machine name for easy access by name.")
    private String machineName;

    @Column(name = "metric_unit", length = 50)
    @Comment("The metric unit square meters etc.")
    private String metricUnit;

    @Column(name = "has_restricted_values", nullable = false)
    @Comment("True if the attribute must have a value of a specific range or set of values.")
    private Boolean hasRestrictedValues;

    @Column(name = "icon_class")
    @Comment("The font awesome or other library\\'s icon")
    private String iconClass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(id, attribute.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}