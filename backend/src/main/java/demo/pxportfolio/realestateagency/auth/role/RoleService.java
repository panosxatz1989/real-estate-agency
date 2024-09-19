package demo.pxportfolio.realestateagency.auth.role;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public RoleDto findRoleById(Long id) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(Role.class.getSimpleName(), id.toString()));
        return modelMapper.map(existingRole, RoleDto.class);
    }
}
