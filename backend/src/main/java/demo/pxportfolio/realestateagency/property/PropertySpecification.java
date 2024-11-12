package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.property.type.PropertyType;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PropertySpecification {

    public Specification<Property> getProperties(PropertyFilterDto filter) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filter.getTitle())) {
                Predicate titlePredicate = cb.like(root.get("title"), "%" + filter.getTitle() + "%");
                predicates.add(titlePredicate);
            }

            if (Objects.nonNull(filter.getPriceFrom())) {
                Predicate priceFromPredicate = cb.greaterThanOrEqualTo(root.get("price"), filter.getPriceFrom());
                predicates.add(priceFromPredicate);
            }

            if (Objects.nonNull(filter.getPriceTo())) {
                Predicate priceFromPredicate = cb.greaterThanOrEqualTo(root.get("price"), filter.getPriceTo());
                predicates.add(priceFromPredicate);
            }

            if (!filter.getPropertyTypes().isEmpty()) {
                Join<Property, PropertyType> join = root.join("propertyTypes");
                Predicate statusPredicate = join.get("id").in(filter.getPropertyTypes());
                predicates.add(statusPredicate);
            }

            if (StringUtils.hasLength(filter.getStatus())) {
                Predicate statusPredicate = cb.like(root.get("status"), filter.getStatus());
                predicates.add(statusPredicate);
            }

            return cb.and(predicates.toArray(Predicate[]::new));
        };
    }
}