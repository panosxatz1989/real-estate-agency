package demo.pxportfolio.realestateagency.auth.role;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/list")
    public List<KeyValueDto> getAllRolesList() {
        return roleService.getAllRolesList();
    }
}