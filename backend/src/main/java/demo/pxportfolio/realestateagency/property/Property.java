package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.geodata.location.Location;
import demo.pxportfolio.realestateagency.misc.agents.Agent;
import demo.pxportfolio.realestateagency.misc.attachment.Attachment;
import demo.pxportfolio.realestateagency.property.attribute.property.PropertyAttribute;
import demo.pxportfolio.realestateagency.property.inquiry.Inquiry;
import demo.pxportfolio.realestateagency.property.type.PropertyType;
import demo.pxportfolio.realestateagency.property.view.PropertyView;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "properties")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 500, nullable = false)
    private String title;

    @Column(name = "description", length = 4000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_type")
    private ListingType listingType;

    @Column(name = "original_price", precision = 10, scale = 2)
    private BigDecimal originalPrice;

    @Column(name = "current_price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "is_negotiable", nullable = false)
    private Boolean isNegotiable;

    @Column(name = "area", nullable = false, precision = 6, scale = 2)
    private BigDecimal area;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "location_id",
            foreignKey = @ForeignKey(
                    name = "properties_to_locations_fk"
            )
    )
    private Location location;

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

    @ManyToOne
    @JoinColumn(
            name = "agent_id",
            foreignKey = @ForeignKey(
                    name = "properties_to_agents_fk"
            )
    )
    private Agent agent;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "properties_attachments",
            joinColumns = @JoinColumn(
                    name = "property_id",
                    foreignKey = @ForeignKey(
                            name = "properties_attachments_to_properties_fk"
                    )

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "attachment_id",
                    foreignKey = @ForeignKey(
                            name = "properties_attachments_to_attachments_fk"
                    )

            )
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Attachment> photos;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<PropertyView> views;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Inquiry> inquiries;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<PropertyAttribute> attributes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(id, property.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}