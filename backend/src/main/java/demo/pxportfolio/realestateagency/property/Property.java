package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.property.type.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "properties")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 500, nullable = false)
    private String title;

    @Column(name = "description", length = 4000)
    private String description;

    @Column(name = "original_price", precision = 10, scale = 2)
    private BigDecimal originalPrice;

    @Column(name = "current_price", precision = 10, scale = 2)
    private BigDecimal price;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(
            name = "property_type_id",
            foreignKey = @ForeignKey(
                    name = "properties_to_property_types_fk"
            )
    )
    private PropertyType propertyType;

    @ManyToOne
    @JoinColumn(
            name = "author",
            foreignKey = @ForeignKey(
                    name = "properties_to_users_fk"
            )
    )
    private User author;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private Status status;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Property property = (Property) o;
        return id != null && Objects.equals(id, property.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
