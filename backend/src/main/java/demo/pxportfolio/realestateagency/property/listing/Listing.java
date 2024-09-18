package demo.pxportfolio.realestateagency.property.listing;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.property.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "listings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Listing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 500, nullable = false)
    private String title;

    @Column(name = "description", length = 4000)
    private String description;

    @OneToOne
    @JoinColumn(
            name = "property_id",
            foreignKey = @ForeignKey(
                    name = "listings_to_properties_fk"
            )
    )
    private Property property;

    @Column(name = "original_price", columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal originalPrice;

    @Column(name = "current_price", columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal price;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(
            name = "author",
            foreignKey = @ForeignKey(
                    name = "listings_to_users_fk"
            )
    )
    private User author;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private Status status;
}
