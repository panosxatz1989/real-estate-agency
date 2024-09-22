package demo.pxportfolio.realestateagency.property.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PropertyAttributeDto {

    private Long attributeId;
    private String value;
}
