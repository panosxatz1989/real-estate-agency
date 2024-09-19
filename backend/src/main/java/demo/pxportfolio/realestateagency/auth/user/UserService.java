package demo.pxportfolio.realestateagency.auth.user;


import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserDto findUserById(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(User.class.getSimpleName(), id.toString()));
        return modelMapper.map(existingUser, UserDto.class);
    }
}
