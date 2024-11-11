package demo.pxportfolio.realestateagency.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginRequestDto {

    @NotBlank(message = "{validation.user.username.not-blank}")
    private String username;

    @NotBlank(message = "{validation.user.password.not-blank}")
    private String password;
}
