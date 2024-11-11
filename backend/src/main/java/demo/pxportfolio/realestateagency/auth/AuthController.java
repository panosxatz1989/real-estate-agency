package demo.pxportfolio.realestateagency.auth;

import demo.pxportfolio.realestateagency.auth.jwt.JwtResponseDto;
import demo.pxportfolio.realestateagency.auth.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public JwtResponseDto login(@Valid @RequestBody LoginRequestDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/register")
    public JwtResponseDto register(@Valid @RequestBody RegisterRequestDto dto) {
        return authService.register(dto);
    }

    @PostMapping("/reset-password")
    public Object initPasswordReset(User user) {
        return authService.initPasswordReset(user);
    }

    // TODO - Missing reset password init and finish
}