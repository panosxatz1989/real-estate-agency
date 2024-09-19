package demo.pxportfolio.realestateagency.auth.user;

import jakarta.persistence.EntityNotFoundException;
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
                .orElseThrow(() -> new EntityNotFoundException(""));
        return modelMapper.map(existingUser, UserDto.class);
    }
}
