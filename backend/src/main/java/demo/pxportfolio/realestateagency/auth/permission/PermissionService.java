package demo.pxportfolio.realestateagency.auth.permission;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private static final String ENTITY_CLASS = Permission.class.getSimpleName();

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public List<ListDto> getAllPermissionsList() {
        return permissionRepository.findAll()
                .stream()
                .map(ListDto::new)
                .collect(Collectors.toList());
    }

    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }
}
