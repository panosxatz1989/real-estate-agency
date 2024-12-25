package demo.pxportfolio.realestateagency.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterRequestDto {

    @NotBlank(message = "{validation.user.username.not-blank}")
    @Size(min = 8, max = 100, message = "{validation.user.username.size}")
    private String username;

    @NotBlank(message = "{validation.user.password.not-blank}")
    @Size(max = 100, message = "{validation.user.password.size}")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$!]).{8,}$", message = "{validation.user.password.invalid}")
    private String password;

    @Email(message = "{validation.user.email.invalid}")
    private String email;

    @NotBlank(message = "{validation.user.phone.not-blank}")
    @Size(min = 10, max = 10, message = "{validation.user.phone.size}")
    private String phone;
}