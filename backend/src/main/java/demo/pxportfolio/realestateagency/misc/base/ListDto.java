package demo.pxportfolio.realestateagency.misc.base;

import lombok.Data;

@Data
public class ListDto {

    private String key;
    private String value;

    public ListDto(ListEntity entity) {
        this.key = entity.getKey().toString();
        this.value = entity.getValue();
    }
}
