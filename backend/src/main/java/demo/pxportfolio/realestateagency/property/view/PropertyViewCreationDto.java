package demo.pxportfolio.realestateagency.property.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PropertyViewCreationDto {

    private Long userId;
    private Long propertyId;

}
