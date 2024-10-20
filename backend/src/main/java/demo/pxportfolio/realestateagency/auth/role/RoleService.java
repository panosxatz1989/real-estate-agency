package demo.pxportfolio.realestateagency.auth.role;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private static final String ENTITY_CLASS = Role.class.getSimpleName();

    public List<ListDto> getAllRolesList() {
        return roleRepository.findAll()
                .stream()
                .map(ListDto::new)
                .collect(Collectors.toList());
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }
}
