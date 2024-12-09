package demo.pxportfolio.realestateagency.auth.role;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private static final String ENTITY_CLASS = Role.class.getSimpleName();

    @Cacheable(value = "roles-list")
    public List<KeyValueDto> getAllRolesList() {
        return roleRepository.findAll()
                .stream()
                .map(KeyValueDto::new)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }
}
