package demo.pxportfolio.realestateagency.property.favourite;

import demo.pxportfolio.realestateagency.auth.user.User;
import demo.pxportfolio.realestateagency.auth.user.UserService;
import demo.pxportfolio.realestateagency.config.exception.AddToFavouritesException;
import demo.pxportfolio.realestateagency.property.PropertyIntermediateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFavouriteService {

    private final UserService userService;
    private final PropertyIntermediateService propertyIntermediateService;
    private final UserFavouriteRepository userFavouriteRepository;

    public Page<UserFavourite> getAllUsersFavourites(Long userId, Pageable pageable) {
        return userFavouriteRepository.findAllByUserId(userId, pageable);
    }

    public UserFavourite addToFavourites(Long userId, UserFavouriteCreationDto dto, User user) {

        if (userId != user.getId()) {
            throw new AddToFavouritesException("Cannot add to favourites because the logged in user differs from the request user.");
        }

        if (userService.isAdmin(user)) {
            throw new AddToFavouritesException("Admins cannot add properties to favourites.");
        }

        UserFavourite createdUserFavourite = UserFavourite.builder()
                .user(user)
                .property(propertyIntermediateService.getPropertyById(dto.getPropertyId()))
                .shouldNotify(dto.getShouldNotify())
                .build();

        return userFavouriteRepository.save(createdUserFavourite);
    }
}