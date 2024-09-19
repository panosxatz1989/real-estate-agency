package demo.pxportfolio.realestateagency.auth.user;

import demo.pxportfolio.realestateagency.auth.role.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private Boolean active;
    private Set<RoleDto> roles;
}
