package demo.pxportfolio.realestateagency.property.favourite;

import demo.pxportfolio.realestateagency.auth.user.User;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/users/{userId}/favourites")
@RequiredArgsConstructor
public class UserFavouriteController {

    private final UserFavouriteService userFavouriteService;

    // TODO - Implement logic here
    @GetMapping
    public Page<UserFavourite> getAllUsersFavourites(@PathVariable Long userId, Pageable pageable) {
        return userFavouriteService.getAllUsersFavourites(userId, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserFavourite> addToFavourites(
            @PathVariable Long userId,
            @Valid @RequestBody UserFavouriteCreationDto dto,
            @AuthenticationPrincipal User user
    ) {
        UserFavourite createdUserFavourite = userFavouriteService.addToFavourites(userId, dto, user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .build()
                .toUri();
        return ResponseEntity.created(location).body(createdUserFavourite);
    }

}
