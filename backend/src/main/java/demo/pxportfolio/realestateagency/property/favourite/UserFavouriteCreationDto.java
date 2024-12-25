package demo.pxportfolio.realestateagency.property.favourite;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserFavouriteCreationDto {

    @NotNull(message = "{validation.user.favourite.property.not-null}")
    private Long propertyId;

    private Boolean shouldNotify = false;
}