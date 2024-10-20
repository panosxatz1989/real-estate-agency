package demo.pxportfolio.realestateagency.auth.token;

import demo.pxportfolio.realestateagency.auth.user.User;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;
    private static final Integer TOKEN_DURATION = 1;

    public Token createToken(Long userId) {
        Token token = Token.builder()
                .user(User.builder().id(userId).build())
                .token(UUID.randomUUID().toString())
                .requestedAt(LocalDateTime.now())
                .tokenExpiration(LocalDateTime.now().plusDays(TOKEN_DURATION))
                .build();
        return tokenRepository.save(token);
    }
}
