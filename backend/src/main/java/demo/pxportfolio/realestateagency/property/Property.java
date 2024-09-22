package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.misc.agents.Agent;
import demo.pxportfolio.realestateagency.misc.attachment.Attachment;
import demo.pxportfolio.realestateagency.property.data.PropertyAttribute;
import demo.pxportfolio.realestateagency.property.type.PropertyType;
import demo.pxportfolio.realestateagency.property.view.PropertyView;
import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
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

    @Column(name = "is_negotiable", nullable = false)
    private Boolean isNegotiable;

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
    private Set<Attachment> photos;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private Set<PropertyView> views;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private Set<PropertyAttribute> attributes;

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

    public void setNegotiable(Boolean negotiable) {
        isNegotiable = negotiable;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void setPhotos(Set<Attachment> photos) {
        this.photos = photos;
    }

    public void setViews(Set<PropertyView> views) {
        this.views = views;
    }

    public void setAttributes(Set<PropertyAttribute> attributes) {
        this.attributes = attributes;
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
