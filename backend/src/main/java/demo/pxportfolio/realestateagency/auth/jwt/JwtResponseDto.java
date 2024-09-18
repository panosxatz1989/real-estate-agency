package demo.pxportfolio.realestateagency.auth.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtResponseDto {

    @JsonProperty("access_token")
    private String accessToken;
}
