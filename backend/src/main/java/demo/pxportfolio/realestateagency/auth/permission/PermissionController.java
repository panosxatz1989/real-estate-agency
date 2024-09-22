package demo.pxportfolio.realestateagency.auth.permission;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    @PreAuthorize("hasAuthority('auth_permission_view')")
    public List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('auth_permission_view')")
    public List<ListDto> getAllPermissionsList() {
        return permissionService.getAllPermissionsList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('auth_permission_view')")
    public Permission getPermissionById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }
}
