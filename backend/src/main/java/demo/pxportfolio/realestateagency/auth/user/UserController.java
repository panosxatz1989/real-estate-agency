package demo.pxportfolio.realestateagency.auth.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("(hasAuthority('user:view') and #id == #user.getId()) or hasAuthority('ROLE_ADMIN')")
    public UserDto getUserById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return userService.getUserDtoById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user:view')")
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:create')")
    public UserDto createUser(@Valid @RequestBody UserDto dto) {
        return null;
    }
}