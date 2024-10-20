package demo.pxportfolio.realestateagency.property;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropertyFilterDto {

    private String title;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private LocalDateTime createdAtFrom;
    private LocalDateTime createdAtTo;
    private List<Long> propertyTypes;
    private String status;
}
