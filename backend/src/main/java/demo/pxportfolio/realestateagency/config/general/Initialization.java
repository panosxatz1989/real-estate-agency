package demo.pxportfolio.realestateagency.config.general;

import demo.pxportfolio.realestateagency.auth.role.Role;
import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initialization {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        User admin = User.builder()
                .username("administrator")
                .password(passwordEncoder.encode("Admin@2024"))
                .email("example_admin@gmail.com")
                .phone("6972012873")
                .roles(Set.of(Role.builder().id(1L).build()))
                .build();

        User agent = User.builder()
                .username("agent")
                .password(passwordEncoder.encode("Agent@2024"))
                .email("example_agent@gmail.com")
                .phone("6972012873")
                .roles(Set.of(Role.builder().id(3L).build()))
                .build();


        User user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("User@2024"))
                .email("example_user@gmail.com")
                .phone("6972012873")
                .roles(Set.of(Role.builder().id(4L).build()))
                .build();

        userRepository.saveAll(List.of(admin, agent, user));
    }
}
