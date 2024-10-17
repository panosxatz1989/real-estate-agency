package demo.pxportfolio.realestateagency.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterRequestDto {

    @NotBlank(message = "{app.messages.validation.user.username.not-blank}")
    @Size(min = 8, max = 100, message = "{app.messages.validation.user.username.size}")
    private String username;

    @NotBlank(message = "{app.messages.validation.user.password.not-blank}")
    @Size(min = 8, max = 100, message = "{app.messages.validation.user.password.size}")
    private String password;

    @Email(message = "{app.messages.validation.user.email.invalid}")
    private String email;

    @Size(min = 10, max = 10, message = "{app.messages.validation.user.phone}")
    private String phone;

    private Set<Long> roleIds;
}
