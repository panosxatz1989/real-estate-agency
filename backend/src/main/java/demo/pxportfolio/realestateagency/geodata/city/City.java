package demo.pxportfolio.realestateagency.geodata.city;

import demo.pxportfolio.realestateagency.misc.base.ListEntity;
import demo.pxportfolio.realestateagency.geodata.region.Region;
import jakarta.persistence.*;
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
        name = "cities",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "city_title_uq",
                        columnNames = "title"
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class City implements Serializable, ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(
            name = "region_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "cities_to_regions_fk"
            )
    )
    private Region region;

    @Override
    public Long getKey() {
        return this.id;
    }

    @Override
    public String getValue() {
        return this.title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}