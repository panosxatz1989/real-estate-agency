package demo.pxportfolio.realestateagency.property;

import demo.pxportfolio.realestateagency.geodata.location.LocationDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PropertyRequestDto {

    @NotBlank(message = "{app.messages.validation.property.title.not-blank}")
    @Size(max = 500, message = "{app.messages.validation.property.title.size}")
    private String title;

    @Size(max = 4000, message = "{app.messages.validation.property.description.size}")
    private String description;

    @NotNull(message = "")
    private ListingType listingType;

    @NotNull(message = "{app.messages.validation.property.price.not-null}")
    private BigDecimal originalPrice;

    private BigDecimal price = originalPrice;

    private Boolean isNegotiable = false;

    private Double area;

    private Integer rooms;

    private Integer yearOfConstruction;

    @NotNull(message = "{app.messages.validation.property.type.not-null}")
    private Long propertyTypeId;

    @NotNull(message = "{app.messages.validation.property.author.not-null}")
    private Long authorId;

    @NotNull(message = "{app.messages.validation.property.agent.not-null}")
    private Long agentId;

    private List<Long> attachmentIds;

    private LocationDto location;

    private Status status = Status.ACTIVE;
}
