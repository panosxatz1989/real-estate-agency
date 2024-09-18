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

    @NotBlank(message = "Username must not be empty.")
    private String username;

    @NotBlank(message = "Password must not be empty.")
    private String password;
}
