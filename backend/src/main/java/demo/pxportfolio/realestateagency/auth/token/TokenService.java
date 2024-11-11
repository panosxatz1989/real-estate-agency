package demo.pxportfolio.realestateagency.auth.token;

import demo.pxportfolio.realestateagency.auth.user.User;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    @Value("${app.security.in-app-token.duration}")
    private Integer tokenDuration;

    public Token createToken(Long userId) {
        Token token = Token.builder()
                .user(User.builder().id(userId).build())
                .token(UUID.randomUUID().toString())
                .requestedAt(LocalDateTime.now())
                .tokenExpiration(LocalDateTime.now().plusDays(tokenDuration))
                .build();
        return tokenRepository.save(token);
    }
}
