package demo.pxportfolio.realestateagency.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Username must not be empty.")
    @Size(max = 100, message = "Username must not exceed 100 characters.")
    private String username;

    @NotBlank(message = "Password must not be empty.")
    @Size(max = 100, message = "Password must not exceed 100 characters.")
    private String password;

    @Email(message = "Email must be valid.")
    private String email;

    private Set<Long> roleIds;
}
