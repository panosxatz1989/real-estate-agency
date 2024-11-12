package demo.pxportfolio.realestateagency.property.favourite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserFavouriteCreationDto {

    private Long propertyId;
    private Boolean shouldNotify;
}
