package demo.pxportfolio.realestateagency.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value("${app.security.jwt.secret-key}")
    private String key;

    @Value("${app.security.jwt.token.expiration}")
    private Long accessTokenExpiration;

    /**
     * Extracts the username from the token.
     *
     * @param token The jwt token.
     * @return String The username extracted from the passed jwt token.
     */
    public String extractUsername(String token) {
        return this.extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts expiration date from the token.
     *
     * @param token The jwt token.
     * @return Date The expiration date from the passed jwt token.
     */
    private Date extractExpiration(String token) {
        return this.extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extract a single claim from the token.
     *
     * @param token         The jwt token.
     * @param claimResolver A lambda that extracts a specific claim from the passed jwt token.
     * @param <T>           The type of the claim.
     * @return T The type of the claim.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    /**
     * Extracts all claims from the token.
     *
     * @param token The jwt token.
     * @return Claims An object representing all the claims.
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Generates a signing key from a secret key constant.
     *
     * @return Key The key as it is parsed from the byte array that our secret key was converted.
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.key);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Generates a json web token with extra claims.
     *
     * @param extraClaims The extra claims we added to the token.
     * @param userDetails An object representing the Spring Security user representation.
     * @return String A jwt token.
     */
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + this.accessTokenExpiration))
                .signWith(this.getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Generates a json web token without extra claims.
     *
     * @param userDetails An object representing the Spring Security user representation.
     * @return String A JWT token.
     */
    public String generateToken(UserDetails userDetails) {
        return this.generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Finds if a token is valid. <br />
     * A token is valid when the subject of the token is the same as the username of Security Context and
     * if the token is not expired.
     *
     * @param token       The jwt token.
     * @param userDetails The representation of the user.
     * @return boolean Returns true if the username is valid and the token is not expired, false otherwise.
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = this.extractUsername(token);
        return username.equals(userDetails.getUsername()) && !this.isTokenExpired(token);
    }

    /**
     * Finds if a token is expired.
     *
     * @param token The jwt token.
     * @return boolean If expiration date is in the past then returns true, otherwise false.
     */
    private boolean isTokenExpired(String token) {
        return this.extractExpiration(token).before(new Date());
    }
}