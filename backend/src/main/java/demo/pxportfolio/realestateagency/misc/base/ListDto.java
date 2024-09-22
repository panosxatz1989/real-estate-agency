package demo.pxportfolio.realestateagency.misc.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ListDto {

    private String key;
    private String value;

    public ListDto(ListEntity entity) {
        this.key = entity.getKey().toString();
        this.value = entity.getValue();
    }
}
