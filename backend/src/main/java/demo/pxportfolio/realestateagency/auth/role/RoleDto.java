package demo.pxportfolio.realestateagency.auth.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    private Long id;
    private String title;
    private String machineName;
}
