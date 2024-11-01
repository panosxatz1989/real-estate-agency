package demo.pxportfolio.realestateagency.auth.user;

import demo.pxportfolio.realestateagency.property.Property;
import jakarta.validation.Valid;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('admin:user:view', 'user:user:view')")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserDtoById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:user:view')")
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:user:create')")
    public UserDto createUser(@Valid @RequestBody UserDto dto) {
        return null;
    }

    @PostMapping("/{id}/favourites")
    @PreAuthorize("hasAuthority('user:favourite:create')")
    public UserDto addToFavourites(@PathVariable Long id, @RequestBody Long propertyId) {
        return userService.addToFavourites(id, propertyId);
    }

    @GetMapping("/{id}/favourites")
    @PreAuthorize("hasAuthority('user:favourite:view')")
    public Set<Property> getAllFavourites(@PathVariable Long id) {
        return userService.getAllFavourites(id);
    }
}