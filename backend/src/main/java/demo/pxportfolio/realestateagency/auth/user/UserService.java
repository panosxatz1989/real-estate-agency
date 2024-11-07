package demo.pxportfolio.realestateagency.auth.user;

import demo.pxportfolio.realestateagency.auth.role.RoleService;
import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.property.Property;
import demo.pxportfolio.realestateagency.property.PropertyService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    // private final PropertyService propertyService;
    private final RoleService roleService;
    private static final String ENTITY_CLASS = User.class.getSimpleName();
    private static final String ADMIN_NAME = "administrator";

    public UserDto getUserDtoById(Long id) {
        return modelMapper.map(this.getUserById(id), UserDto.class);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsernameOrEmail(username)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, "username", username));
    }

    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(u -> modelMapper.map(u, UserDto.class));
    }

    public Boolean isAdmin(User user) {
        return user.getRole()
                .getMachineName()
                .equals(ADMIN_NAME);
    }
}