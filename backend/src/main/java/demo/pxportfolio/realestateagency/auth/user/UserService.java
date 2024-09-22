package demo.pxportfolio.realestateagency.auth.user;


import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private static final String ENTITY_CLASS = User.class.getSimpleName();

    public UserDto getUserById(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, id.toString()));
        return modelMapper.map(existingUser, UserDto.class);
    }

    public User getUserByUsername(String username) {
        User existingUser = userRepository.findByUsernameOrEmail(username)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, "username", username));
        return existingUser;
    }

    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(u -> modelMapper.map(u, UserDto.class));
    }
}