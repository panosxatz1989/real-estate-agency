package demo.pxportfolio.realestateagency.config.general;

import demo.pxportfolio.realestateagency.auth.role.RoleService;
import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Initialization {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

//        Role roleAdmin = Role.builder()
//                .id(1L)
//                .title("Administrator")
//                .machineName("admin")
//                .build();
//
//        Role roleUser = Role.builder()
//                .id(2L)
//                .title("User")
//                .machineName("user")
//                .build();
//
//        roleRepository.saveAll(List.of(roleAdmin, roleUser));

//        User admin = User.builder()
//                .username("administrator")
//                .password(passwordEncoder.encode("Admin@2024"))
//                .email("example_admin@gmail.com")
//                .phone("6972012873")
//                .role(roleService.getRoleById(1L))
//                .active(true)
//                .build();

//        User user = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("User@2024"))
//                .email("example_user@gmail.com")
//                .phone("6972012873")
//                .role(roleUser)
//                .build();

//        userRepository.saveAll(List.of(admin));
    }
}
