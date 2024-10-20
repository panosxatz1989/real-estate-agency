package demo.pxportfolio.realestateagency.property.inquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InquiryRequestDto {

    private Long userId;
    private Long propertyId;
    private String message;
}
