package demo.pxportfolio.realestateagency.auth;

import demo.pxportfolio.realestateagency.auth.jwt.JwtResponseDto;
import demo.pxportfolio.realestateagency.auth.jwt.JwtService;
import demo.pxportfolio.realestateagency.auth.role.Role;
import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    // private final UserService userService;
    private final UserRepository userRepository;
    // private final RoleService roleService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    /**
     * Registers a new user.
     *
     * @param request
     * @return JwtResponseDto A response containing the JWT.
     */
    public JwtResponseDto register(RegisterRequestDto request) {

//        Set<Role> roles = request.getRoles()
//                .stream()
//                .map(roleService::getRoleById)
//                .collect(Collectors.toList());
//
//        // Create the user
//        User user = User.builder()
//                .username(request.getUsername())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .roles(roles)
//                .active(true)
//                .build();
//
//        // Save it to the database
//        userRepository.save(user);
//
//        // Generate its token
//        String token = jwtService.generateToken(user);
//
//        // Return the response containing the token
//        return JwtResponseDto.builder()
//                .accessToken(token)
//                .build();
        return null;
    }

    /**
     * Logins a user and generates the access token.
     *
     * @param request A request dto containing username and password.
     * @return JwtResponseDto A response containing the JWT.
     */
    public JwtResponseDto login(LoginRequestDto request) {

//        // Authenticate the user using auto mechanism of Spring Security
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getUsername(),
//                        request.getPassword()
//                )
//        );
//
//        // Find the user by its username
//        User user = userService.getUserByUsername(request.getUsername());
//
//        // Generate its token
//        String token = jwtService.generateToken(user);
//
//        // Return the response containing the token
//        return JwtResponseDto.builder()
//                .accessToken(token)
//                .build();
        return null;
    }
}
