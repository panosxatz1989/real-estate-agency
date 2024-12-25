package demo.pxportfolio.realestateagency.property.favourite;

import demo.pxportfolio.realestateagency.auth.user.UserDto;
import demo.pxportfolio.realestateagency.property.PropertyResponseDto;
import java.util.List;
import lombok.Data;

@Data
public class UserFavouriteDto {

    private UserDto userDto;
    private List<PropertyResponseDto> properties;
}
