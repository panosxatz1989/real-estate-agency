package demo.pxportfolio.realestateagency.auth;

import demo.pxportfolio.realestateagency.auth.jwt.JwtResponseDto;
import demo.pxportfolio.realestateagency.auth.jwt.JwtService;
import demo.pxportfolio.realestateagency.auth.role.RoleService;
import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserRepository;
import demo.pxportfolio.realestateagency.auth.user.UserService;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public JwtResponseDto register(RegisterRequestDto request) {

        // Create the user
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleService.getRoleById(request.getRoleId()))
                .phone(request.getPhone())
                .active(true)
                .build();

        // Save it to the database
        userRepository.save(user);

        // Generate its token
        String token = jwtService.generateToken(user);

        // Return the response containing the token
        return JwtResponseDto.builder()
                .accessToken(token)
                .build();
    }

    public JwtResponseDto login(LoginRequestDto request) {

        // Authenticate the user using auto mechanism of Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // Find the user by its username
        User user = userService.getUserByUsername(request.getUsername());

        // Generate its token
        String token = jwtService.generateToken(user);

        // Return the response containing the token
        return JwtResponseDto.builder()
                .accessToken(token)
                .build();
    }

    // TODO - Fix correct exception
    public Object initPasswordReset(User user) {

        if (!user.getActive()) {
            throw new RuntimeException();
        }

        String token = UUID.randomUUID().toString();
        LocalDateTime expiration = LocalDateTime.now();

        user.setResetToken(token);
        user.setResetTokenExpiration(expiration);

        userRepository.save(user);

        // Then send an email with a template text with the unique password reset link


        // Return true/false or the user itself, if everything went ok
        return null;
    }
}
