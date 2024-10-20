package demo.pxportfolio.realestateagency.geodata.region;

import demo.pxportfolio.realestateagency.misc.base.ListEntity;
import demo.pxportfolio.realestateagency.geodata.city.City;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
        name = "regions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "region_title_uq",
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
public class Region implements Serializable, ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "region")
    private Set<City> cities;

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
        Region region = (Region) o;
        return id.equals(region.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}