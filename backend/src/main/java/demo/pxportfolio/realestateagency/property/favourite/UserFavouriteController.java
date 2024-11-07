package demo.pxportfolio.realestateagency.property.favourite;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/{userId}/favourites")
@RequiredArgsConstructor
public class UserFavouriteController {

    private final UserFavouriteService userFavouriteService;

    // TODO - Implement logic here
    @GetMapping
    public Object getAllUsersFavourites() {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserFavourite> addToFavourites(@PathVariable Long userId, @RequestBody UserFavouriteRequestDto dto) {
        // TODO - Return response entity
        // return userFavouriteService.addToFavourites(userId, dto);
        return null;
    }

}
